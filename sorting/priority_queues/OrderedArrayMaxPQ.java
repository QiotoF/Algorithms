package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public OrderedArrayMaxPQ() {
        this(0);
    }

    public OrderedArrayMaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
        n = 0;
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
        for (int i = n; i > 1 && less(i, i - 1); i--){
            exch(i, i -1);
        }
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key key = pq[n];
        pq[n--] = null;
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

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public static void main(String[] args) {
        OrderedArrayMaxPQ pq = new OrderedArrayMaxPQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*")) {
                StdOut.println(pq.delMax());
            } else {
                pq.insert(s);
            }
        }
    }
}
