package searching.symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import fundamentals.bags_queues_stacks.Queue;

public class ArrayST<Key, Value> {

    private int n;
    private Key[] keys;
    private Value[] vals;


    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        keys[n] = key;
        vals[n] = val;
        n++;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key))
                return vals[i];
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key))
                delete(i);
        }
    }

    private void delete(int i) {
        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        n--;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<>(100);
//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            String key = StdIn.readString();
//            st.put(key, i);
//        }
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (st.contains(key)) {
                StdOut.println(st.get(key));
            } else {
                if (key.equals("*")) {
                    st.delete(StdIn.readString());
                    continue;
                }
                String val = StdIn.readString();
                st.put(key, Integer.parseInt(val));
            }
        }
    }

}

