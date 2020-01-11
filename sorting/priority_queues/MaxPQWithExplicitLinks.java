package sorting.priority_queues;

public class MaxPQWithExplicitLinks<Key extends Comparable<Key>> {

    private Node root;
    private Node last;
    private int n;

    private class Node {
        Key key;
        Node parent;
        Node left;
        Node right;
    }

    public MaxPQWithExplicitLinks() {
        root = null;
        last = null;
        n = 0;
    }


    public void insert(Key key) {
        Node node = new Node();
        node.key = key;

        if (n == 0) {
            root = node;
            last = node;
            n++;
            return;
        }

        Node temp = last;
        if (temp != root && temp.parent.left == temp) {
            temp.parent.right = node;
            node.parent = temp.parent;
        } else {
            while (temp != root && temp.parent.right == temp) temp = temp.parent;
            if (temp != root) {
                temp = temp.parent.right;
            }
            while (temp.left != null) temp = temp.left;
            temp.left = node;
            node.parent = temp;
        }
        last = node;
//        swim(node);
        n++;
    }

    private void swim(Node node) {
        while (node.parent != null && less(node.parent, node)) exch(node, node.parent);
    }

    private boolean less(Node a, Node b) {
        return a.key.compareTo(b.key) < 0;
    }

    private void exch(Node a, Node b) {
        Node aParent = a.parent;
        Node aLeft = a.left;
        Node aRight = a.right;
        if (a != root)
            if (isLeftChild(a)) a.parent.left = b;
            else a.parent.right = b;
        if (a.left != null) a.left.parent = b;
        if (a.right != null) a.right.parent = b;
        a.parent = b.parent;
        a.left = b.left;
        a.right = b.right;
        if (b != root)
            if (isLeftChild(b)) b.parent.left = a;
            else b.parent.right = a;
        if (b.left != null) b.left.parent = a;
        if (b.right != null) b.right.parent = a;
        b.parent = aParent;
        b.left = aLeft;
        b.right = aRight;
    }

    private boolean isLeftChild(Node node) {
        if (node == root) throw new IllegalArgumentException("Node is root!");
        return node.parent.left == node;
    }


    public static void main(String[] args) {
        MaxPQWithExplicitLinks pq = new MaxPQWithExplicitLinks<Integer>();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < a.length; i++) {
            pq.insert(a[i]);
        }
        pq.exch(pq.root.left, pq.root.right);
    }
}
