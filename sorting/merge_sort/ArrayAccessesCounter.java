package sorting.merge_sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ArrayAccessesCounter {

    private enum MergeType {
        TD, BU
    }

    private static class Merge {
        static int arrayAccesses = 0;
        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            int n = a.length;
            aux = new Comparable[n];
            sort(a, 0, n - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (lo >= hi) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo;
            int j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            arrayAccesses += 2 * (hi - lo + 1);

            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                    arrayAccesses += 2;
                } else if (j > hi) {
                    a[k] = aux[i++];
                    arrayAccesses += 2;
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    arrayAccesses += 4;
                } else {
                    a[k] = aux[i++];
                    arrayAccesses += 2;
                }
            }
        }

        private static boolean less(Comparable a, Comparable b) {
            return a.compareTo(b) < 0;
        }

        private static void show(Comparable[] a) {
            for (Comparable c : a)
                StdOut.print(c + " ");
            StdOut.println();
        }

        private static boolean isSorted(Comparable[] a) {
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1])) return false;
            return true;
        }

        public static void main(String[] args) {
            String[] a = StdIn.readAllStrings();
            sort(a);
            assert isSorted(a);
            show(a);
        }
    }

    private static class MergeBU {
        public static int arrayAccesses = 0;

        private static Comparable[] aux;

        public static void sort(Comparable[] a) {
            int n = a.length;
            aux = new Comparable[n];
            for (int len = 1; len < n; len *= 2) {
                for (int lo = 0; lo < n - len; lo += len + len)
                    merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
            }
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo;
            int j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            arrayAccesses += 2 * (hi - lo + 1);

            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                    arrayAccesses += 2;
                } else if (j > hi) {
                    a[k] = aux[i++];
                    arrayAccesses += 2;
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    arrayAccesses += 4;
                } else {
                    a[k] = aux[i++];
                    arrayAccesses += 2;
                }
            }
        }

        private static boolean less(Comparable a, Comparable b) {
            return a.compareTo(b) < 0;
        }

        private static void exchange(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        private static void show(Comparable[] a) {
            for (Comparable c : a)
                StdOut.print(c + " ");
            StdOut.println();
        }

        private static boolean isSorted(Comparable[] a) {
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1])) return false;
            return true;
        }

        public static void main(String[] args) {
            String[] a = StdIn.readAllStrings();
            sort(a);
            assert isSorted(a);
            show(a);
        }
    }


    public static void main(String[] args) {
        StdDraw.setXscale(0, 513);
        StdDraw.setYscale(0, 30000);
        StdDraw.setPenRadius(0.003);
        for (int n = 1; n <= 512; n++) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(n, test(n, 100, MergeType.TD));
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(n, test(n, 100, MergeType.BU));
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(n, 6 * n * (Math.log10(n) / Math.log10(2)));
        }
    }

    private static double test(int n, int trials, MergeType type) {
        Double[] a = new Double[n];
        double arrayAccesses = 0;
        for (int t = 0; t < trials; t++) {
            generateArray(a, n);
            if (type == MergeType.TD) {
                Merge.sort(a);
                arrayAccesses += Merge.arrayAccesses;
                Merge.arrayAccesses = 0;
            } else {
                MergeBU.sort(a);
                arrayAccesses += MergeBU.arrayAccesses;
                MergeBU.arrayAccesses = 0;
            }
        }
        arrayAccesses /= trials;
        return arrayAccesses;
    }

    private static void generateArray(Double[] a, int n) {
//        for (int i = 0; i < n / 2; i++) {
//            a[i] = (double) (i * 2);
//        }
//        for (int i = n / 2; i < n; i++) {
//            a[i] = (double) ((i - (n / 2)) * 2 + 1);
//        }
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(0.0, 1.0);
        }
    }
}
