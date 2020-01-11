package sorting.priority_queues;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DynamicMedianFinding<Key extends Comparable<Key>> {
    private Key v;
    private MaxPQ<Key> leftPq;
    private MinPQ<Key> rightPq;

    public DynamicMedianFinding() {
        v = null;
        leftPq = new MaxPQ<>();
        rightPq = new MinPQ<>();
    }

    public int size() {
        if (v != null)
            return leftPq.size() + rightPq.size() + 1;
        else
            return 0;
    }

    public void insert(Key key) {
        if (size() == 0) {
            v = key;
            return;
        }
        if (less(v, key)) rightPq.insert(key);
        else leftPq.insert(key);

        if (rightPq.size() == leftPq.size() + 2) {
            leftPq.insert(v);
            v = rightPq.delMin();
        } else if (leftPq.size() == rightPq.size() + 2) {
            rightPq.insert(v);
            v = leftPq.delMax();
        }
    }

    public Key median() {
        return v;
    }

    public Key delMedian() {
        Key median = v;
        if (rightPq.size() > leftPq.size())
            v = rightPq.delMin();
        else v = leftPq.delMax();
        return median;
    }

    private boolean less(Key v, Key u) {
        return v.compareTo(u) < 0;
    }

    public static void main(String[] args) {
        DynamicMedianFinding<Integer> pq = new DynamicMedianFinding<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*"))
                StdOut.println(pq.median());
            else if (s.equals("-"))
                StdOut.println(pq.delMedian());
            else
                pq.insert(Integer.parseInt(s));
        }
    }
}
