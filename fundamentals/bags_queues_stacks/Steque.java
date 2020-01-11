package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public Steque() {
        size = 0;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        Node oldFirst = first;
        first = node;
        first.next = oldFirst;
        if (isEmpty()) last = first;
        size++;
    }

    public Item pop() {
        assert !isEmpty() : "Empty steque!";
        Item item = first.item;
        first = first.next;
        if (size == 1) last = null;
        size--;
        return item;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        Node oldLast = last;
        last = node;
        if (!isEmpty()) {
            oldLast.next = last;
        }
        if (isEmpty()) first = last;
        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Steque<Integer> q = new Steque<>();

        while (!StdIn.isEmpty()) {
            q.push(StdIn.readInt());
            q.enqueue(StdIn.readInt());
        }
        for (int i = 0; i < q.size(); i++) {
            StdOut.print(q.pop() + " ");
            i--;
        }
        StdOut.println();
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
