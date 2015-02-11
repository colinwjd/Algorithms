package util;

import common.In;
import common.Out;

/**
 *  The <tt>Cat</tt> class provides a client for concatenating the results
 *  of several text files.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Cat { 

   // this class should not be instantiated
   private Cat() { }

    /**
     * Reads in a sequence of text files specified as the first command-line
     * arguments, concatenates them, and writes the results to the file
     * specified as the last command-line argument.
     */
    public static void main(String[] args) { 
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }

}
