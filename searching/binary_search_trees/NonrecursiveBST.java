package searching.binary_search_trees;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class NonrecursiveBST<Key extends Comparable, Value> {

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value val) {
        Node x = root;
        Node parent = null;
        int cmp = 0;
        while (x != null) {
            parent = x;
            cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }
        }
        Node temp = new Node(key, val, 1);
        if (root == null) root = temp;
        else if (cmp < 0) parent.left = temp;
        else parent.right = temp;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.val;
            else if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
        }
        return null;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = root;
        while (x.left != null) x = x.left;
        return x.key;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = root;
        while (x.right != null) x = x.right;
        return x.key;
    }

    public Key floor(Key key) {
        Node x = root;
        Key floor = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) {
                floor = x.key;
                x = x.right;
            } else return x.key;
        }
        if (floor == null) throw new NoSuchElementException();
        return floor;
    }

    public Key ceiling(Key key) {
        Node x = root;
        Key ceiling = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) x = x.left;
            else if (cmp < 0) {
                ceiling = x.key;
                x = x.left;
            } else return x.key;
        }
        if (ceiling == null) throw new NoSuchElementException();
        return ceiling;
    }

    public static void main(String[] args) {
        NonrecursiveBST<String, Integer> st = new NonrecursiveBST<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
//                case "size":
//                    StdOut.println(st.size());
//                    break;
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
            }
        }
    }
}
