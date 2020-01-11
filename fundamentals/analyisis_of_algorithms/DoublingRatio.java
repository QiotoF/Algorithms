package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatio {
    public static double timeTrial(int n) {
        int MAX = 1000000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int count = TwoSumFaster.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int n = 250; true; n *= 2) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f ", n, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }

//        fixedCapacityStackOfIntsTest();
//        fixedCapacityStackTest();
    }

    public static void fixedCapacityStackOfIntsTest() {
        long n = 10000000000L;
        FixedCapacityStackOfInts stack = new FixedCapacityStackOfInts(100);
        Stopwatch timer = new Stopwatch();
        for (long i = 0L; i < n; i++) {
            stack.push(228);
            stack.pop();
        }
        double time = timer.elapsedTime();
        StdOut.printf("%7d %7.1f \n", n, time);
    }

    public static void fixedCapacityStackTest() {
        int n = 1000000000;
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(100);
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < n; i++) {
            stack.push(228);
            stack.pop();
        }
        double time = timer.elapsedTime();
        StdOut.printf("%7d %7.1f \n", n, time);
    }
}
