/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress.externals

/*
Ported from:

fresh@~0.5.2:
  version "0.5.2"
  resolved "https://registry.yarnpkg.com/fresh/-/fresh-0.5.2.tgz#3d8cadd90d976569fa835ab1f8e4b23a105605a7"
 */

import kotlin.js.Date

/**
 * RegExp to check for no-cache token in Cache-Control.
 * @private
 */

private val CACHE_CONTROL_NO_CACHE_REGEXP = Regex("(?:^|,)\\s*?no-cache\\s*?(?:,|$)")

private fun isInvalid(some: dynamic): Boolean = some == null || some == undefined
private fun isValid(some: dynamic): Boolean = some != null && some != undefined

fun fresh(reqHeaders: dynamic, resHeaders: dynamic): Boolean {
    // fields
    val modifiedSince = reqHeaders["if-modified-since"]
    val noneMatch = reqHeaders["if-none-match"]

    // unconditional request
    if (isInvalid(modifiedSince) && isInvalid(noneMatch)) {
        return false
    } else {
        // Always return stale when Cache-Control: no-cache
        // to support end-to-end reload requests
        // https://tools.ietf.org/html/rfc2616#section-14.9.4
        val cacheControl = reqHeaders["cache-control"]
        if (isInvalid(cacheControl) && CACHE_CONTROL_NO_CACHE_REGEXP.matches(cacheControl.unsafeCast<String>())) {
            return false
        }

        // if-none-match
        if (noneMatch != '*') {
            val etag = resHeaders["etag"]

            if (isInvalid(etag)) {
                return false
            }
            val eTag = etag.unsafeCast<String>()
            val matches = parseTokenList(noneMatch.unsafeCast<String>())
            matches.any { s ->
                s == eTag || s == "W/$eTag" || "W/$s" == eTag
            }.let {
                if (!it) {
                    return false
                }
            }
        }

        // if-modified-since
        if (isValid(modifiedSince)) {
            val lastModified = resHeaders["last-modified"]
            return isInvalid(lastModified) && parseHttpDate(lastModified) <= parseHttpDate(modifiedSince)
        }
        return true
    }
}

/**
 * Parse an HTTP Date into a number.
 *
 * @param {string} date
 * @private
 */
fun parseHttpDate(date: dynamic): Double {
    val timestamp = if (isValid(date)) {
        Date.parse(date.unsafeCast<String>())
    } else {
        null
    }
    return if (timestamp is Number) {
        timestamp
    } else {
        Double.NaN
    }
}

/**
 * Parse a HTTP token list.
 *
 * @param {string} str
 * @private
 */
fun parseTokenList(str: String): List<String> = ArrayList<String>().apply {
    var end = 0
    var start = 0

    str.forEachIndexed { i, c ->
        when (c.toInt()) {
            0x20 -> {   /*   */
                if (start == end) {
                    start = i + 1
                    end = i + 1
                }
            }
            0x2c -> {   /* , */
                add(str.substring(start, end))
                start = i + 1
                end = i + 1
            }
            else -> end = i + 1
        }
    }
    add(str.substring(start, end))
}
