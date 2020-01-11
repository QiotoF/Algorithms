package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class OrderedLinkedListMaxPQ<Key extends Comparable<Key>> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Key key;
        Node next;
    }

    public OrderedLinkedListMaxPQ() {
        this(0);
    }

    public OrderedLinkedListMaxPQ(int maxN) {
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
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node prev = null;
            for (Node temp = first; temp != last.next; temp = temp.next) {
                if (less(temp.key, node.key)) break;
                prev = temp;
            }
            if (prev == null) {
                node.next = first;
                first = node;
            } else if (prev == last) {
                last.next = node;
                last = node;
            } else {
                node.next = prev.next;
                prev.next = node;
            }
        }
        n++;
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        n--;
        Key key = first.key;
        first = first.next;
        return key;
    }

    private boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void main(String[] args) {
        OrderedLinkedListMaxPQ pq = new OrderedLinkedListMaxPQ<Integer>();
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
