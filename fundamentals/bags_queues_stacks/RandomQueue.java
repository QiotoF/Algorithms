package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enqueue(Item item) {
        if (n == a.length)
            resize(2 * a.length);
        a[n++] = item;
    }

//    public Item dequeue() {
//        int r;
//        if (n > 1)
//            r = StdRandom.uniform(0, n - 1);
//        else
//            r = n - 1;
//        Item temp = a[r];
//        a[r] = a[--n];
//        a[n] = temp;
//        Item item = a[n];
//        a[n] = null;
//        if (n > 0 && n == a.length / 4) resize(a.length / 2);
//        return item;
//    }

    public Item sample() {
        int r;
        if (n > 1)
            r = StdRandom.uniform(0, n - 1);
        else
            r = n - 1;
        Item temp = a[r];
        a[r] = a[n - 1];
        a[n - 1] = temp;
        return a[n - 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = n - 1;

        public ReverseArrayIterator() {
            Item[] b = (Item[]) new Object[n];
            System.arraycopy(a, 0, b, 0, n);
            a = b;
            StdRandom.shuffle(a);
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            return a[i--];
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readInt());
        }
        for (int x : queue) {
            StdOut.print(x + " ");
        }
    }
}
