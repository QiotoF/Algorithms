package fundamentals.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class CompareErdosRenyi {
    public static void main(String[] args) {
        int t = StdIn.readInt();
        int n = 1000;
        for (int i = 0; i < t; i++) {
            QuickUnionUF quickUnionUF = new QuickUnionUF(n);
            QuickFindUF quickFindUF = new QuickFindUF(n);
            Stopwatch timer = new Stopwatch();
            while (quickFindUF.count() != 1) {
                int a = StdRandom.uniform(0, n);
                int b = StdRandom.uniform(0, n);
                if (!quickFindUF.connected(a, b)) {
                    quickFindUF.union(a, b);
                }
            }
            double quickFindTime = timer.elapsedTime();
            Stopwatch timer2 = new Stopwatch();
            while (quickUnionUF.count() != 1) {
                int a = StdRandom.uniform(0, n);
                int b = StdRandom.uniform(0, n);
                if (!quickUnionUF.connected(a, b)) {
                    quickUnionUF.union(a, b);
                }
            }
            double quickUnionTime = timer2.elapsedTime();

            StdOut.printf("n = %6d ", n);
            StdOut.printf("QuickFind time: %.1f ", quickFindTime);
            StdOut.printf("QuickUnion time: %.1f ", quickUnionTime);
            StdOut.printf("Ratio: %.1f\n", quickFindTime / quickUnionTime);

            n *= 2;
        }
    }
}
