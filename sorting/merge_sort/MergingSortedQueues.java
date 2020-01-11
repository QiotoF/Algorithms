package sorting.merge_sort;

import edu.princeton.cs.algs4.StdOut;
import fundamentals.bags_queues_stacks.Queue;

public class MergingSortedQueues {
    public static <Item extends Comparable> Queue<Item> merge(Queue<Item> q, Queue<Item> p) {
        Queue<Item> t = new Queue<>();
        while (!q.isEmpty() || !p.isEmpty()) {
            if (q.isEmpty()) t.enqueue(p.dequeue());
            else if (p.isEmpty()) t.enqueue(q.dequeue());
            else {
                if (q.peek().compareTo(p.peek()) < 0) {
                    t.enqueue(q.dequeue());
                } else {
                    t.enqueue(p.dequeue());
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        Queue<Integer> p = new Queue<>();
        q.enqueue(0);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(6);
        q.enqueue(8);
        q.enqueue(10);
        p.enqueue(1);
        p.enqueue(3);
        p.enqueue(5);
        p.enqueue(7);
        p.enqueue(9);
        p.enqueue(11);
        Queue<Integer> t = merge(q, p);
        for (int x : t) {
            StdOut.print(x + " ");
        }
    }
}
