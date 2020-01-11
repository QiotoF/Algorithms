package sorting.elementary_sorts;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class GeometricIncrements {

    private static void sort(double[] a, int t) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h *= t;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / t;
        }
    }

    private static boolean less(double a, double b) {
        return a < b;
    }

    private static void exchange(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static double time(double[] a, int t) {
        Stopwatch timer = new Stopwatch();
        sort(a, t);
        return timer.elapsedTime();
    }

    private static double[] randomArray(int n) {
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(0.0, 1.0);
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int trials = 10;
        for (int t = 2; ; t++) {
            double sum = 0;
            for (int i = 0; i < trials; i++) {
                double[] a = randomArray(n);
                sum += time(a, t);
            }
            StdOut.println("t = " + t + " time: " + sum / trials);
        }

    }
}
