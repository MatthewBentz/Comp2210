import java.util.Random;

/**
 * TimingCode.java
 * Illustrates basic approach to measuring a method's
 * running time.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-31
 *
 */
public class TimingCode {

   // number of timing runs to make
   private static final int NUM_RUNS = 10;

   // 1.0E9 ns per second
   private static final double SECONDS = 1_000_000_000d;

   /** Drives execution. */
   public static void main(String[] args) {
      long start;
      long elapsedTime;
      double avgTime = 0d;
      for (int i = 0; i < NUM_RUNS; i++) {
         start = System.nanoTime();
         int f = foo();
         elapsedTime = System.nanoTime() - start;
         avgTime += elapsedTime;
      }
      avgTime = avgTime / NUM_RUNS;
      // convert to seconds
      avgTime = avgTime / SECONDS;
      System.out.printf("%s%4.3f%s\n", "Method foo's running time: ", avgTime, " seconds");
   }


   /**
    * Something that (hopefull) takes time >= 0.001 seconds
    * so that the program output looks better.
    */
   private static int foo() {
      int[] a = new int[100];
      Random rng = new Random();
      for (int i = 0; i < a.length; i++) {
         a[i] = rng.nextInt();
      }
      int sum = 0;
      for (int i = 0; i < 100_000; i++) {
         for (int val : a) {
            sum = sum + val;
         }
      }
      return sum;
   }

}
