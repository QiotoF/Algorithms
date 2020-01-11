package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class DoubleLinkedList<Item> implements Iterable<Item> {

    private int size;
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node prev;
        Node next;
    }

    public DoubleLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAtTheBeginning(Item item) {
        size++;
        Node node = new Node();
        node.item = item;
        if (first == null) {
            first = node;
            last = node;
            return;
        }
        node.next = first;
        first.prev = node;
        first = node;
    }

    public void insertAtTheEnd(Item item) {
        size++;
        Node node = new Node();
        node.item = item;
        if (last == null) {
            first = node;
            last = node;
            return;
        }
        node.prev = last;
        last.next = node;
        last = node;
    }

    public void removeFromTheBeginning() {
        if (size <= 0) return;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    public void removeFromTheEnd() {
        if (size <= 0) return;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    private void insertAfter(Node before, Item item) {
        if (before == null || item == null) return;
        Node node = new Node();
        node.item = item;
        if (before.next == null) {
            last = node;
        } else {
            before.next.prev = node;
            node.next = before.next;
        }
        before.next = node;
        node.prev = before;
        size++;
    }

    private void insertBefore(Node after, Item item) {
        if (after == null || item == null) return;
        Node node = new Node();
        node.item = item;
        if (after.prev == null) {
            first = node;
        } else {
            after.prev.next = node;
            node.prev = after.prev;
        }
        after.prev = node;
        node.next = after;
        size++;
    }

    private void removeNode(Node node) {
        if (node == null || size <= 0) return;
        if (size == 1){
            first = null;
            last = null;
            size--;
            return;
        }
        if (node == first) {
            first = node.next;
            first.prev = null;
        } else if (node == last) {
            last = node.prev;
            last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        while (!StdIn.isEmpty()) {
            list.insertAtTheEnd(StdIn.readInt());
        }
        list.removeNode(list.last);
        for (int x : list) {
            StdOut.print(x + " ");
        }
    }
}
