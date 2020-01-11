package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DiceSimulation {
    public static void main(String[] args) {
        int sides = 6;
        double[] p = probabilities(sides);
        double[] f = test(sides, 10000000);
        for (int i = 2; i < p.length; i++) {
            StdOut.printf("%d %.3f%% %.3f%%\n", i, p[i], f[i]);
        }

    }


    static double[] probabilities(int sides) {
        int[] frequencies = new int[2 * sides + 1];
        for (int i = 1; i <= sides; i++)
            for (int j = 1; j <= sides; j++)
                frequencies[i + j]++;
        double[] probabilities = new double[2 * sides + 1];
        for (int k = 2; k <= 2 * sides; k++)
            probabilities[k] = 100 * frequencies[k] / (double) (sides * sides);
        return probabilities;
    }

    static double[] test(int sides, int n) {
        double[] freqs = new double[2 * sides + 1];
        for (int i = 0; i < n; i++) {
            int a = StdRandom.uniform(1, sides + 1);
            int b = StdRandom.uniform(1, sides + 1);
            freqs[a + b]++;
        }
        for (int i = 0; i < freqs.length; i++) {
            freqs[i] /= n;
            freqs[i] *= 100;
        }
        return freqs;
    }
}
