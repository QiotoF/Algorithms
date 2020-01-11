package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class MaxPQWithoutExchanges<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public MaxPQWithoutExchanges() {
        this(0);
    }

    public MaxPQWithoutExchanges(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
        n = 0;
    }

    public MaxPQWithoutExchanges(Key[] a) {
        n = a.length;
        pq = (Key[]) new Comparable[n + 1];
        System.arraycopy(a, 0, pq, 1, n);

        for (int i = n / 2; i >= 1; i--) {
            sink(i);
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
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key key = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        if (n <= pq.length / 4) resize(pq.length / 2);
        return key;
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
        Key aux = pq[k];
        while (k > 1 && less(k / 2, k)) {
            pq[k] = pq[k / 2];
            k /= 2;
        }
        pq[k] = aux;
    }

    private void sink(int k) {
        Key aux = pq[k];
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(j, j + 1)) j++;
            if (less(j, k)) break;
            pq[k] = pq[j];
            k = j;
        }
        pq[k] = aux;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
//        MaxPQ pq = new MaxPQ<String>();
//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            if (s.equals("*")) {
//                StdOut.println(pq.delMax());
//            } else {
//                pq.insert(s);
//            }
//        }
        int n = StdIn.readInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }
        MaxPQWithoutExchanges pq = new MaxPQWithoutExchanges(a);
        while (!pq.isEmpty()) {
            StdOut.print(pq.delMax() + " ");
        }
    }
}
