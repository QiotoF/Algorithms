package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FindSameIn2Arrays {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = StdIn.readInt();
        }
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                StdOut.print(a[i] + " ");
                i++;
                j++;
                while (i < n - 1 && a[i] == a[i - 1]) {
                    i++;
                }
                while (j < n - 1 && b[j] == b[j - 1]) {
                    j++;
                }
            }
        }
    }
}
