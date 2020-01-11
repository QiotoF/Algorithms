package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {

    private String[] a;
    private int n;
    private int first;
    private int last;

    public ResizingArrayQueueOfStrings() {
        a = new String[1];
        n = 0;
        first = 0;
        last = 0;
    }

    private void resize(int capacity) {
        String[] temp;
        temp = new String[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[(first + i) % a.length];
        }
        a = temp;
        first = 0;
        last  = n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(String s) {
        if (last == a.length) {
            resize(a.length * 2);
        }
        a[last++] = s;
        n++;
    }

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        String s = a[first++];
        n--;
        if (last <= a.length /4) {
            resize(a.length / 2);
        }
        return s;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        StdOut.println("Size is " + queue.size());
        while (!queue.isEmpty()) {
            StdOut.println(queue.dequeue());
        }
    }
}
