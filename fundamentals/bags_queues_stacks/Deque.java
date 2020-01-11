package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Deque<Item> {

    private Node left;
    private Node right;
    private int n;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public Deque() {
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            left = node;
            right = node;
        } else {
            left.prev = node;
            node.next = left;
            left = left.prev;
        }
        n++;
    }

    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            left = node;
            right = node;
        } else {
            right.next = node;
            node.prev = right;
            right = right.next;
        }
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("TwoStacksDeque is empty!");
        Item item = left.item;
        if (n == 1) {
            left = null;
            right = null;
        } else {
            left = left.next;
            left.prev = null;
        }
        n--;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("TwoStacksDeque is empty!");
        Item item = right.item;
        if (n == 1) {
            left = null;
            right = null;
        } else {
            right = right.prev;
            right.next = null;
        }
        n--;
        return item;
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.charAt(0) == 'l') {
                if (s.charAt(1) == '+') deque.pushLeft(s.substring(2));
                else if (s.charAt(1) == '-') StdOut.println(deque.popLeft());
            } else if (s.charAt(0) == 'r') {
                if (s.charAt(1) == '+') deque.pushRight(s.substring(2));
                else if (s.charAt(1) == '-') StdOut.println(deque.popRight());
            }
        }
    }
}
