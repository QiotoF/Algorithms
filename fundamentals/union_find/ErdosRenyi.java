package fundamentals.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
    public static int count(int n) {
        QuickFindUF uf = new QuickFindUF(n);
        int count = 0;
        while (uf.count() != 1) {
            int a = StdRandom.uniform(0, n);
            int b = StdRandom.uniform(0, n);
            count++;
            if (!uf.connected(a, b)) {
                uf.union(a, b);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        StdOut.println(count(n));
    }
}
