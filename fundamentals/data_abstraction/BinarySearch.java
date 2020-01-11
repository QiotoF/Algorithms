package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        for (int i = 0; i < whitelist.length; i++) {

        }

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }

//    public static int indexOf(int[] a, int key) {
//        return indexOf(a, key, 0, a.length - 1);
//    }
//
//    public static int indexOf(int[] a, int key, int lo, int hi) {
//        if ()
//        if (key < a[mid]) return indexOf(a, key, lo, mid-1);
//        else if (key > a[mid]) return indexOf(a, key, mid+1, hi);
//        else return mid;
//    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
