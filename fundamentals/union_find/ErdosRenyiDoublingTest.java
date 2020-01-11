package fundamentals.union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ErdosRenyiDoublingTest {
    public static void main(String[] args) {
        int T = StdIn.readInt();
        int m = 100;
        int n = 200;
        double prevTime = 1;
        for (int i = 0; i < T; i++) {
            double time = 0;
            double count = 0;
            for (int j = 0; j < m; j++) {
                Stopwatch timer = new Stopwatch();
                count += ErdosRenyi.count(n);
                time += timer.elapsedTime();
            }
            time /= m;
            count /= m;
            double ratio = time / prevTime;

            StdOut.printf("n = %6d ", n);
            StdOut.printf("Average number of connections: %6.0f ", count);
            StdOut.printf("Average time: %.1f ", time);
            StdOut.printf("Ratio: %.1f\n", ratio);


//            StdOut.println("n = " + n + " Average number of connections: " + count + "Average time: " +
//                    time + " Ration: " + ratio);

            prevTime = time;

            n *= 2;

        }
    }
}
