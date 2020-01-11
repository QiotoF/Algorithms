package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class UnorderedLinkedListMaxPQ<Key extends Comparable<Key>> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Key key;
        Node next;
    }

    public UnorderedLinkedListMaxPQ() {
        this(0);
    }

    public UnorderedLinkedListMaxPQ(int maxN) {
        first = null;
        last = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key key) {
        Node node = new Node();
        node.key = key;
        if (isEmpty()) first = node;
        else last.next = node;
        last = node;
        n++;
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Node max = first;
        Node prevMax = null;
        for (Node node = first, prev = null; node != last.next; node = node.next) {
            if (less(max.key, node.key)) {
                max = node;
                prevMax = prev;
            }
            prev = node;
        }
        if (prevMax == null) first = first.next;
        else if (max.next == null) {
            last = prevMax;
            last.next = null;
        } else prevMax.next = max.next;
        n--;
        return max.key;
    }

    private boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void main(String[] args) {
        UnorderedLinkedListMaxPQ pq = new UnorderedLinkedListMaxPQ<Integer>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*")) {
                StdOut.println(pq.delMax());
            } else {
                pq.insert(Integer.parseInt(s));
            }
        }
    }
}
