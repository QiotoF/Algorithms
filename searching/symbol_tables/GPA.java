package searching.symbol_tables;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GPA {
    public static void main(String[] args) {
        BinarySearchST<String, Double> grades = new BinarySearchST<>(11);
        grades.put("A+", 4.33);
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D", 1.00);
        grades.put("F", 0.00);

        double gpa = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            String grade = StdIn.readString();
            gpa += grades.get(grade);
            count++;
        }
        gpa /= count;

        StdOut.println(gpa);

    }
}
