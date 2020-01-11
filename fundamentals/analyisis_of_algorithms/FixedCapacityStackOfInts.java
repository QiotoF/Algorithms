package fundamentals.analyisis_of_algorithms;

public class FixedCapacityStackOfInts {

    private int[] a;
    private int n;

    public FixedCapacityStackOfInts(int capacity) {
        a = new int[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(int item) {
        a[n++] = item;
    }

    public int pop() {
        return a[--n];
    }

    public boolean isFull() {
        return n == a.length;
    }

//    public static void main(String[] args) {
//        FixedCapacityStackOfInts s = new FixedCapacityStackOfInts(100);
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readInt();
//            if (!item.equals("-"))
//                s.push(item);
//            else if (!s.isEmpty())
//                StdOut.print(s.pop() + " ");
//        }
//        StdOut.println("(" + s.size() + " left on stack)");
//    }

}
