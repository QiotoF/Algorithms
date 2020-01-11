package fundamentals.union_find;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AmortizedCostPlotsQuickUnionUF {
    static class QuickUnionUF {

        private int[] id;
        private int count;

        public int arrayAccesses = 0;

        public QuickUnionUF(int n) {
            count = n;
            id = new int[n];
            for (int i = 0; i < n; i++)
                id[i] = i;
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
                arrayAccesses += 2;
            }
            arrayAccesses++;
            return p;
        }

        public boolean connected(int p, int q) {
            arrayAccesses = 0;
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            arrayAccesses = 0;
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            id[i] = j;
            arrayAccesses++;
            count--;
        }


    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.setCanvasSize(900, 100);
        draw.setYscale(0, 100);
        draw.setXscale(0, 900);
        draw.setPenRadius(0.005);
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        int i = 0;
        double sum = 0;
        while (!StdIn.isEmpty()) {
            draw.setPenColor(Draw.GRAY);
            i++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                draw.point(i, 2);
                sum += uf.arrayAccesses;
                draw.setPenColor(Draw.RED);
                draw.point(i, sum / i);
                continue;
            }
            uf.union(p, q);
            int y = uf.arrayAccesses;
            sum += y;
            draw.point(i, y);
            draw.setPenColor(Draw.RED);
            draw.point(i, sum / i);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
