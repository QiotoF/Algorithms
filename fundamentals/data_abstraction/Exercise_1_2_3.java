package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.*;

public class Exercise_1_2_3 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = new Interval2D[n];
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < n; i++) {
            double x1 = StdRandom.uniform(min, max);
            double y1 = StdRandom.uniform(min, max);
            double x2 = StdRandom.uniform(min, max);
            double y2 = StdRandom.uniform(min, max);
            Interval1D dx = new Interval1D(Double.min(x1, x2), Double.max(x1, x2));
            Interval1D dy = new Interval1D(Double.min(y1, y2), Double.max(y1, y2));
            Interval2D interval = new Interval2D(dx, dy);
            interval.draw();
            intervals[i] = interval;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j])){
                    StdOut.println(intervals[i] + " intersects " + intervals[j]);
                }
            }
        }
    }
}
