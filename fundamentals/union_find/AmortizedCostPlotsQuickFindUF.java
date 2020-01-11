package fundamentals.union_find;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AmortizedCostPlotsQuickFindUF {

    static class QuickFindUF {

        private int[] id;
        private int count;

        public QuickFindUF(int n) {
            count = n;
            id = new int[n];
            for (int i = 0; i < n; i++)
                id[i] = i;
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            return id[p];
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int union(int p, int q) {
            int num = 0;
            int pID = find(p);
            int qID = find(q);
            if (pID == qID) return 2;
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                    num += 2;
                } else {
                    num++;
                }
            }
            count--;
            return num;
        }
    }


    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.setYscale(0, 2000000);
        draw.setXscale(0, 10000);
        draw.setPenRadius(0.005);
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        int i = 0;
        double sum = 0;
        while (!StdIn.isEmpty()) {
            draw.setPenColor(Draw.GRAY);
            i++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                draw.point(i, 2);
                sum += 2;
                draw.setPenColor(Draw.RED);
                draw.point(i, sum / i);
                continue;
            }
            int y = uf.union(p, q);
            sum += y;
            draw.point(i, y);
            draw.setPenColor(Draw.RED);
            draw.point(i, sum / i);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
