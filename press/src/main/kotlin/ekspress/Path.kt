package ekspress

/**
 * PATHを扱うためのユーティリティクラス
 *
 * @args src PATHを"/"で区切った文字列リスト
 */
class Path private constructor(src: List<String>) {

    companion object {
        /**
         * 文字列のPATHを"/"区切りで分離したリストを作る関数
         * 空欄は除去される
         */
        private fun split(path: String): List<String> = path.split("/").filter { it.isNotBlank() }
    }

    /**
     * こちらが普通に使用されるコンストラクタ
     *
     * @args path PATH文字列
     */
    constructor(path: String) : this(split(path))

    /**
     * ディレクトリ階層
     */
    private val directories: List<String> = src

    /**
     * リストの先頭を返すプロパティ
     * 空の場合はnullを返す
     */
    @Suppress("unused")
    val head: String? get() = if (directories.isEmpty()) null else directories[0]

    /**
     * リストの先頭を除いた残りを生成して返すプロパティ
     */
    @Suppress("unused")
    val rest: Path get() = Path(directories.slice(1..directories.size))

    /**
     * 渡されたPATH文字列との先頭一致を判別するメソッド
     *
     * @args path PATH文字列
     * @return 先頭一致していればtrue
     */
    @Suppress("unused")
    fun contains(path: String): Boolean = contains(Path(path))

    /**
     * 渡されたPATHとの先頭一致を判別するメソッド
     *
     * @args path PATHを"/"で分離したリスト
     * @return 先頭一致していればtrue
     */
    @Suppress("scope")
    fun contains(path: Path): Boolean {
        if (path.directories.size > this.directories.size) {
            return false
        } else {
            path.directories.forEachIndexed { index, dir ->
                if (dir != directories[index]) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * 自分自身に渡されたパスを連結した新しいPathを返すメソッド
     *
     * @args path 末尾に連結するリスト
     * @return 連結された新しいリスト
     */
    fun concat(path: Path): Path {
        val cat = ArrayList<String>().apply {
            addAll(directories)
            addAll(path.directories)
        }
        return Path(cat)
    }

    /**
     * 渡されたpathとの一致と、パラメータの収集を行うメソッド
     *
     * @args path 判定の大詔となるPATH
     * @return 一致していなければnull、一致していたときはパラメータのmapを返す
     */
    @Suppress("unused")
    fun matchParams(path: Path): Map<String, String>? {
        return if (path.directories.size != directories.size) {
            null
        } else {
            HashMap<String, String>().apply {
                directories.forEachIndexed { index, d ->
                    val s = path.directories[index]
                    if (d.startsWith(":") && d.length > 1) {
                        val p = d.substring(1)
                        put(p, s)
                    } else if (s != d) {
                        return null
                    }
                }
            }
        }
    }

    private val pathString: String by lazy { directories.joinToString("/") }

    fun equals(other: String): Boolean = pathString == other
}
