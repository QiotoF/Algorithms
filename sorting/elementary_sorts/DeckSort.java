package sorting.elementary_sorts;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DeckSort {

    public static class Card implements Comparable<Card> {
        private String suit;
        private int rank;

        public Card(String suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return suit + " " + rank;
        }

        @Override
        public int compareTo(Card o) {
            if (this.suit.equals(o.suit)) {
                return Integer.compare(this.rank, o.rank);
            } else {
                if (this.suit.equals("Spade"))
                    return 1;
                if (o.suit.equals("Spade"))
                    return -1;
                if (this.suit.equals("Heart"))
                    return 1;
                if (o.suit.equals("Heart"))
                    return -1;
                if (this.suit.equals("Club"))
                    return 1;
                if (o.suit.equals("Club"))
                    return -1;
                throw new IllegalArgumentException("fuck u");
            }
        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        Card[] a = new Card[n];
        for (int i = 0; i < n; i++) {
            String suit = StdIn.readString();
            int rank = StdIn.readInt();
            a[i] = new Card(suit, rank);
        }
        Shell.sort(a);
        show(a);
    }

    private static void show(Comparable[] a) {
        for (Comparable c : a)
            StdOut.print(c + " ");
        StdOut.println();
    }
}