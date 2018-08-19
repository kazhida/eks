/*
 * ekspress
 *
 * Copyright (C) 2018- kazhida@abplus.com
 * Apache License 2.0
 */
package ekspress.externals


/*
Ported from:

accepts@^1.3.5:
  version "1.3.5"
  resolved "https://registry.yarnpkg.com/accepts/-/accepts-1.3.5.tgz#eb777df6011723a3b14e8a72c0805c8e86746bd2"
  dependencies:
    mime-types "~2.1.18"
    negotiator "0.6.1"
 */

/*!
 * accepts
 * Copyright(c) 2014 Jonathan Ong
 * Copyright(c) 2015 Douglas Christopher Wilson
 * MIT Licensed
 */

/**
 * Create a new Accepts object for the given req.
 *
 * @param {object} req
 * @public
 */
class Accepts(req: dynamic) {

    val headers = req.headers
    val negotiator = Negotiator(req)

    /**
     * Return accepted languages or best fit based on `langs`.
     *
     * Given `Accept-Language: en;q=0.8, es, pt`
     * an array sorted by quality is returned:
     *
     *     ['es', 'pt', 'en']
     *
     * @param {String|Array} langs...
     * @return {Array|String}
     * @public
     */
    fun languages(args: Array<out String>): List<String> {

//Accepts.prototype.lang =
//Accepts.prototype.langs =
//Accepts.prototype.language =
//Accepts.prototype.languages = function (languages_) {
//    var languages = languages_
//
//    // no languages, return all requested languages
//    if (!languages || languages.length === 0) {
//        return this.negotiator.languages()
//    }
//
//    return this.negotiator.languages(languages)[0] || false
//}
        return false
    }

    fun encodings(args: Array<out String>): Boolean {
        // todo
        /**
         * Return accepted encodings or best fit based on `encodings`.
         *
         * Given `Accept-Encoding: gzip, deflate`
         * an array sorted by quality is returned:
         *
         *     ['gzip', 'deflate']
         *
         * @param {String|Array} encodings...
         * @return {String|Array}
         * @public
         */

//Accepts.prototype.encoding =
//Accepts.prototype.encodings = function (encodings_) {
//    var encodings = encodings_
//
//    // support flattened arguments
//    if (encodings && !Array.isArray(encodings)) {
//        encodings = new Array(arguments.length)
//        for (var i = 0; i < encodings.length; i++) {
//            encodings[i] = arguments[i]
//        }
//    }
//
//    // no encodings, return all requested encodings
//    if (!encodings || encodings.length === 0) {
//        return this.negotiator.encodings()
//    }
//
//    return this.negotiator.encodings(encodings)[0] || false
//}
        return false
    }

    /**
     * Return accepted charsets or best fit based on `charsets`.
     *
     * Given `Accept-Charset: utf-8, iso-8859-1;q=0.2, utf-7;q=0.5`
     * an array sorted by quality is returned:
     *
     *     ['utf-8', 'utf-7', 'iso-8859-1']
     *
     * @param {String|Array} charsets...
     * @return {String|Array}
     * @public
     */
    fun charsets(args: Array<out String>): List<String>? {
        if (args.isEmpty()) {
            negotiator.charsets(null)
        } else {
            this.negotiator.charsets(args).
        }

//Accepts.prototype.charset =
//Accepts.prototype.charsets = function (charsets_) {
//    var charsets = charsets_
//
//    // support flattened arguments
//    if (charsets && !Array.isArray(charsets)) {
//        charsets = new Array(arguments.length)
//        for (var i = 0; i < charsets.length; i++) {
//            charsets[i] = arguments[i]
//        }
//    }
//
//    // no charsets, return all requested charsets
//    if (!charsets || charsets.length === 0) {
//        return this.negotiator.charsets()
//    }
//
//    return this.negotiator.charsets(charsets)[0] || false
//}
        return false
    }

    fun types(args: Array<out String>): Boolean {
        // todo
        /**
         * Check if the given `type(s)` is acceptable, returning
         * the best match when true, otherwise `undefined`, in which
         * case you should respond with 406 "Not Acceptable".
         *
         * The `type` value may be a single mime type string
         * such as "application/json", the extension name
         * such as "json" or an array `["json", "html", "text/plain"]`. When a list
         * or array is given the _best_ match, if any is returned.
         *
         * Examples:
         *
         *     // Accept: text/html
         *     this.types('html');
         *     // => "html"
         *
         *     // Accept: text/ *, application/json
         *     this.types('html');
         *     // => "html"
         *     this.types('text/html');
         *     // => "text/html"
         *     this.types('json', 'text');
         *     // => "json"
         *     this.types('application/json');
         *     // => "application/json"
         *
         *     // Accept: text/ *, application/json
         *     this.types('image/png');
         *     this.types('png');
         *     // => undefined
         *
         *     // Accept: text/ *;q=.5, application/json
         *     this.types(['html', 'json']);
         *     this.types('html', 'json');
         *     // => "json"
         *
         * @param {String|Array} types...
         * @return {String|Array|Boolean}
         * @public
         */

//Accepts.prototype.type =
//Accepts.prototype.types = function (types_) {
//    var types = types_
//
//    // support flattened arguments
//    if (types && !Array.isArray(types)) {
//        types = new Array(arguments.length)
//        for (var i = 0; i < types.length; i++) {
//                types[i] = arguments[i]
//            }
//        }
//
//        // no types, return all requested types
//        if (!types || types.length === 0) {
//            return this.negotiator.mediaTypes()
//        }
//
//        // no accept header, return first given type
//        if (!this.headers.accept) {
//            return types[0]
//        }
//
//    var mimes = types.map(extToMime)
//    var accepts = this.negotiator.mediaTypes(mimes.filter(validMime))
//    var first = accepts[0]
//
//    return first
//    ? types[mimes.indexOf(first)]
//    : false
//}
        return false
    }
}






/**
 * Convert extnames to mime.
 *
 * @param {String} type
 * @return {String}
 * @private
*/

//function extToMime (type) {
//    return type.indexOf('/') === -1
//    ? mime.lookup(type)
//    : type
//}

/**
 * Check if mime is valid.
 *
 * @param {String} type
 * @return {String}
 * @private
*/

//function validMime (type) {
//    return typeof type === 'string'
//}
