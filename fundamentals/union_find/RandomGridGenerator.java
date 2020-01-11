package fundamentals.union_find;

import fundamentals.bags_queues_stacks.RandomBag;
import edu.princeton.cs.algs4.StdOut;

public class RandomGridGenerator {

    public class Connection {
        int p;
        int q;

        public Connection(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    public static void main(String[] args) {
        int numberOfSites = Integer.parseInt(args[0]);

        Connection[] connections = new RandomGridGenerator().generate(numberOfSites);

        StdOut.println("Connections");
        for(Connection connection : connections) {
            StdOut.println(connection.p + " - " + connection.q);
        }
    }

    public Connection[] generate(int numberOfSites) {
        RandomBag<Connection> randomBag = new RandomBag<>();

        //Considering the NxN grid as
        /*
          1 2 3 4
        1 - * * *
        2 * - * *
        3 * * - *
        4 * * * -
         */
        for(int i = 0; i < numberOfSites; i++) {
            for(int j = 0; j < numberOfSites; j++) {
                if (i != j) {
                    Connection connection = new Connection(i, j);
                    randomBag.add(connection);
                }
            }
        }

        Connection[] connections = new Connection[randomBag.size()];
        int index = 0;

        for(Connection connection : randomBag) {
            connections[index] = connection;
            index++;
        }

        return connections;
    }

}