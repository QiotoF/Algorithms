package fundamentals.union_find;

import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionByHeightUF {

    private int[] id;
    private int[] heights;
    private int count;

    public WeightedQuickUnionByHeightUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
        heights = new int[n];
        for (int i = 0; i < n; i++) heights[i] = 0;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (heights[i] < heights[j]) {
            id[i] = j;
            heights[j] += heights[i];
        } else {
            id[j] = i;
            heights[i] += heights[j];
        }
        count--;
    }

    public static void main(String[] args) {
//        int n = StdIn.readInt();
//        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if (uf.connected(p, q)) continue;
//            uf.union(p, q);
//            StdOut.println(p + " " + q);
//        }
//        StdOut.println(uf.count() + " components");

        WeightedQuickUnionByHeightUF weightedQuickUnionByHeight = new WeightedQuickUnionByHeightUF(19);

        weightedQuickUnionByHeight.union(0, 1);
        weightedQuickUnionByHeight.union(0, 2);
        weightedQuickUnionByHeight.union(0, 3);
        weightedQuickUnionByHeight.union(6, 7);
        weightedQuickUnionByHeight.union(8, 9);
        weightedQuickUnionByHeight.union(6, 8);
        weightedQuickUnionByHeight.union(0, 6);
        weightedQuickUnionByHeight.union(10, 11);
        weightedQuickUnionByHeight.union(10, 12);
        weightedQuickUnionByHeight.union(10, 13);
        weightedQuickUnionByHeight.union(10, 14);
        weightedQuickUnionByHeight.union(10, 15);
        weightedQuickUnionByHeight.union(10, 16);
        weightedQuickUnionByHeight.union(10, 17);
        weightedQuickUnionByHeight.union(10, 18);
        weightedQuickUnionByHeight.union(0, 10);

        StdOut.println("Components: " + weightedQuickUnionByHeight.count() + " Expected: 3");
    }

}
