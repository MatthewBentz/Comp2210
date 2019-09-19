/**
 * Provides a sum function on arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-26
 */
public class ArraySum {

	/** Returns the sum of values in the given array. */
   public static int sum(int[] a, int left, int right) {
      if (left > right) {
         return 0;
      }
      return a[left] + sum(a, ++left, right);
   }
}
