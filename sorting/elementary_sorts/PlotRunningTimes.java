package sorting.elementary_sorts;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PlotRunningTimes {
    public static void main(String[] args) {
        StdDraw.setXscale(0, 20000);
        StdDraw.setYscale(0, 50);
        String alg = StdIn.readString();
        int trials = StdIn.readInt();
        double actualTime = 1;
        double prevTime;
        double ratio;
        for (int n = 1000; ; n *= 2) {
            prevTime = actualTime;
            actualTime = SortCompare.timeRandomInput(alg, n, trials);
            ratio = actualTime / prevTime;
            StdOut.print("n = " + n);
            StdOut.printf(" Actual time: %.3f", actualTime);
            StdOut.printf(" Ratio: %.1f", ratio);
            StdOut.println();
            if (prevTime != 1) StdDraw.line(n / 2, prevTime, n, actualTime);
        }
    }


}
