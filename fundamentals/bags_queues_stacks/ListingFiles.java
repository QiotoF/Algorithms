package fundamentals.bags_queues_stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class ListingFiles {

    public static void listFiles(File file) {
        listFiles(file, "");
    }

    public static void listFiles(File file, String indent) {
        StdOut.println(indent + file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File x : files) {
                listFiles(x, indent + "   ");
            }
        }

    }

    public static void main(String[] args) {
        String pathname = StdIn.readString();
        File file = new File(pathname);
        if (file.exists()) {
            listFiles(file);
        }
    }
}
