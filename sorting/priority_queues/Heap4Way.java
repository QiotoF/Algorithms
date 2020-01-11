package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Heap4Way {
    private static int compares;

    public static int sort(Comparable[] a) {
        int n = a.length;
        compares = 0;
        for (int k = n / 4; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
        return compares;
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (k * 4 - 2 <= n) {
            int j = k * 4 - 2;
            if (k * 4 - 1 <= n && less(a, j, k * 4 - 1)) j = k * 4 - 1;
            if (k * 4 <= n && less(a, j, k * 4)) j = k * 4;
            if (k * 4 + 1 <= n && less(a, j, k * 4 + 1)) j = k * 4 + 1;
            if (less(a, j, k)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        compares++;
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    private static void show(Comparable[] a) {
        for (Comparable c : a)
            StdOut.print(c + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 2; i <= a.length; i++)
            if (less(a, i, i - 1)) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

