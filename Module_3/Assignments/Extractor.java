import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Matthew Bentz (mlb0119@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 10/6/19
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) {
      try {
         Scanner scan = new Scanner(new File(filename));
         points = new Point[scan.nextInt()];
         for (int i = 0; i < points.length; i++) {
            points[i] = new Point(scan.nextInt(), scan.nextInt());
         }
      }
      catch (java.io.FileNotFoundException e) {
         
      }
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      Line line = new Line();
      for (int i = 0; i < points.length; i++) {
         for (int i2 = i + 1; i2 < points.length; i2++) {
            for (int i3 = i2 + 1; i3 < points.length; i3++) {
               for (int i4 = i3 + 1; i4 < points.length; i4++) {
                  if (line.add(points[i]) && line.add(points[i2])
                        && line.add(points[i3]) && line.add(points[i4])) {
                     lines.add(line);
                  }
                  line = new Line();
               }
            }
         }
      }
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Line line = new Line();
      Point[] sPoints = Arrays.copyOf(points, points.length);
      
      for (int i = 0; i < points.length; i++) {
         Arrays.sort(sPoints, points[i].slopeOrder);
         
         for (int j = 0; j < points.length; j++) {
            line.add(sPoints[0]);
            if (!line.add(sPoints[j])) {
               if (line.length() >= 4) {
                  lines.add(line);
               }
               line = new Line();
               line.add(sPoints[j]);
            }
            
            
         }
      }
      
      return lines;
   }

}
