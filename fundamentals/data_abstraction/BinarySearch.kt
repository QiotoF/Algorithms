package fundamentals.data_abstraction

fun indexOf(a: Array<Int>, key: Int): Int {
    var lo = 0
    var hi = a.size - 1
    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2
        when {
            a[mid] > key -> hi = mid - 1
            a[mid] < key -> lo = mid + 1
            else -> return mid
        }
    }
    return -1
}

fun indexOf(a: Array<Int>, key: Int, lo: Int = 0, hi: Int = a.size - 1): Int {
    if (lo > hi) return -1
    val mid = lo + (hi - lo) / 2
    return when {
        a[mid] > key -> indexOf(a, key, lo, mid - 1)
        a[mid] < key -> indexOf(a, key, mid + 1, hi)
        else -> mid
    }
}

fun main() {

}