/**
 * LinearSearch2.java
 * Provides an (incorrect) implementation of linear search.
 *
 * @author:  Dean Hendrix (dh@auburn.edu)
 * @version: 2016-08-16
 *
 */

public final class LinearSearch2 {

   /**
    * Returns the index of the first occurence of target in a or
    * -1 if target is not present. This method implements the
    * linear search algorithm.
    *
    * @param   a  the array to be searched through
    * @param   target  the value to be searched for
    * @return  the index target in a or -1
    */
   public static int search(int[] a, int target) {
      for (int i = 0; i < a.length; i++) {
         if (a[i] == target) {
            return i;
         }
      }
      return -1;
   }

}
