package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
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
                    String c = ops.pop();
                    double d = vals.pop();
                    switch (c) {
                        case "sqrt":
                            vals.push(Math.sqrt(d));
                            break;
                        case "+":
                            vals.push(vals.pop() + d);
                            break;
                        case "-":
                            vals.push(vals.pop() - d);
                            break;
                        case "*":
                            vals.push(vals.pop() * d);
                            break;
                        case "/":
                            vals.push(vals.pop() / d);
                            break;
                    }
                    break;
                default:
                    vals.push(Double.parseDouble(s));
                    break;
            }
        }
        StdOut.println(vals.pop());
    }
}
