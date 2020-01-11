package fundamentals.data_abstraction

import edu.princeton.cs.algs4.StdOut

fun main(args: Array<String>) {
    val a = Integer.parseInt(args[0])
    val b = Integer.parseInt(args[1])
    val c = Integer.parseInt(args[2])
    if (a == b && a == c) {
        StdOut.print("equal")
    } else {
        StdOut.print("not equal")
    }
}