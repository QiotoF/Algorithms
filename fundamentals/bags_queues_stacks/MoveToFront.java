package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            list.moveToFront(a);
        }
        for (int x : list) {
            StdOut.print(x + " ");
        }
    }
}
