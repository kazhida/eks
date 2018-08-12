/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress.externals

/*
Ported from:

parseurl@^1.3.2:
  version "1.3.2"
  resolved "https://registry.yarnpkg.com/parseurl/-/parseurl-1.3.2.tgz#fc289d4ed8993119460c156253262cdc8de65bf3"

 */

fun parseurl(req: dynamic): Url? {
    val reqUrl = req.url
    return if (reqUrl == null || reqUrl == undefined) {
        null
    } else {
        val url = reqUrl.unsafeCast<String>()

        val parsed = req._parsedUrl.unsafeCast<Url?>()
        if (fresh(url, parsed)) {
            parsed
        } else {
            fastparse(url).also {
                req._parsedUrl = it
            }
        }
    }
}


//function originalurl (req) {
//    var url = req.originalUrl
//
//    if (typeof url !== 'string') {
//        // Fallback
//        return parseurl(req)
//    }
//
//    var parsed = req._parsedOriginalUrl
//
//    if (fresh(url, parsed)) {
//        // Return cached URL parse
//        return parsed
//    }
//
//    // Parse the URL
//    parsed = fastparse(url)
//    parsed._raw = url
//
//    return (req._parsedOriginalUrl = parsed)
//};

/**
 * Parse the `str` url with fast-path short-cut.
 *
 * @param {string} str
 * @return {Object}
 * @private
 */
private fun fastparse(str: Any?): Url? {
    return if (str is String && str.startsWith("/")) {
        var pathname: String? = str
        var query: String? = null
        var search: String? = null
        // This takes the regexp from https://github.com/joyent/node/pull/7878
        // Which is /^(\/[^?#\s]*)(\?[^#\s]*)?$/
        // And unrolls it into a for loop
        str.forEachIndexed { i, c ->
            when (c.toInt()) {
                0x3f -> {
                    if (search == null) {
                        pathname = str.substring(0, i)
                        query = str.substring(i + 1)
                        search = str.substring(i)
                    }
                }
                0x09, /* \t */
                0x0a, /* \n */
                0x0c, /* \f */
                0x0d, /* \r */
                0x20, /*    */
                0x23, /* #  */
                0xa0,
                0xfeff -> NodeUrl.parse(str)
            }
        }
        return UrlImpl(
                _raw = str,
                path = str,
                href = str,
                pathname = pathname,
                query = query,
                search = search
        )
    } else {
        NodeUrl.parse(str)
    }
}

private fun fresh(url: String, parsedUrl: Url?): Boolean = parsedUrl?._raw == url
