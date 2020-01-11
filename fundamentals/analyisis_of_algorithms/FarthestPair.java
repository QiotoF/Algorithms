package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FarthestPair {
    public static void main(String[] args) {
        double[] a = StdIn.readAllDoubles();
        double min = a[0];
        double max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i])
                min = a[i];
            if (max < a[i])
                max = a[i];
        }
        StdOut.println(max - min);
    }
}
