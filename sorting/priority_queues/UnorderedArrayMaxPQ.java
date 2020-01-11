package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public UnorderedArrayMaxPQ() {
        this(0);
    }

    public UnorderedArrayMaxPQ(int maxN) {
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
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        int j = 1;
        for (int i = 1; i <= n; i++) {
            if (!less(i, j)) j = i;
        }
        Key key = pq[j];
        pq[j] = pq[n];
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

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ pq = new UnorderedArrayMaxPQ<String>();
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
