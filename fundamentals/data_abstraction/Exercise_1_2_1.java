package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_2_1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Draw draw = new Draw();
        draw.setXscale(0f, 1f);
        draw.setYscale(0f, 1f);
        draw.setPenRadius(0.01);
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Point2D point = new Point2D(x, y);
            points[i] = point;
            draw.point(point.x(), point.y());
        }
        double dis = Double.MAX_VALUE;
        Point2D p1 = null;
        Point2D p2 = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (points[i].distanceTo(points[j]) < dis) {
                        dis = points[i].distanceTo(points[j]);
                        p1 = points[i];
                        p2 = points[j];
                    }
                }
            }
        }
        draw.setPenColor(Draw.RED);
        if (p1 != null && p2 != null) {
            draw.line(p1.x(), p1.y(), p2.x(), p2.y());
        }
        StdOut.println(dis);
    }
}
