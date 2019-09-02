import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * GenericsC.java
 * Used to illustrate basic principles of generic types
 * and type safety in Java.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-23
 *
 */

 ////////////////////////////////////////////////
 //
 // Add appropriate type parameters and arguments
 // to eliminate all unchecked warnings. That is,
 // make this code type safe.
 //
 ///////////////////////////////////////////////

public class GenericsC<T> {

   private List<T> al;

   /** Builds a new instance of this class. */
   public GenericsC() {
      al = new ArrayList<T>();
   }

   /** Adds all the values in c to this object. */
   public void addAll(Collection<T> c) {
      for (T o : c) {
         al.add(o);
      }
   }

   /** Returns a string representation of this object. */
   public String toString() {
      StringBuilder s = new StringBuilder();
      Iterator itr = al.iterator();
      while (itr.hasNext()) {
         s.append(itr.next());
         s.append(" ");
      }
      return s.toString();
   }

   /** Drives execution. */
   public static void main(String[] args) {
      Collection<Integer> c = new ArrayList<Integer>();
      for (int i = 1; i < 12; i += 2) {
         c.add(i);
      }
   
      GenericsC<Integer> lab = new GenericsC<Integer>();
      lab.addAll(c);
      System.out.println(lab.toString());
   }


}
