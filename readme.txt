Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that is equal to the search key.
 **************************************************************************** */

Since ordinary binary search returns the first "hit" for a searched item we
instead stored this first "hit" we updated hi to mid-1 to check the left of the
hit. After searching through the rest of the less than we returned our final
stored value since that would be the first instance of the searched item.

/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() : Timsort

allMatches() : Timsort

numberOfMatches() : none

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(n log2 (n))

allMatches():       (implements BinarySearch) Theta(m log2 (m)) + log2(n)

numberOfMatches():  (implements BinarySearch) Theta(log2(n))




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 **************************************************************************** */
 Saturday Lab TA, Kevin Wayne through private ed post

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */

We had some logic errors in our Term byPrefix method. Nothing major. We also had
problems with tests 3b-3d in Tiger file, but we discovered thats because when
computing multiple trials our r value was being mutated. We fixed this by using
a tempR and mutating that instead.

/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */

Partners: Lauren Gardner, Hannah Ulman

/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
 I actually enjoyed this assignment! - Lauren
 I like that this has a clear real world application - Hannah
