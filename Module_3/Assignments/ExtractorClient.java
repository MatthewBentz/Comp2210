import java.util.Arrays;
import java.util.SortedSet;

/**
 * ExtractorClient.java.
 * Demonstrates feature extraction on sample data.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-02-27
 */
public class ExtractorClient {

   /** Sample point data. */
   private static Point[] p = new Point[] {
      // l1
      new Point(1, 0), 
      new Point(1, 1),
      new Point(1, 2),
      new Point(1, 3),
      new Point(1, 4),
      // l2
      new Point(3, 0), 
      new Point(3, 1),
      new Point(3, 2),
      new Point(3, 3),
      new Point(3, 4),
      // l3
      new Point(30, 5),
      new Point(31, 5),
      new Point(32, 5),
      new Point(33, 5),
      new Point(34, 5),
      // l4
      new Point(30, 6),
      new Point(31, 6),
      new Point(32, 6),
      new Point(33, 6),
      new Point(34, 6),
      // l5
      new Point(15, 9),
      new Point(16, 10),
      new Point(17, 11),
      new Point(18, 12),
      new Point(19, 13),
      // l6
      new Point(19, 9),
      new Point(18, 10),
      //new Point(17, 11), appears in l5 above; don't want duplicate
      new Point(16, 12),
      new Point(15, 13),
   };

   /** 
    * Drives execution.
    */
   public static void main(String[] args) {
      Extractor cl = new Extractor(Arrays.asList(p));
      SortedSet<Line> bruteLines = cl.getLinesBrute();
      System.out.println("Brute: ");
      printLines(bruteLines);
   
      SortedSet<Line> fastLines = cl.getLinesFast();
      System.out.println("Fast: ");
      printLines(fastLines);
   }
   
   /**
    * Prints an enumeration of the given set of lines.
    */
   private static void printLines(SortedSet<Line> lines) {
      int count = 0;
      for (Line line : lines) {
         System.out.println(++count + ": " + line);
      }
      System.out.println();
   }
}


/*

RUNTIME OUTPUT

Brute:
1: (1, 0) -> (1, 1) -> (1, 2) -> (1, 3)
2: (1, 0) -> (1, 1) -> (1, 2) -> (1, 4)
3: (3, 0) -> (3, 1) -> (3, 2) -> (3, 3)
4: (3, 0) -> (3, 1) -> (3, 2) -> (3, 4)
5: (1, 1) -> (1, 2) -> (1, 3) -> (1, 4)
6: (3, 1) -> (3, 2) -> (3, 3) -> (3, 4)
7: (30, 5) -> (31, 5) -> (32, 5) -> (33, 5)
8: (30, 5) -> (31, 5) -> (32, 5) -> (34, 5)
9: (31, 5) -> (32, 5) -> (33, 5) -> (34, 5)
10: (30, 6) -> (31, 6) -> (32, 6) -> (33, 6)
11: (30, 6) -> (31, 6) -> (32, 6) -> (34, 6)
12: (31, 6) -> (32, 6) -> (33, 6) -> (34, 6)
13: (15, 9) -> (16, 10) -> (17, 11) -> (18, 12)
14: (15, 9) -> (16, 10) -> (17, 11) -> (19, 13)
15: (19, 9) -> (18, 10) -> (17, 11) -> (16, 12)
16: (19, 9) -> (18, 10) -> (17, 11) -> (15, 13)
17: (16, 10) -> (17, 11) -> (18, 12) -> (19, 13)
18: (18, 10) -> (17, 11) -> (16, 12) -> (15, 13)

Fast:
1: (1, 0) -> (1, 1) -> (1, 2) -> (1, 3) -> (1, 4)
2: (3, 0) -> (3, 1) -> (3, 2) -> (3, 3) -> (3, 4)
3: (30, 5) -> (31, 5) -> (32, 5) -> (33, 5) -> (34, 5)
4: (30, 6) -> (31, 6) -> (32, 6) -> (33, 6) -> (34, 6)
5: (15, 9) -> (16, 10) -> (17, 11) -> (18, 12) -> (19, 13)
6: (19, 9) -> (18, 10) -> (17, 11) -> (16, 12) -> (15, 13)



 */

