import java.util.Iterator;

/**
 * List.java. Describes the abstract behavior of a list collection.
 * This interface together with one or more subinterfaces describe the behavior
 * of a specific type of list.
 *
 * All list types prohibit nulls but allow duplicates. That is, if e1 == null
 * then e1 is not allowed as a list element. If e1.equals(e2) both e1 and e2
 * are allowed as list elements.
 * 
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2017-07-11
 */
public interface List<T> extends Iterable<T> {

   /**
    * Returns the number of elements in this list.
    */
   int size();
 
   /**
    * Returns true if this list contains no elements, false otherwise.
    */
   boolean isEmpty();
   
   /**
    * Creates and returns an iterator over the elements of this list.
    */
   Iterator<T> iterator();

}
