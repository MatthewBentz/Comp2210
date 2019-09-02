/**
 * GenericsA.java
 * Used to illustrate basic principles of generic types
 * and type safety in Java.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-23
 *
 */
public class GenericsA {

   /**
    * Make this method generic. Use a type variable named
    * T that will allow you to search through an array
    * of any type and return the location of target in a
    * or -1 if it doesn't exist.
    */
   public static <T> int search(T[] a, T target) {
      int i = 0;
      while ((i < a.length) && (!a[i].equals(target))) {
         i++;
      }
      if (i < a.length) {
         return i;
      }
      else {
         return -1;
      }
   }

  /** Drives execution. */
   public static void main(String[] args) {
      // You'll need to change these statements once
      // you make the search method generic.
      Integer[] a1 = {4, 10, 2, 8, 6};
      int i = GenericsA.<Integer>search(a1, 8);
      System.out.println(i);
   }

}
