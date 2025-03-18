import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class BinarySearchDeluxe {
    /* @citation Adapted from: https://www.cs.princeton.edu/courses/archive/
    fall21/cos226/lectures/21ElementarySorts.pdf. Accessed 10/02/2021. */

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key>
            comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException();
        int lo = 0, hi = a.length - 1;
        int tempStore = a.length; // temp store for hit values
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compare = comparator.compare(key, a[mid]);
            if (compare < 0) hi = mid - 1;
            else if (compare > 0) lo = mid + 1;
            else if (mid < tempStore) {
                tempStore = mid; // store new hit value
                hi = mid - 1; // update hi counter to check left of hit
            }
        }
        if (tempStore == a.length) return -1;
        return tempStore;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key>
            comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException();
        int lo = 0, hi = a.length - 1;
        int tempStore = a.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compare = comparator.compare(key, a[mid]);
            if (compare < 0) hi = mid - 1;
            else if (compare > 0) lo = mid + 1;
            else {
                tempStore = mid; // store new hit value
                lo = mid + 1; // update counter to check right of hit
            }
        }
        if (tempStore == a.length) return -1;
        return tempStore;
    }

    // unit testing (required)
    public static void main(String[] args) {
        String[] a = { "G", "T", "T", "T", "T", "T" };
        int index = BinarySearchDeluxe.firstIndexOf(a, "G", String.
                CASE_INSENSITIVE_ORDER);
        int indexTwo = BinarySearchDeluxe.lastIndexOf(a, "G", String.
                CASE_INSENSITIVE_ORDER);
        StdOut.println(index + "\n" + indexTwo);
    }
}
