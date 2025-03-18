import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Autocomplete {

    private Term[] defTerms; // defensive array to copy to
    private int first; // index of first prefix match
    private int last; // index of last prefix match

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) throw new IllegalArgumentException("Null Array");

        defTerms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            if (terms[i] == null) throw new IllegalArgumentException("Null Element");
            defTerms[i] = terms[i];
        }
        Arrays.sort(defTerms);

        first = -1;
        last = -1;
    }

    // Returns all terms that start with the given prefix, in descending order
    // of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) throw new IllegalArgumentException("Null Argument");

        Term[] matches = new Term[numberOfMatches(prefix)];

        if (numberOfMatches(prefix) == 0) {
            return matches;
        }

        for (int i = 0; i < matches.length; i++) {
            matches[i] = defTerms[first + i];
        }

        Comparator<Term> comparator = Term.byReverseWeightOrder();
        Arrays.sort(matches, comparator);
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) throw new IllegalArgumentException("Null Argument");

        int r = prefix.length();
        Comparator<Term> comparator = Term.byPrefixOrder(r);
        Term tempTerm = new Term(prefix, 0);
        first = BinarySearchDeluxe.firstIndexOf(defTerms, tempTerm, comparator);
        last = BinarySearchDeluxe.lastIndexOf(defTerms, tempTerm, comparator);
        if (first < 0) return 0;
        return (last - first) + 1;
    }

    public static void main(String[] args) {
        /* @citation Adapted from: https://www.cs.princeton.edu/courses/archive
        /fall21/cos226/assignments/autocomplete/specification.php.
        Accessed 10/04/2021. */

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
