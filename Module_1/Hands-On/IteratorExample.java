import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

/**
 * IteratorExample.java
 * Illustrates the common pattern when using Iterators.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2016-08-24
 *
 */
public class IteratorExample {

   /**
    * Accesses each element of an Iterable collection using an Iterator and
    * returns a String representation of the underlying collection.
    */
   public static <T> String toString(Iterable<T> iterable) {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      
      
      for (T element : iterable) {
         sb.append(element);
         sb.append(", ");
      }
      
      
      // Iterator<T> itr = iterable.iterator();
      // while (itr.hasNext()) {
         // sb.append(itr.next());
         // sb.append(", ");
      // }
      sb.delete(sb.length() - 2, sb.length());
      sb.append("]");
      return sb.toString();
   }

  /** Drives execution. */
   public static void main(String[] args) {
      Collection<Integer> alist = new ArrayList<Integer>();
      alist.add(2);
      alist.add(4);
      alist.add(6);
      alist.add(8);
      alist.add(10);
      System.out.println(toString(alist));
   
      Collection<String> vec = new Vector<String>();
      vec.add("I");
      vec.add("believe");
      vec.add("in");
      vec.add("Auburn");
      vec.add("and");
      vec.add("love");
      vec.add("it");
      System.out.println(toString(vec));
   
      Collection<String> tset = new TreeSet<String>();
      tset.add("I");
      tset.add("believe");
      tset.add("in");
      tset.add("Auburn");
      tset.add("and");
      tset.add("love");
      tset.add("it");
      System.out.println(toString(tset));
   
      Collection<Double> llist = new LinkedList<Double>();
      llist.add(3.14159);
      llist.add(2.71828);
      llist.add(1.41421);
      llist.add(1.61803);
      llist.add(6.02214);
      System.out.println(toString(llist));
   }

}
