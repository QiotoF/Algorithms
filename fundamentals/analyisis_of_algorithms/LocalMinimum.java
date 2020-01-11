package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class LocalMinimum {

    public static double localMin(double[] a) {
        return localMin(a, 0, a.length - 1);
    }

    private static double localMin(double[] a, int l, int r) {
        if (r - l + 1 == 1)
            return a[0];
        if (r - l + 1 == 2)
            if (a[0] > a[1]) return a[1];
            else return a[0];
        int mid = (r - l) / 2;
        if (a[mid - 1] > a[mid] && a[mid] < a[mid+1])
            return a[mid];
        if (a[mid - 1] < a[mid])
            return localMin(a, l, mid - 1);
        return localMin(a, l + 1, r);
    }

    public static void main(String[] args) {
        double[] a = StdIn.readAllDoubles();
        StdOut.println(localMin(a));
    }
}
