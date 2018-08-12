/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress.externals

/*
Ported from:

"statuses@>= 1.4.0 < 2", "statuses@>= 1.5.0 < 2", statuses@^1.5.0:
  version "1.5.0"
  resolved "https://registry.yarnpkg.com/statuses/-/statuses-1.5.0.tgz#161c7dac177659fd9811f43771fa99381478628c"
 */

val STATUS_CODES = mapOf(
        Pair(100, "Continue"),
        Pair(101, "Switching Protocols"),
        Pair(102, "Processing"),
        Pair(103, "Early Hints"),
        Pair(200, "OK"),
        Pair(201, "Created"),
        Pair(202, "Accepted"),
        Pair(203, "Non-Authoritative Information"),
        Pair(204, "No Content"),
        Pair(205, "Reset Content"),
        Pair(206, "Partial Content"),
        Pair(207, "Multi-Status"),
        Pair(208, "Already Reported"),
        Pair(226, "IM Used"),
        Pair(300, "Multiple Choices"),
        Pair(301, "Moved Permanently"),
        Pair(302, "Found"),
        Pair(303, "See Other"),
        Pair(304, "Not Modified"),
        Pair(305, "Use Proxy"),
        Pair(306, "(Unused)"),
        Pair(307, "Temporary Redirect"),
        Pair(308, "Permanent Redirect"),
        Pair(400, "Bad Request"),
        Pair(401, "Unauthorized"),
        Pair(402, "Payment Required"),
        Pair(403, "Forbidden"),
        Pair(404, "Not Found"),
        Pair(405, "Method Not Allowed"),
        Pair(406, "Not Acceptable"),
        Pair(407, "Proxy Authentication Required"),
        Pair(408, "Request Timeout"),
        Pair(409, "Conflict"),
        Pair(410, "Gone"),
        Pair(411, "Length Required"),
        Pair(412, "Precondition Failed"),
        Pair(413, "Payload Too Large"),
        Pair(414, "URI Too Long"),
        Pair(415, "Unsupported Media Type"),
        Pair(416, "Range Not Satisfiable"),
        Pair(417, "Expectation Failed"),
        Pair(418, "I'm a teapot"),
        Pair(421, "Misdirected Request"),
        Pair(422, "Unprocessable Entity"),
        Pair(423, "Locked"),
        Pair(424, "Failed Dependency"),
        Pair(425, "Unordered Collection"),
        Pair(426, "Upgrade Required"),
        Pair(428, "Precondition Required"),
        Pair(429, "Too Many Requests"),
        Pair(431, "Request Header Fields Too Large"),
        Pair(451, "Unavailable For Legal Reasons"),
        Pair(500, "Internal Server Error"),
        Pair(501, "Not Implemented"),
        Pair(502, "Bad Gateway"),
        Pair(503, "Service Unavailable"),
        Pair(504, "Gateway Timeout"),
        Pair(505, "HTTP Version Not Supported"),
        Pair(506, "Variant Also Negotiates"),
        Pair(507, "Insufficient Storage"),
        Pair(508, "Loop Detected"),
        Pair(509, "Bandwidth Limit Exceeded"),
        Pair(510, "Not Extended"),
        Pair(511, "Network Authentication Required")
)

// array of status codes
//status.codes = populateStatusesMap(status, codes)

object Status {
    val redirects = listOf(
            300,
            301,
            302,
            303,
            305,
            307,
            308
    )
    val empties = listOf(
            204,
            205,
            304
    )
    val retries = listOf(
            502,
            503,
            504
    )
}

/**
 * Populate the statuses map for given codes.
 * @private
 */

//function populateStatusesMap (statuses, codes) {
//    var arr = []
//
//    Object.keys(codes).forEach(function forEachCode (code) {
//        var message = codes[code]
//        var status = Number(code)
//
//        // Populate properties
//        statuses[status] = message
//        statuses[message] = status
//        statuses[message.toLowerCase()] = status
//
//        // Add to array
//        arr.push(status)
//    })
//
//    return arr
//}

/**
 * Get the status code.
 *
 * Given a number, this will throw if it is not a known status
 * code, otherwise the code will be returned. Given a string,
 * the string will be parsed for a number and return the code
 * if valid, otherwise will lookup the code assuming this is
 * the status message.
 *
 * @param {string|number} code
 * @returns {number}
 * @public
 */
