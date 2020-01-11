package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackCopier {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readString());
        }
        Stack<String> newStack = copy(stack);
        for (String x : newStack) {
            StdOut.println(x);
        }
    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        for (String x : stack) {
            temp.push(x);
        }
        Stack<String> result = new Stack<>();
        for (String x : temp) {
            result.push(x);
        }
        return result;
    }
}
