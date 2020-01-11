package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val2 - val1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int var2 = stack.pop();
                    int var1 = stack.pop();
                    stack.push(var1 / var2);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        StdOut.println(stack.pop());
    }
}
