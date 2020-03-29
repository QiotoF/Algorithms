package searching.balanced_search_trees;

import edu.princeton.cs.algs4.StdRandom;
import searching.binary_search_trees.BST;

public class RandomKeysTrees {

    private static final int N = 10000;

    public static void main(String[] args) {
        RedBlackBST<Double, Integer> redBlackBST = new RedBlackBST<>();
        BST<Double, Integer> bst = new BST<>();

        for (int i = 0; i < N; i++) {
            double r = StdRandom.uniform();
            redBlackBST.put(r, i);
            bst.put(r, i);
        }

        redBlackBST.draw(false, true);
        bst.draw(false, true);
    }
}
