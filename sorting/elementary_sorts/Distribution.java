package sorting.elementary_sorts;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.awt.*;

public class Distribution {
    public static void main(String[] args) {
        String alg = StdIn.readString();
        int n = StdIn.readInt();

        StdDraw.setYscale(0, 0.5);
        StdDraw.setXscale(0, 1000);
        StdDraw.setPenRadius(0.005);
        double sum = 0;
        double average;
        while (true) {
            for (int i = 1; i < 1000; i++) {
                double time = SortCompare.timeRandomInput(alg, n, 1);
                sum += time;
                average = sum / i;
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.point(i, time);
                StdDraw.setPenColor(Color.RED);
                StdDraw.point(i, average);
            }
        }
    }
}
