/**
 * GenericsB.java
 * Used to illustrate basic principles of generic types
 * and type safety in Java.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-23
 *
 */
public class GenericsB {

    /**
     * Make this method generic and type safe. Use a
     * type variable named T that will allow you to
     * find the minimum element of an array of any
     * type of mutually-comparable values.
     */
   public static <T extends Comparable<T>> T min(T[] a) {
      T min = a[0];
      for (T val : a) {
         if (val.compareTo(min) < 0) {
            min = val;
         }
      }
      return min;
   }

  /** Drives execution. */
   public static void main(String[] args) {
      Integer[] a2 = {4, 10, 2, 8, 6};
      String[] a3 = {"red", "orange", "yellow", "green", "blue", "indigo", "violet"};
   
      // You'll need to change some of these
      // statements once you make the min
      // method generic.
      Comparable min1 = GenericsB.<Integer>min(a2);
      System.out.println(min1);
      Comparable min2 = GenericsB.<String>min(a3);
      System.out.println(min2);
   }

}
