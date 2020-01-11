package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    StdOut.println(false);
                    return;
                }
                char s = stack.pop();
                if (!(c == ')' && s == '(' || c == '}' && s == '{' || c == ']' && s == '[')) {
                    StdOut.println(false);
                    return;
                }
            } else throw new IllegalArgumentException();
        }
        if (stack.size() == 0)
            StdOut.println(true);
        else
            StdOut.println(false);
    }
}
