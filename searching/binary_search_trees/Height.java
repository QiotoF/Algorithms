package searching.binary_search_trees;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Height {

    private static final int TRIALS = 100;

    public static void main(String[] args) {
        runExperiments();
    }

    private static void runExperiments() {
        BST<Double, Integer> bst;
        for (int n = 10000; n <= 1000000; n *= 10) {
            double averageHeight = 0;
            for (int i = 0; i < TRIALS; i++) {
                bst = new BST<>();
                fillWithNRandomValues(bst, n);
                averageHeight += bst.height();
            }
            averageHeight /= TRIALS;
            StdOut.println("Average height for n = " + n + ": " + averageHeight);
        }
    }

    private static void fillWithNRandomValues(BST<Double, Integer> bst, int n) {
        for (int j = 0; j < n; j++) {
            double r = StdRandom.uniform();
            bst.put(r, j);
        }
    }
}
