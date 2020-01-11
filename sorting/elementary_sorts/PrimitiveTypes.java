package sorting.elementary_sorts;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class PrimitiveTypes {
    public static double time(String alg, int[] a) {
        Integer[] b = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(b);
        if (alg.equals("InsertionInt")) InsertionInt.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int trials) {
        double total = 0.0;
        int[] a = new int[n];
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = (int) StdRandom.uniform(0.0, 1.0);
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = StdIn.readString();
        String alg2 = StdIn.readString();
        int n = StdIn.readInt();
        int trials = StdIn.readInt();
        double time1 = timeRandomInput(alg1, n, trials);
        double time2 = timeRandomInput(alg2, n, trials);
        double ratio = time2 / time1;
        StdOut.printf("For %d random Doubles\n    %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s\n", ratio, alg2);
    }
}
