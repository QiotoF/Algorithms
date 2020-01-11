package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayGeneralizedQueue<Item> {

    private Item[] a;
    private int n;
    private int first;
    private int last;

    public ResizingArrayGeneralizedQueue() {
        n = 0;
        a = (Item[]) new Object[1];
        first = 0;
        last = 0;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[(first + i) % a.length];
        }
        first = 0;
        last = n;
        a = temp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Item x) {
        if (last == a.length) {
            resize(a.length * 2);
        }
        a[last++] = x;
        n++;
    }

    public Item delete(int k) {
        Item item = a[last - k];
        for (int i = last - k + 1; i <= last; i++) {
            a[i-1] = a[i];
        }
        a[last--] = null;
        n--;
        if (last <= a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public static void main(String[] args) {
        ResizingArrayGeneralizedQueue<String> queue = new ResizingArrayGeneralizedQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            try {
                int k = Integer.parseInt(s);
                StdOut.println(queue.delete(k));
            } catch (NumberFormatException e) {
                queue.insert(s);
            }
        }
    }

}
