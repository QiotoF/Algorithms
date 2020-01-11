package sorting.priority_queues;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class IndexMinPQ<Key extends Comparable<Key>> {

    private int[] pq;
    private int[] qp;
    private Key[] keys;
    private int n;

    public IndexMinPQ() {
        this(0);
    }

    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public void insert(int i, Key key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public Key minKey() {
        return keys[pq[1]];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, n--);
        sink(1);
        keys[pq[n+1]] = null;
        qp[pq[n+1]] = -1;
        return indexOfMin;
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
        return keys[i].compareTo(keys[j]) < 0;
    }

    private boolean less(Key a, Key b) {
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
//        Key t = pq[i];
//        pq[i] = pq[j];
//        pq[j] = t;
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
    }
}
