package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

public class BirthdayProblem {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        ArrayList<Integer> list = new ArrayList<>();
        int count;
        int m = 10000;
        double average = 0;
        for (int i = 0; i < m ; i++) {
            count = 0;
            list.clear();
            while (true) {
                int a = StdRandom.uniform(0, n - 1);
                if (list.contains(a)) {
                    break;
                }
                list.add(a);
                count++;
            }
            average += count;
        }
        average /= m;
        StdOut.println("Result: " + average + " Expected: " + Math.sqrt(Math.PI * n / 2));
    }
}
