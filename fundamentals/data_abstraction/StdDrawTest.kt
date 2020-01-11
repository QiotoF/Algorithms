package fundamentals.data_abstraction

import edu.princeton.cs.algs4.Draw
import edu.princeton.cs.algs4.StdRandom

fun main() {

    functionValues()
    arrayOfRandomValues()
}


fun arrayOfRandomValues() {
    val draw = Draw()
    val n = 1000
    val a = DoubleArray(n)
    for (i in 0 until n)
        a[i] = StdRandom.uniform()
    a.sort()
    for (i in 0 until n) {
        val x = 1.0 * i / n
        val y = a[i] / 2.0
        val rw = 0.5 / n
        val rh = a[i] / 2.0
        draw.filledRectangle(x, y, rw, rh)
    }
}

fun functionValues() {
    val draw = Draw()
    val n = 100.0
    draw.penColor = Draw.BLUE
    draw.setXscale(0.0, n)
    draw.setYscale(0.0, n * n)
    draw.penRadius = 0.01
    for (i in 1..100) {
        draw.point(i.toDouble(), i.toDouble())
        draw.point(i.toDouble(), (i * i).toDouble())
        draw.point(i.toDouble(), i * Math.log(i.toDouble()))
        draw.point(i.toDouble(), (i * 2).toDouble())
    }
}

