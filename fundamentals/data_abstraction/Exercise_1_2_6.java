package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_1_2_6 {
    public static void main(String[] args) {
        String s = StdIn.readString();
        String t = StdIn.readString();
        StdOut.println(s.length() == t.length() && (s + s).contains(t));
    }
}
