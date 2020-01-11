package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Rational {

    private long numerator;
    private long denominator;

    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        if (gcd != 1) {
            numerator /= gcd;
            denominator /= gcd;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational plus(Rational that) {
        return new Rational(
                this.numerator * that.denominator + that.numerator * this.denominator,
                this.denominator * that.denominator);
    }

    public Rational minus(Rational that) {
        return new Rational(
                this.numerator * that.denominator - that.numerator * this.denominator,
                this.denominator * that.denominator);
    }

    public Rational times(Rational that) {
        return new Rational(this.numerator * that.numerator, this.denominator * that.denominator);
    }

    public Rational dividedBy(Rational that) {
        return new Rational(this.numerator * that.denominator, this.denominator * that.numerator);
    }

    public boolean equals(Object that) {
        if (that == this) return true;
        if (that == null) return false;
        if (that.getClass() != this.getClass()) return false;
        Rational r = (Rational) that;
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

    public String toString() {
        if (numerator == 0) {
            return "0";
        }
        return numerator + "/" + denominator;
    }

    private static long gcd(long p, long q) {
        if (q == 0) {
            return p;
        }
        long r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        long numerator1 = StdIn.readLong();
        long denominator1 = StdIn.readLong();
        long numerator2 = StdIn.readLong();
        long denominator2 = StdIn.readLong();
        Rational a = new Rational(numerator1, denominator1);
        Rational b = new Rational(numerator2, denominator2);
        StdOut.println("a: " + a);
        StdOut.println("b: " + b);
        StdOut.println("a equals b: " + a.equals(b));
        StdOut.println("a + b: " + a.plus(b));
        StdOut.println("a - b: " + a.minus(b));
        StdOut.println("a * b: " + a.times(b));
        StdOut.println("a / b: " + a.dividedBy(b));
    }
}
