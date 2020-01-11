package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFaster {

    public static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (Math.abs(a[l]) < Math.abs(a[r])) {
                r--;
            } else if (Math.abs(a[l]) > Math.abs(a[r])) {
                l++;
            } else {
                count++;
                r--;
                l++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        StdOut.println(count(a));
    }
}
