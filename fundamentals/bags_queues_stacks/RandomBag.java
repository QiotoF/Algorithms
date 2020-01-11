package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        Item[] a;
        int current = 0;

        ListIterator() {
            a = (Item[]) new Object[n];
            int i = 0;
            for (Node node = first; node != null; node = node.next) {
                a[i] = node.item;
                i++;
            }
            StdRandom.shuffle(a);
        }

        public boolean hasNext() {
            return current < a.length;
        }

        public void remove() {

        }

        public Item next() {
            Item item = a[current];
            current++;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> bag = new RandomBag<>();
        while (!StdIn.isEmpty()) {
            bag.add(StdIn.readInt());
        }
        for (int x : bag) {
            StdOut.print(x + " ");
        }
    }
}
