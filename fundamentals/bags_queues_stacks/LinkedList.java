package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    private int size;
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node next;
    }

    public LinkedList() {
        size = 0;
        first = new Node();
        last = first;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        size++;
    }

    public void deleteLast() {
        Node temp = first;
        while (temp != null) {
            if (temp.next.next == null)
                temp.next = null;
            temp = temp.next;
        }
    }

    public void delete(int k) {
        if (0 > k || k >= size)
            throw new IllegalArgumentException("fuck u");
        size--;
        int i = 0;
        Node temp = first;
        Node oldTemp = null;
        while (temp != null) {
            if (i == k) {
                if (i == 0) {
                    first = first.next;
                } else if (temp == last) {
                    oldTemp.next = null;
                    last = oldTemp;
                } else {
                    oldTemp.next = temp.next;
                }
            }
            oldTemp = temp;
            temp = temp.next;
            i++;
        }
    }

    public boolean find(Item key) {
        for (Item x : this)
            if (x.equals(key))
                return true;
        return false;
    }

    private void removeAfter(Node node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
            size--;
        }
    }

    private void insertAfter(Node node1, Node node2) {
        if (node1 == null || node2 == null)
            return;
        node2.next = node1.next;
        node1.next = node2;
        size++;
    }

    public void remove(Item key) {
        Node prev = null;
        for (Node curr = first; curr != null; curr = curr.next) {
            if (curr.item.equals(key)) {
                if (size == 1) {
                    first = null;
                    last = null;
                } else if (curr == first) {
                    first = curr.next;
                } else if (curr == last) {
                    prev.next = null;
                    last = prev;
                } else {
                    prev.next = curr.next;
                }
                size--;
            } else
                prev = curr;
        }
    }

    private int max() {
        return max(first);
    }

    private int max(Node node) {
        if (node.next == null) return (int) node.item;
        return Integer.max((int) node.item, max(node.next));
    }

    public Node reverse(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }

    public boolean contains(Item item) {
        for (Item x : this)
            if (x.equals(item))
                return true;
        return false;
    }

    private Node getNodeOf(Item item) {
        if (isEmpty()) return null;
        for (Node node = first; node != null; node = node.next)
            if (node.item.equals(item))
                return node;
        return null;
    }

    public void moveToFront(Item item) {
        Node node = getNodeOf(item);
        if (node == null)
            add(item);
        else {
            for (Node n = first; n != null; n=n.next) {
                if (n.next == node) {
                    n.next = node.next;
                    node.next = first;
                    first = node;
                    break;
                }
            }
        }
    }

//    public Node reverse(Node x) {
//        Node first = x;
//        Node reverse = null;
//        while (first != null) {
//            Node second = first.next;
//            first.next = reverse;
//            reverse = first;
//            first = second;
//        }
//        return reverse;
//    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    private class DoubleNode {
        Item item;
        DoubleNode prev;
        DoubleNode next;

    }

    public static void main(String[] args) {
//        LinkedList<String> list = new LinkedList<>();
//        StdOut.println("Enter what to find in a list: ");
//        String key = StdIn.readString();
//        StdOut.println("Enter a list: ");
//        while (!StdIn.isEmpty()) {
//            list.add(StdIn.readString());
//        }
//        list.remove(key);
//        StdOut.println("IsEmpty: " + list.isEmpty());
//        StdOut.println("Size: " + list.size());
//        StdOut.println("The List: ");
//        for (String s : list) {
//            StdOut.println(s);
//        }
//        StdOut.println("\"" + key + "\" is in the list: " + list.find(key));
//        maxTest();
        reverseTest();

    }

    private static void maxTest() {
        LinkedList<Integer> list = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            list.add(StdIn.readInt());
        }
        StdOut.println(list.max());
    }

    private static void reverseTest() {
        LinkedList<Integer> list = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            list.add(StdIn.readInt());
        }
        list.first = list.reverse(list.first);
        for (int x : list) {
            StdOut.print(x + " ");
        }
    }
}
