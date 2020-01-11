package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;
    private Key min;

    public MaxPQ() {
        this(0);
    }

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
        n = 0;
    }

    public MaxPQ(Key[] a) {
        n = a.length;
        pq = (Key[]) new Comparable[n + 1];
        System.arraycopy(a, 0, pq, 1, n);

        for (int i = n / 2; i >= 1; i--) {
            sink(i);
        }

        min = pq[n / 2 + 1];
        for (int i = n / 2 + 2; i <= n; i++) {
            if (less(pq[i], min)) {
                min = pq[i];
            }
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key key) {
        if (n == pq.length - 1) resize(n * 2 + 1);
        pq[++n] = key;
        swim(n);
        if (n == 1 || less(key, min)) min = key;
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key key = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        if (n <= pq.length / 4) resize(pq.length / 2);
        if (isEmpty()) min = null;
        return key;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return min;
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Key[] temp = (Key[]) new Comparable[capacity + 1];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j, j + 1)) j++;
            if (less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private boolean less(Key a, Key b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                StdOut.println(pq.delMax());
            } else if (s.equals("-")) {
                StdOut.println(pq.min());
            } else {
                pq.insert(s);
            }
        }
//        int n = StdIn.readInt();
//        Integer[] a = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = StdIn.readInt();
//        }
//        MaxPQ pq = new MaxPQ<>(a);
//        while (!pq.isEmpty()) {
//            StdOut.print(pq.delMax() + " ");
//        }
    }
}
