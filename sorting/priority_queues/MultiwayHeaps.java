package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MultiwayHeaps {
    public static void main(String[] args) {
        int trials = StdIn.readInt();
        runExperiments(trials);
    }

    private static void runExperiments(int trials) {
        for (int n = 1000; n <= 1000000000; n *= 1000) {
            int standardHeapCompares = 0;
            int heap3WayCompares = 0;
            int heap4WayCompares = 0;
            for (int t = 0; t < trials; t++) {
                Comparable[] a = generateRandomArray(n);
                standardHeapCompares += Heap.sort(a);
                heap3WayCompares += Heap3Way.sort(a);
                heap4WayCompares += Heap4Way.sort(a);
            }
            standardHeapCompares /= trials;
            heap3WayCompares /= trials;
            heap4WayCompares /= trials;
            showResults(n, standardHeapCompares, heap3WayCompares, heap4WayCompares);
        }
    }

    private static void showResults(int n, int standardHeapCompares, int heap3WayCompares, int heap4WayCompares) {
        StdOut.printf("n = %10d: Standard: %10d 3Way: %10d  4Way: %10d\n", n, standardHeapCompares, heap3WayCompares, heap4WayCompares);
    }

    private static Comparable[] generateRandomArray(int n) {
        Comparable[] a = new Comparable[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }
}
