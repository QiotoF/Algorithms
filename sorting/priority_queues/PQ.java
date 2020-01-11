package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class PQ<Key extends Comparable<Key>> {

    private int n;
    private Key[] maxPq;
    private Key[] minPq;

    public PQ() {
        this(0);
    }

    public PQ(int size) {
        n = 0;
        maxPq = (Key[]) new Comparable[size + 1];
        minPq = (Key[]) new Comparable[size + 1];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key max() {
        return maxPq[1];
    }

    public Key min() {
        return minPq[1];
    }

    public void insert(Key key) {
        if (n == maxPq.length - 1) {
            resizeMax(n * 2 + 1);
            resizeMin(n * 2 + 1);
        }
        n++;
        maxPq[n] = key;
        minPq[n] = key;
        swimMax(n);
        swimMin(n);
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key key = maxPq[1];
        exch(maxPq, 1, n--);
        maxPq[n + 1] = null;
        sinkMax(1);
        if (n <= maxPq.length / 4) resizeMax(maxPq.length / 2);
        return key;
    }

    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key key = minPq[1];
        exch(minPq, 1, n--);
        minPq[n + 1] = null;
        sinkMin(1);
        if (n <= minPq.length / 4) resizeMin(minPq.length / 2);
        return key;
    }

    private void resizeMax(int capacity) {
        assert capacity >= n;
        Key[] temp = (Key[]) new Comparable[capacity + 1];
        for (int i = 1; i <= n; i++) {
            temp[i] = maxPq[i];
        }
        maxPq = temp;
    }

    private void resizeMin(int capacity) {
        assert capacity >= n;
        Key[] temp = (Key[]) new Comparable[capacity + 1];
        for (int i = 1; i <= n; i++) {
            temp[i] = minPq[i];
        }
        minPq = temp;
    }

    private void swimMax(int k) {
        while (k > 1 && less(maxPq, k / 2, k)) {
            exch(maxPq, k / 2, k);
            k /= 2;
        }
    }

    private void swimMin(int k) {
        while (k > 1 && !less(maxPq, k / 2, k)) {
            exch(maxPq, k / 2, k);
            k /= 2;
        }
    }

    private void sinkMax(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(maxPq, j, j + 1)) j++;
            if (less(maxPq, j, k)) break;
            exch(maxPq, k, j);
            k = j;
        }
    }

    private void sinkMin(int k) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && !less(maxPq, j, j + 1)) j++;
            if (less(maxPq, j, k)) break;
            exch(maxPq, k, j);
            k = j;
        }
    }

    private boolean less(Key[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private boolean less(Key a, Key b) {
        return a.compareTo(b) < 0;
    }

    private void exch(Key[] a, int i, int j) {
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        PQ pq = new PQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                StdOut.println(pq.max());
            } else if (s.equals("-")) {
                StdOut.println(pq.min());
            } else if (s.equals("+*")) {
                StdOut.println(pq.delMax());
            } else if (s.equals("-*")) {
                StdOut.println(pq.delMin());
            } else {
                pq.insert(s);
            }
        }
    }
}
