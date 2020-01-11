package sorting.priority_queues;

import edu.princeton.cs.algs4.*;

public class PerformanceDriverII {
    private static void runExperiments(int trials) {
        StdDraw.setXscale(0, 100000);
        StdDraw.setYscale(0, 10000000);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        for (int n = 1000; ; n += 1000) {
            int count = 0;
            for (int t = 0; t < trials; t++) {
                MaxPQ<Double> pq = new MaxPQ<>(n);
                for (int i = 0; i < n; i++) pq.insert(StdRandom.uniform(0.0, 1.0));
                Stopwatch timer = new Stopwatch();
                while (timer.elapsedTime() < 1) {
                    pq.delMax();
                    pq.insert(StdRandom.uniform(0.0, 1.0));
                    count++;
                }
            }
            count /= trials;
            StdDraw.point(n, count);
            StdOut.println(n + " " + count);
        }
    }

    public static void main(String[] args) {
        int trials = StdIn.readInt();
        runExperiments(trials);
    }
}

