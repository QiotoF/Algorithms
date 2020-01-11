package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestVisualAccumulator {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        VisualAccumulator accumulator = new VisualAccumulator(trials, 1.0);
        for (int t = 0; t < trials; t++) {
            accumulator.addDataValue(StdRandom.uniform(0.0, 1.0));
        }
        StdOut.println(accumulator);
    }
}
