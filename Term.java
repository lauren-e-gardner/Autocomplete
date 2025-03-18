import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query; // stores the word in a string
    private long weight; // stores the associated weight of the term


    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0) throw new IllegalArgumentException();
        this.query = query;
        this.weight = weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ComparisonWeight();
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException("r cannot be negative");
        return new ComparisonLexigraph(r);
    }

    private static class ComparisonWeight implements Comparator<Term> {
        // compares two terms based on their weight
        public int compare(Term termOne, Term termTwo) {
            // returns -1 if the weight of termOne > termTwo
            // returns 1 if the weight of termOne < termTwo
            // returns 0 if the weight of termOne == termTwo
            return Long.compare(termTwo.weight, termOne.weight);
        }
    }

    private static class ComparisonLexigraph implements Comparator<Term> {
        private int r; // size of substring

        // constructor for ComparisonLexigraph, initializes the substring
        public ComparisonLexigraph(int r) {
            this.r = r;
        }

        // Compares two substrings of length r lexicographically
        public int compare(Term termOne, Term termTwo) {

            int lengthOne = termOne.query.length();
            int lengthTwo = termTwo.query.length();

            // stores input prefix length to check later
            int initR = r;

            // corner cases if at least one query length is less than input length
            if (lengthOne <= lengthTwo && lengthOne < r) r = lengthOne;
            if (lengthTwo <= lengthOne && lengthTwo < r) r = lengthTwo;

            // compares each character in word order up to specified prefix length
            // until characters differ, or checks corner cases and returns
            // appropriate integer if characters never differ
            for (int i = 0; i < r; i++) {
                char charOne = termOne.query.charAt(i);
                char charTwo = termTwo.query.charAt(i);
                if (charOne != charTwo) {
                    if (charOne > charTwo) return 1;
                    return -1;
                }
            }

            // 'normal' case: prefixes are identical up to input prefix length
            if (lengthOne >= initR && lengthTwo >= initR) return 0;
            // words are identical (and both shorter than input prefix length)
            if (lengthOne == lengthTwo) return 0;
            // first word is shorter than input prefix length and identical to
            // prefix of second word
            if (r < lengthTwo) return -1;
            // second word is shorter than input prefix length and identical to
            // prefix of first word
            return 1;
        }
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return Integer.compare(query.compareTo(that.query), 0);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "\t" + query;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Term word1 = new Term("CCGTA", 8);
        Term word2 = new Term("CCGTGA", 9);
        StdOut.println(word1.toString() + "\n" + word2.toString());
        StdOut.println("Weight order: " +
                               byReverseWeightOrder().compare(word1, word2));
        StdOut.println("Prefix order: " +
                               byPrefixOrder(100).compare(word1, word2));
        StdOut.println("Lex order: " + word1.compareTo(word2));
    }
}
