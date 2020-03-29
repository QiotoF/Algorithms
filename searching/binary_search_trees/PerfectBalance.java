package searching.binary_search_trees;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class PerfectBalance {
    public static void main(String[] args) {
        BST<Integer, Integer> st = new BST<>();
        int n = StdIn.readInt();
        int[] a = new int[n];
        a = StdIn.readAllInts();
        Arrays.sort(a);
        insertIntoBST(a, st, 0, n - 1);
    }

    public static void insertIntoBST(int[] a, BST<Integer, Integer> st, int lo, int hi) {
        if (lo > hi) return;
        int mid = lo + (hi - lo) / 2;
        st.put(a[mid], mid);
        insertIntoBST(a, st, lo, mid - 1);
        insertIntoBST(a, st, mid + 1, hi);
    }
}
