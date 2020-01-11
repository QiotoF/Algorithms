package sorting.elementary_sorts;

import edu.princeton.cs.algs4.*;
import sorting.merge_sort.Merge;
import sorting.merge_sort.MergeBU;
import sorting.merge_sort.*;
import sorting.priority_queues.FloydHeap;
import sorting.priority_queues.Heap3Way;
import sorting.priority_queues.Heap4Way;
import sorting.quick_sort.Quick;
import sorting.quick_sort.Quick3way;

import java.util.Arrays;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Bubble")) Bubble.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("InsertionWithSentinel")) InsertionWithSentinel.sort(a);
        if (alg.equals("InsertionWithoutExchanges")) InsertionWithoutExchanges.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("MergeBU")) MergeBU.sort(a);
        if (alg.equals("FasterMerge")) FasterMerge.sort(a);
        if (alg.equals("ImprovedMerge")) ImprovedMerge.sort(a);
        if (alg.equals("BUQueueMerge")) BUQueueMerge.sort(a);
        if (alg.equals("NaturalMerge")) NaturalMerge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Quick3way")) Quick3way.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        if (alg.equals("FloydHeap")) FloydHeap.sort(a);
        if (alg.equals("Heap3Way")) Heap3Way.sort(a);
        if (alg.equals("Heap4Way")) Heap4Way.sort(a);
        if (alg.equals("System")) Arrays.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++) {
                a[i] = StdRandom.uniform(0.0, 1.0);
            }
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
