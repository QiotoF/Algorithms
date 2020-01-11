package fundamentals.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ErdosRenyiModel {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int count = ErdosRenyi.count(n);
        double expected = 0.5 * n * Math.log(n) / Math.log(2);
        StdOut.println("Result: " + count + " Expected: " + (int) expected + " Точность " + count / expected);
    }
}
