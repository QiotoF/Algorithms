package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class CostOfConstruction {
    static class Heap {
        public static double sort(Comparable[] a) {
            int n = a.length;
            Stopwatch timer = new Stopwatch();
            for (int k = n / 2; k >= 1; k--) {
                sink(a, k, n);
            }
            double constructionTime = timer.elapsedTime();
            while (n > 1) {
                exch(a, 1, n--);
                sink(a, 1, n);
            }
            double sortTime = timer.elapsedTime();
            return constructionTime / sortTime;
        }

        private static void sink(Comparable[] a, int k, int n) {
            while (k * 2 <= n) {
                int j = k * 2;
                if (j < n && less(a, j, j + 1)) j++;
                if (less(a, j, k)) break;
                exch(a, k, j);
                k = j;
            }
        }

        private static boolean less(Comparable[] a, int i, int j) {
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

    private static void runExperiments(int trials) {
        for (int n = 1000; n <= 1000000000; n *= 1000) {
            double constructionCost = 0;
            for (int t = 0; t < trials; t++) {
                Comparable[] a = new Comparable[n];
                for (int i = 0; i < n; i++) a[i] = StdRandom.uniform();
                constructionCost += Heap.sort(a);
            }
            constructionCost /= trials;
            StdOut.println(n + " " + constructionCost*100+"%");
        }
    }

    public static void main(String[] args) {
        int trials = StdIn.readInt();
        runExperiments(trials);
    }
}
