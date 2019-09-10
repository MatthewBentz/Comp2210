import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Sorts.java
 * Provides sample implementations of the following sorting algorithms.
 *    - insertion sort
 *    - selection sort
 *    - recursive mergesort
 *    - recursive quicksort with shuffling (randomized quicksort)
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Robert Sedgewick and Kevin Wayne
 * @version 2016-09-23
 */
public class Sorts<T extends Comparable<T>> {

  /**
   * Exercises all the sorting methods as well as
   * partioning and merging separately.
   */
   public static void main(String[] args) {

      Integer[] a = {2, 16, 4, 8, 12, 6, 4, 10, 16, 8, 18, 14};
      Sorts<Integer> sorts = new Sorts<>();

      // selection sort
      sorts.shuffle(a);
      sorts.selectionSort(a);
      assert sorts.isSorted(a);

      // insertion sort
      sorts.shuffle(a);
      sorts.insertionSort(a);
      assert sorts.isSorted(a);

      // quicksort
      sorts.shuffle(a);
      sorts.quicksort(a);
      assert sorts.isSorted(a);

      // partition
      a = new Integer[]{2, 16, 4, 8, 12, 6, 4, 10, 16, 8, 18, 14};
      sorts.partitionOnPivot(a, 0, a.length - 1, 5);

      // merge sort
      sorts.shuffle(a);
      sorts.mergesort(a);
      assert sorts.isSorted(a);

      // merge
      a = new Integer[]{4, 8, 10, 14, 16, 18, 2, 4, 6, 8, 12, 16};
      int lo = 0;
      int hi = a.length - 1;
      int mid = (lo + hi) / 2;
      sorts.merge(a, lo, mid, hi);

   }


   ////////////////////
   // INSERTION SORT //
   ////////////////////

   /** Sorts a into ascending order using the insertion sort algorithm. */
   public void insertionSort(T[] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = i; j > 0; j--) {
            if (less(a[j], a[j - 1])) {
               swap(a, j, j - 1);
            } else {
               break;
            }
         }
      }
   }


   ////////////////////
   // SELECTION SORT //
   ////////////////////

   /** Sorts a into ascending order using the selection sort algorithm. */
   public void selectionSort(T[] a) {
      for (int i = 0; i < a.length; i++) {
         int min = i;
         for (int j = i + 1; j < a.length; j++) {
            if (less(a[j], a[min])) {
               min = j;
            }
         }
         swap(a, i, min);
      }
   }


   /////////////////////////
   // RECURSIVE MERGESORT //
   /////////////////////////

   // Extra memory needed for merging
   private T[] aux;

   /** Front-facing method for mergesort. Initializes aux and calls msort. */
   public void mergesort(T[] a) {
      aux = Arrays.copyOf(a, a.length);
      Arrays.fill(aux, null);
      msort(a, 0, a.length - 1);
      Arrays.fill(aux, null);
   }

   /** Sorts a[lo..hi] into ascending order using the recursive mergesort algorithm. */
   private void msort(T[] a, int lo, int hi) {
      if (hi == lo) {
         return;
      }
      int mid = lo + (hi - lo) / 2;
      msort(a, lo, mid);
      msort(a, mid + 1, hi);
      merge(a, lo, mid, hi);
   }

   /** Merges sorted halves into one sorted array. */
   private void merge(T[] a, int lo, int mid, int hi) {
      for (int k = lo; k <= hi; k++) {
         aux[k] = a[k];
      }

      int i = lo;
      int j = mid + 1;
      for (int k = lo; k <= hi; k++) {
         if (i > mid) {
            a[k] = aux[j++];
         } else if (j > hi) {
            a[k] = aux[i++];
         } else if (less(aux[j], aux[i])) {
            a[k] = aux[j++];
         }
         else {
            a[k] = aux[i++];
         }
      }
   }


   /////////////////////////
   // RECURSIVE QUICKSORT //
   /////////////////////////

   /** Calls qsort after first shuffling a. Reduces chance of worst-case pivot choices. */
   public void quicksort(T[] a) {
      shuffle(a);
      qsort(a, 0, a.length - 1);
   }

   /** Sorts a[lo..hi] into ascending order using recursive quicksort. */
   private void qsort(T[] a, int lo, int hi) {
      if (hi <= lo) {
         return;
      }
      //int j = partition(a, lo, hi);
      int j = partitionOnPivot(a, lo, hi, lo);
      qsort(a, lo, j - 1);
      qsort(a, j + 1, hi);
   }

   /** Partition algorithm used by Sedgewick and Wayne. */
   private int partition(T[] a, int lo, int hi) {
      int i = lo;
      int j = hi + 1;
      while (true) {
         while (less(a[++i], a[lo])) {
            if (i == hi) {
               break;
            }
         }

         while (less(a[lo], a[--j])) {
            if (j == lo) {
               break;
            }
         }

         if (i >= j) {
            break;
         }
         swap(a, i, j);
      }
      swap(a, lo, j);
      return j;
   }

   /**
    * Partition algorithm shown on Wikipedia.
    * Used to generate lecture examples for partitioning.
    */
   private int partitionOnPivot(T[] a, int left, int right, int pivotIndex) {
      T pivot = a[pivotIndex];
      swap(a, pivotIndex, right); // move pivot to the end
      int p = left; // p will become the final index of pivot
      for (int i = left; i < right; i++) {
         if (less(a[i], pivot)) {
            swap(a, i, p);
            p++;
         }
      }
      swap(a, p, right); // move pivot to its correct location
      return p;
   }


   /////////////////////
   // UTILITY METHODS //
   /////////////////////

   /** Shuffles the elements in a into a random permutation
   using the Knuth (Fisher-Yates) Shuffle algorithm.
   https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle */
   public void shuffle(T[] a) {
      Random rng = new Random();
      for (int i = a.length - 1; i > 0; i--) {
         int j = rng.nextInt(i + 1);
         swap(a, i, j);
      }
   }

   /** Returns true if x < y, false otherwise. */
   private boolean less(T x, T y) {
      return x.compareTo(y) < 0;
   }

   /** Swaps the values in a[i] and a[j]. */
   private void swap(T[] a, int i, int j) {
      T temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /** Returns true if the elements of a are in ascending order, false otherwise. */
   public boolean isSorted(T[] a) {
      for (int i = 0; i < a.length - 1; i++) {
         if (less(a[i + 1], a[i])) {
            return false;
         }
      }
      return true;
   }

}
