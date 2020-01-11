package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixParenthesis {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(s);
                    break;
                case ")":
                    String operator = ops.pop();
                    String val2 = vals.pop();
                    String val1 = vals.pop();
                    String c = "( " + val1 + " " + operator + " " + val2 + " ) ";
                    vals.push(c);
                    break;
                default:
                    vals.push(s);
                    break;
            }
        }
        StdOut.println(vals.pop());
    }
}

