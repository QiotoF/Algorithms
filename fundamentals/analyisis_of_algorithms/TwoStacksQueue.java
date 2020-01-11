package fundamentals.analyisis_of_algorithms;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TwoStacksQueue<Item>  {

    private Stack<Item> inbox;
    private Stack<Item> outbox;
    private int n;


    public TwoStacksQueue() {
        inbox = new Stack<>();
        outbox = new Stack<>();
        n = 0;
    }

    public boolean isEmpty() {
        return outbox.isEmpty() && inbox.isEmpty();
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        inbox.push(item);
        n++;
    }

    public Item dequeue() {
        if (outbox.isEmpty())
            while (!inbox.isEmpty())
                outbox.push(inbox.pop());
        n--;
        return outbox.pop();
    }

    public static void main(String[] args) {
        TwoStacksQueue<String> q = new TwoStacksQueue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            q.enqueue(item);
        }

        while (!q.isEmpty())
            StdOut.println(q.dequeue());
    }


}
