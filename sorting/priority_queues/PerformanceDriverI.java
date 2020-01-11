package sorting.priority_queues;

import edu.princeton.cs.algs4.*;

public class PerformanceDriverI {

    private static void runExperiments(int trials) {
        StdDraw.setXscale(0,100000);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        for (int n = 10; ; n *= 10) {
            double time = 0;
            for (int t = 0; t < trials; t++) {
                MaxPQ<Double> pq = new MaxPQ<>(n);
                Stopwatch timer = new Stopwatch();
                for (int i = 0; i < n; i++) pq.insert(StdRandom.uniform(0.0, 1.0));
                for (int i = 0; i < n/2; i++ ) pq.delMax();
                for (int i = 0; i < n/2; i++) pq.insert(StdRandom.uniform(0.0, 1.0));
                for (int i = 0; i < n; i++) pq.delMax();
                time += timer.elapsedTime();
            }
            time /= trials;
            StdDraw.point(n, time);
            StdOut.println(n + " " + time);
        }
    }

    public static void main(String[] args) {
        int trials = StdIn.readInt();
        runExperiments(trials);
    }
}
