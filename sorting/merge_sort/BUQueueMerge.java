package sorting.merge_sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import fundamentals.bags_queues_stacks.Queue;

public class BUQueueMerge {

    public static void sort(Comparable[] a) {
        int n = a.length;
        Queue<Queue> q = new Queue<>();
        for (int i = 0; i < n; i++) {
            Queue<Comparable> p = new Queue<>();
            p.enqueue(a[i]);
            q.enqueue(p);
        }
        while (q.size() > 1) {
            q.enqueue(MergingSortedQueues.merge(q.dequeue(), q.dequeue()));
        }
        assert q.size() == 1;
        Queue<Comparable> p = q.dequeue();
        for (int i = 0; i < n; i++) {
            a[i] = p.dequeue();
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
