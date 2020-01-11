package sorting.applications;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Select {
    public static int select(int[] a, int k) {
        return select(a, k, 0, a.length - 1);
    }

    private static int select(int[] a, int k, int lo, int hi) {
        if (lo >= hi) return a[k];
        int j = partition(a, lo, hi);
        if (j == k) return a[k];
        else if (j > k) return select(a, k, lo, j - 1);
        else return select(a, k, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exchange(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        int k = StdIn.readInt();
        int[] a = StdIn.readAllInts();
        StdOut.println(select(a, k));
    }
}
