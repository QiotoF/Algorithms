package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
    public static double timeTrial(int n) {
        int MAX = 1000000;
        int[] a = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int count  = TwoSumFaster.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        Draw logDraw = new Draw();
        draw.setPenRadius(0.01);
        draw.setPenColor(Draw.BLUE);
        draw.setXscale(0.0, 16000);
        draw.setYscale(0.0, 200);
        logDraw.setPenRadius(0.01);
        logDraw.setPenColor(Draw.BLUE);
        logDraw.setXscale(-10, 100);
        logDraw.setYscale(-10, 10);
        for(int n = 250; true; n*= 2){
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            draw.point(n, time);
//            logDraw.point(Math.log(n)/Math.log(Math.E), Math.log(time)/Math.log(Math.E));
        }
    }
}
