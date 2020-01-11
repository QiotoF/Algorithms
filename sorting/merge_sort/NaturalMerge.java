package sorting.merge_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class NaturalMerge {
    private static Comparable[] aux;

//    public static void sort(Comparable[] array) {
//        if (array == null || array.length == 1) {
//            return;
//        }
//        aux = new Comparable[array.length];
//
//        int low = 0;
//        int middle = 0;
//        int high = 0;
//
//        boolean secondSubArray = false;
//
//        for (int i = 1; i < array.length; i++) {
//
//            if (array[i].compareTo(array[i - 1]) < 0) {
//                if (!secondSubArray) {
//                    middle = i - 1;
//                    secondSubArray = true;
//                } else {
//                    high = i - 1;
//                    merge(array, low, middle, high);
//                    middle = high;
//                }
//            }
//        }
//
//        if (high != array.length - 1) {
//            merge(array, low, middle, array.length - 1);
//        }
//    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        int i;
        int j = 0;
        boolean secondSubArray = false;
        while (j < n - 1) {
            i = j;
            while (i < n - 1 && less(a[i], a[i + 1])) {
                i++;
            }
//            if (secondSubArray)
//                merge(a, );
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
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
