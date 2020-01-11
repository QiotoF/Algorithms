package sorting.priority_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class Point3D implements Comparable<Point3D> {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return x + " " + y + " " + z;
    }

    @Override
    public int compareTo(Point3D o) {
        double euclideanDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        double oEuclideanDistance = Math.sqrt(Math.pow(o.x, 2) + Math.pow(o.y, 2) + Math.pow(o.z, 2));
        return Double.compare(euclideanDistance, oEuclideanDistance);
    }
}

public class SelectionFilter {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        MaxPQ<Point3D> pq = new MaxPQ<Point3D>(m + 1);
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double z = StdIn.readDouble();
            pq.insert(new Point3D(x, y, z));
            if (pq.size() > m)
                pq.delMax();
        }

        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}
