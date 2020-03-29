package searching.balanced_search_trees;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.n = n;
        }

        Key key;
        Value val;
        boolean color;
        Node left;
        Node right;
        int n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.n;
    }

    public boolean contains(Key key) {
        return get(key) != null;
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

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1, RED);

        int cmp = key.compareTo(x.key);
        if (cmp > 0) x.right = put(x.right, key, val);
        else if (cmp < 0) x.left = put(x.left, key, val);
        else x.val = val;

        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);

        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node rotateRight(Node x) {
        Node r = x.left;
        x.left = r.right;
        r.right = x;
        r.color = x.color;
        x.color = RED;
        return r;
    }

    private Node rotateLeft(Node x) {
        Node r = x.right;
        x.right = r.left;
        r.left = x;
        r.color = x.color;
        x.color = RED;
        return r;
    }

    private void flipColors(Node x) {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
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
            if (a.left.color == RED) draw.setPenColor(Color.RED);
            draw.line(x - circle_radius * (link_width / hypotenuse), y - circle_radius * (link_height / hypotenuse),
                    x - link_width + circle_radius * (link_width / hypotenuse), y - link_height + circle_radius * (link_height / hypotenuse));
            draw.setPenColor(Color.BLACK);
        }
        if (a.right != null) {
            if (a.right.color == RED) draw.setPenColor(Color.RED);
            draw.line(x + circle_radius * (link_width / hypotenuse), y - circle_radius * (link_height / hypotenuse),
                    x + link_width - circle_radius * (link_width / hypotenuse), y - link_height + circle_radius * (link_height / hypotenuse));
            draw.setPenColor(Color.BLACK);
        }
        draw(a.left, x - link_width, y - link_height, link_height, link_width / 2, circle_radius, printKeys);
        draw(a.right, x + link_width, y - link_height, link_height, link_width / 2, circle_radius, printKeys);
    }

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> st = new RedBlackBST<>();

//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            st.put(StdIn.readString(), i);
//        }

        for (int i = 0; i < 100; i++) {
            st.put(StdRandom.uniform(0, 100), i);
        }

        st.draw(false, true);
    }
}
