package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Binary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = StdIn.readInt();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        for (int d : stack)
            StdOut.print(d);
    }
}
