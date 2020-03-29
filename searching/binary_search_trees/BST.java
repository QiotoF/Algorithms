package searching.binary_search_trees;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdRandom;
import fundamentals.bags_queues_stacks.Queue;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int size;
        private int height;
        private int internalPathLength;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }

        public Node(Key key, Value val, int size, int internalPathLength) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.internalPathLength = internalPathLength;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, Key key, Value val, int depth) {
        if (x == null) return new Node(key, val, 1, depth);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val, depth + 1);
        else if (cmp > 0) x.right = put(x.right, key, val, depth + 1);
        else x.val = val;
        x.size = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.internalPathLength = internalPathLengthRecursive(x.left) + internalPathLengthRecursive(x.right) + depth;
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException();
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) throw new NoSuchElementException();
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) throw new NoSuchElementException();
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        return x;
    }

    public Key select(int rank) {
        if (rank < 0 || rank >= size()) throw new IllegalArgumentException();
        return select(root, rank).key;
    }

    private Node select(Node x, int rank) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > rank) return select(x.left, rank);
        if (t < rank) return select(x.right, rank - t - 1);
        return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        if (cmp > 0) return size(x.left) + 1 + rank(x.right, key);
        return size(x.left);
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException();
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException();
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMin(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public int height() {
//        return height(root);
        if (isEmpty()) return -1;
        return root.height;
    }

    private int height(Node x) {
        if (x == null) return -1;
        return Math.max(height(x.left), height(x.right)) + 1;
    }

    public double avgComparesRecursive() {
        if (isEmpty()) return 0;
        return internalPathLengthRecursive(root, 0) / (double) size() + 1;
    }

    private int internalPathLengthRecursive(Node x, int depth) {
        if (x == null) return 0;
        return depth + internalPathLengthRecursive(x.left, depth + 1) + internalPathLengthRecursive(x.right, depth + 1);
    }

    private int internalPathLengthRecursive(Node x) {
        if (x == null) return 0;
        return x.internalPathLength;
    }

    public double avgCompares() {
        if (isEmpty()) return 0;
        return internalPathLengthRecursive(root) / (double) size() + 1;
    }

    public static double optCompares(int n) {
        double internalPathLength = 0;
        for (int i = 0; i <= Math.floor(Math.log10(n) / Math.log10(2)); i++) {
            internalPathLength += (i * Math.pow(2.0, i));
        }
        internalPathLength /= n;
        return internalPathLength + 1;
    }

    Draw draw;

    public void draw(boolean printKeys, boolean dots) {
        draw = new Draw();
        double width = 1920. / 2;
        double height = 1024;
        draw.setCanvasSize((int) width, (int) height);
        draw.setPenRadius(0.006);
        draw.setXscale(0, width);
        draw.setYscale(0, height);
        double x = width / 2;
        double y = height - 150.;
        double link_width = width / 4;
        double link_height = 50;
        double circle_radius;
        if (dots) {
            circle_radius = 1;
            link_height = 20;
        } else circle_radius = 15;
        draw(root, x, y, link_height, link_width, circle_radius, printKeys);
    }

    private void draw(Node a, double x, double y, double link_height, double link_width, double circle_radius, boolean printKeys) {
        if (a == null) return;

        draw.circle(x, y, circle_radius);
        if (printKeys) draw.text(x, y, a.key.toString());
        double hypotenuse = Math.sqrt(Math.pow(link_height, 2) + Math.pow(link_width, 2));
        if (a.left != null) {
            draw.line(x - circle_radius * (link_width / hypotenuse), y - circle_radius * (link_height / hypotenuse),
                    x - link_width + circle_radius * (link_width / hypotenuse), y - link_height + circle_radius * (link_height / hypotenuse));
        }
        if (a.right != null) {
            draw.line(x + circle_radius * (link_width / hypotenuse), y - circle_radius * (link_height / hypotenuse),
                    x + link_width - circle_radius * (link_width / hypotenuse), y - link_height + circle_radius * (link_height / hypotenuse));
        }
        draw(a.left, x - link_width, y - link_height, link_height, link_width / 2, circle_radius, printKeys);
        draw(a.right, x + link_width, y - link_height, link_height, link_width / 2, circle_radius, printKeys);
    }

    public static void main(String[] args) {
        BST<Double, Integer> st = new BST<>();

//        StdOut.println(BST.optCompares(StdIn.readInt()));

//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            st.put(StdIn.readString(), i);
//        }

        int N = 100;
        for (int i = 0; i < N; i++) {
            st.put(StdRandom.uniform(), i);
        }

        st.draw(false, false);

//        StdOut.println(st.avgCompares());

//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            switch (s) {
//                case "size":
//                    StdOut.println(st.size());
//                    break;
//                case "empty":
//                    StdOut.println(st.isEmpty());
//                    break;
//                case "contains":
//                    StdOut.println(st.contains(StdIn.readString()));
//                    break;
//                case "put":
//                    st.put(StdIn.readString(), StdIn.readInt());
//                    break;
//                case "get":
//                    StdOut.println(st.get(StdIn.readString()));
//                    break;
//                case "delete":
//                    st.delete(StdIn.readString());
//                    break;
//                case "min":
//                    StdOut.println(st.min());
//                    break;
//                case "max":
//                    StdOut.println(st.max());
//                    break;
//                case "floor":
//                    StdOut.println(st.floor(StdIn.readString()));
//                    break;
//                case "ceiling":
//                    StdOut.println(st.ceiling(StdIn.readString()));
//                    break;
//                case "rank":
//                    StdOut.println(st.rank(StdIn.readString()));
//                    break;
//                case "select":
//                    StdOut.println(st.select(StdIn.readInt()));
//                    break;
//                case "deleteMin":
//                    st.deleteMin();
//                    break;
//                case "deleteMax":
//                    st.deleteMax();
//                    break;
//                case "sizeBetween":
////                    st.size(StdIn.readString(), StdIn.readString());
//                    break;
//                case "keys":
//                    for (String key : st.keys()) StdOut.println(key + " ");
//                    break;
//                case "keysBetween":
////                    for (String key : st.keys(StdIn.readString(), StdIn.readString())) StdOut.println(key + " ");
//                    break;
//                default:
//                    break;
//
//            }
//        }
    }
}
