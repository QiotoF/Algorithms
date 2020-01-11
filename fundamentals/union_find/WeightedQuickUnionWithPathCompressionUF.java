package fundamentals.union_find;

import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionWithPathCompressionUF {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionWithPathCompressionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
        sz = new int[n];
        for (int i = 0; i < n; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        int q = p;
        while (p != id[p]) p = id[p];
        while (q != id[q]) {
            int t = q;
            q = id[q];
            id[t] = p;
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
//        int n = StdIn.readInt();
//        WeightedQuickUnionWithPathCompressionUF uf = new WeightedQuickUnionWithPathCompressionUF(n);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if (uf.connected(p, q)) continue;
//            uf.union(p, q);
//            StdOut.println(p + " " + q);
//        }
//        StdOut.println(uf.count() + " components");

        //Sequence of input pairs to produce a tree of height 4:
        //0 1
        //0 2
        //0 3
        //6 7
        //8 9
        //6 8
        //0 6
        //10 11
        //10 12
        //10 13
        //10 14
        //10 15
        //10 16
        //10 17
        //10 18
        //0 10

        //Path of height 4: 9 -> 8 -> 6 -> 0 -> 10

        WeightedQuickUnionWithPathCompressionUF weightedQuickUnionPathCompression =
                new WeightedQuickUnionWithPathCompressionUF(19);
        weightedQuickUnionPathCompression.union(0, 1);
        weightedQuickUnionPathCompression.union(0, 2);
        weightedQuickUnionPathCompression.union(0, 3);
        weightedQuickUnionPathCompression.union(6, 7);
        weightedQuickUnionPathCompression.union(8, 9);
        weightedQuickUnionPathCompression.union(6, 8);
        weightedQuickUnionPathCompression.union(0, 6);
        weightedQuickUnionPathCompression.union(10, 11);
        weightedQuickUnionPathCompression.union(10, 12);
        weightedQuickUnionPathCompression.union(10, 13);
        weightedQuickUnionPathCompression.union(10, 14);
        weightedQuickUnionPathCompression.union(10, 15);
        weightedQuickUnionPathCompression.union(10, 16);
        weightedQuickUnionPathCompression.union(10, 17);
        weightedQuickUnionPathCompression.union(10, 18);
        weightedQuickUnionPathCompression.union(0, 10);

        StdOut.println("Components: " + weightedQuickUnionPathCompression.count() + " Expected: 3");
    }

}
