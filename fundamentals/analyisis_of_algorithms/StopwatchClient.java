package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class StopwatchClient {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-1000000, 1000000);
        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(count + " triples " + time + " seconds");
    }
}
