package searching.symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import fundamentals.bags_queues_stacks.Queue;

import java.util.NoSuchElementException;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

    private Node first;
    private int n;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public OrderedSequentialSearchST() {
        n = 0;
        first = null;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) if (x.key.equals(key)) return true;
        return false;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) return;
        if (first == null || first.key.compareTo(key) > 0) first = new Node(key, val, first);
        else {
            Node x = first;
            while (x.next != null && x.next.key.compareTo(key) <= 0) {
                if (x.key.equals(key)) {
                    x.val = val;
                    return;
                }
                x = x.next;
            }
            x.next = new Node(key, val, x.next);
        }
        n++;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) return x.val;
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        first = delete(key, first);
    }

    private Node delete(Key key, Node node) {
        if (node == null) return null;
        if (node.key.equals(key)) {
            n--;
            return node.next;
        } else {
            node.next = delete(key, node.next);
            return node;
        }
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Symbol Table is empty!");
        return first.key;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Symbol Table is empty!");
        Node x = first;
        while (x.next != null) x = x.next;
        return x.key;
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("Key is null!");
        if (isEmpty()) throw new NoSuchElementException("Symbol Table is empty!");
        if (first.key.compareTo(key) > 0) return first.key;
        Node x = first;
        while (x.next != null && x.next.key.compareTo(key) <= 0) x = x.next;
        return x.key;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("Key is null!");
        if (isEmpty()) throw new NoSuchElementException("Symbol Table is empty!");
        Node x = first;
        while (x.next != null && x.key.compareTo(key) < 0) x = x.next;
        return x.key;
    }

    public int rank(Key key) {
        int rank = 0;
        for (Node x = first; x.key.compareTo(key) < 0; x = x.next) rank++;
        return rank;
    }

    public Key select(int k) {
        if (!(k >= 0 && k < n)) return null;
        Node x = first;
        for (int i = 0; i <k; i++) {
            x = x.next;
        }
        return x.key;
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public int size(Key lo, Key hi) {
        return rank(lo) - rank(hi) + 1;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null && x.key.compareTo(hi) <= 0; x = x.next)
            if (x.key.compareTo(lo) >= 0) queue.enqueue(x.key);
        return queue;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }


    public static void main(String[] args) {
        OrderedSequentialSearchST<String, Integer> st = new OrderedSequentialSearchST<>();
//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            String key = StdIn.readString();
//            st.put(key, i);
//        }
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "size":
                    StdOut.println(st.size());
                    break;
                case "empty":
                    StdOut.println(st.isEmpty());
                    break;
                case "contains":
                    StdOut.println(st.contains(StdIn.readString()));
                    break;
                case "put":
                    st.put(StdIn.readString(), StdIn.readInt());
                    break;
                case "get":
                    StdOut.println(st.get(StdIn.readString()));
                    break;
                case "delete":
                    st.delete(StdIn.readString());
                    break;
                case "min":
                    StdOut.println(st.min());
                    break;
                case "max":
                    StdOut.println(st.max());
                    break;
                case "floor":
                    StdOut.println(st.floor(StdIn.readString()));
                    break;
                case "ceiling":
                    StdOut.println(st.ceiling(StdIn.readString()));
                    break;
                case "rank":
                    StdOut.println(st.rank(StdIn.readString()));
                    break;
                case "select":
                    StdOut.println(st.select(StdIn.readInt()));
                    break;
                case "deleteMin":
                    st.deleteMin();
                    break;
                case "deleteMax:":
                    st.deleteMax();
                    break;
                case "sizeBetween":
                    st.size(StdIn.readString(), StdIn.readString());
                    break;
                case "keys":
                    for (String key : st.keys()) StdOut.println(key + " ");
                    break;
                case "keysBetween":
                    for (String key : st.keys(StdIn.readString(), StdIn.readString())) StdOut.println(key + " ");
                    break;
                default:
                    break;

            }
        }
    }

}

