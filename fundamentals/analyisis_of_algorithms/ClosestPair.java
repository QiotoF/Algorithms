package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ClosestPair {
    public static void main(String[] args) {
        double[] a = StdIn.readAllDoubles();
        Arrays.sort(a);
        double f = a[0];
        double s = a[1];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] < s - f) {
                s = a[i + 1];
                f = a[i];
            }
        }
        StdOut.println(f + " " + s);
    }
}
