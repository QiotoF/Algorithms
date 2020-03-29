package searching.binary_search_trees;

public class ArrayRepresentation {
    public static class BST<Key extends Comparable, Value> {

        int n;
        Key[] keys;
        Value[] vals;
        int[] leftLinks;
        int[] rightLinks;

        public BST(int maxSize) {
            n = 0;
            keys = (Key[]) new Object[maxSize];
            vals = (Value[]) new Object[maxSize];
            leftLinks = new int[maxSize];
            rightLinks = new int[maxSize];
        }

        public void put(Key key, Value val) {
            int currIndex = 0;
            while (keys[currIndex] != null) {
                if (keys[currIndex].compareTo(key) > 0) {
                    currIndex = leftLinks[currIndex];
                } else if (keys[currIndex].compareTo(key) < 0) {
                    currIndex = rightLinks[currIndex];
                } else {

                }
            }

        }

    }
}
