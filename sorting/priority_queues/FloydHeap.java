package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class FloydHeap {
    private static int compares;

    public static int sort(Comparable[] a) {
        int n = a.length;
        compares = 0;
        for (int k = n / 2; k >= 1; k--) {
            swim(a, sink(a, k, n));
        }
        while (n > 1) {
            exch(a, 1, n--);
            swim(a, sink(a, 1, n));
        }
        return compares;
    }

    private static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a, k / 2, k)) {
            exch(a, k / 2, k);
            k /= 2;
        }
        compares++;
    }

    private static int sink(Comparable[] a, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(a, j, j + 1)) j++;
            exch(a, k, j);
            k = j;
        }
        return k;
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

class FloydMethod {
    public static void main(String[] args) {
        int trials = StdIn.readInt();
        runExperiments(trials);
    }

    private static void runExperiments(int trials) {
        for (int n = 1000; n <= 1000000000; n *= 1000) {
            int floydCompares = 0;
            int standardCompares = 0;
            for (int t = 0; t < trials; t++) {
                Comparable[] a = generateRandomArray(n);
                floydCompares += FloydHeap.sort(a);
                standardCompares += Heap.sort(a);
            }
            floydCompares /= trials;
            standardCompares /= trials;
            showResults(n, floydCompares, standardCompares);
        }
    }

    private static void showResults(int n, int floydCompares, int standartCompares) {
        StdOut.printf("n = %10d: Floyd: %10d Standart: %10d\n", n, floydCompares, standartCompares);
    }

    private static Comparable[] generateRandomArray(int n) {
        Comparable[] a = new Comparable[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }
}
