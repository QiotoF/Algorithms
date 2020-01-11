package fundamentals.data_abstraction;

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci {

    public static void main(String[] args) {

//        StdOut.print(binomial(100, 50, 0.25));

        double[][] a = new double[200][200];
        a[0][0] = 1.0;
        for (int i = 0; i < 100;i++) {
            for (int j = 0; j < 50; j++){
                if (i != 0 && j != 0) {
                    a[i][j] = (1-0.25)*a[i-1][j] + 0.25*a[i-1][j-1];
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                StdOut.println(a[i][j]);
            }
        }
    }


    public static double binomial(int n, int k, double p) {
        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        return (1 - p) * binomial(n-1, k, p) + p*binomial(n-1, k-1, p);
    }

}