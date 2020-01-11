package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class CircularLinkedQueue<Item> implements Iterable<Item> {

    private Node last;
    private int size;

    private class Node {

        Item item;
        Node next;
    }

    public CircularLinkedQueue() {
        size = 0;
        last = null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (size != 0) {
            last.next = oldLast.next;
            oldLast.next = last;
        } else {
            last.next = last;
        }
        size++;
    }

    public Item dequeue() {
        Node first = last.next;
        last.next = first.next;
        size--;
        return first.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node curr = last.next;

        @Override
        public boolean hasNext() {
            return curr != last.next;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        CircularLinkedQueue<String> q = new CircularLinkedQueue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
