package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item>  {

    private Item[] a;
    private int n;
    private int left;
    private int right;

    public ResizingArrayDeque() {
        a = (Item[]) new Object[0];
        n = 0;
        left = -1;
        right = -2;
    }

    private void resizeLeft(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        /*for (int i = right; i >= left; i--) {
            temp[temp.length - 1 - right + i] = a[i];
        }*/
        if (right - left + 1 > 0)
            System.arraycopy(a, left, temp, temp.length - 1 - right + left, right + 1 - left);
        a = temp;
        right = temp.length - 1;
        left = temp.length - n;
    }

    private void resizeRight(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        /*for (int i = left; i <= right; i++) {
            temp[0 - left + i] = a[i];
        }*/
        if (right + 1 - left > 0)
            System.arraycopy(a, left, temp, 0, right + 1 - left);
        a = temp;
        left = 0;
        right = n - 1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(Item item) {
        if (n == 0) resizeLeft(1);
        else if (left == 0) resizeLeft(a.length * 2);
        a[--left] = item;
        n++;
    }

    public void pushRight(Item item) {
        if (n == 0) resizeRight(1);
        else if (right == a.length - 1) resizeRight(a.length * 2);
        a[++right] = item;
        n++;
    }

    public Item popLeft() {
        if (n == 0) throw new NoSuchElementException("TwoStacksDeque is empty!");
        Item item = a[left++];
        n--;
        if (a.length / 2 >= n)
            resizeLeft(a.length / 2);
        return item;
    }

    public Item popRight() {
        if (n == 0) throw new NoSuchElementException("TwoStacksDeque is empty!");
        Item item = a[right--];
        n--;
        if (a.length / 2 >= n)
            resizeRight(a.length / 2);
        return item;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.charAt(0) == 'l') {
                if (s.charAt(1) == '+') deque.pushLeft(s.substring(2));
                else if (s.charAt(1) == '-') StdOut.println(deque.popLeft());
            } else if (s.charAt(0) == 'r'){
                if (s.charAt(1) == '+') deque.pushRight(s.substring(2));
                else if (s.charAt(1) == '-') StdOut.println(deque.popRight());
            }
        }
    }
}
