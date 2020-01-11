package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        int i = 1;
        while (!queue.isEmpty()) {
            int a = queue.dequeue();
            if (i % m == 0)
                StdOut.print(a + " ");
            else
                queue.enqueue(a);
            i++;
        }
    }
}
