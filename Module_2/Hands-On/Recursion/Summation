/**
 * Provides recursive and iterative implementations of summation function.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-23
 */
public class Summation {

	/** Returns the sum of 1..n for n > 0. */
   public static int sumI(int n) {
      int sum = 1;
      for (int i = 2; i <= n; i++) {
         sum = sum + i;
      }
      return sum;
   }

	/** Returns the sum of 1..n  */
   public static int sumR(int n) {
      if (n == 1) {
         return 1;
      }
      return n + sumR(n - 1);
   }

	/** Drives execution. */
   public static void main(String[] args) {
      for (int i = 1; i < 10; i++) {
         int s1 = sumI(i);
         int s2 = sumR(i);
         System.out.println(i + ": " + s1 + ", " + s2);
      }
   
      int sum = sumI(5);
      sum = sumR(5);
      System.out.println(sum);
   }
}
