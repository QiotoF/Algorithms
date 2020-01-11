package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        draw(n, p);
    }

    public static void draw(int n, double p) {
        StdDraw.setXscale(-2, 2);
        StdDraw.setYscale(-2, 2);
        StdDraw.setPenRadius(0.02);
        for (double angle = 0; angle < 2 * Math.PI; angle += Math.PI * 2 / n) {

            StdDraw.point(1 * Math.cos(angle), 1 * Math.sin(angle));
        }
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.GRAY);
        for (double angle = 0; angle < 2 * Math.PI; angle += Math.PI * 2 / n) {
            if (StdRandom.bernoulli(p))
                StdDraw.line(1 * Math.cos(angle), 1 * Math.sin(angle),
                        1 * Math.cos(angle + Math.PI * 2 / n), 1 * Math.sin(angle + Math.PI * 2 / n));
        }
    }
}
