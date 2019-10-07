import java.util.Iterator;

/**
 * Bag.java
 * Specifies bag (multiset) behavior. Duplicates are allowed and no specific
 * order is guaranteed. Method signatures are compatable with the corresponding
 * methods of java.util.Collection, but the semantics of some methods may
 * differ.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-23
 */
public interface Bag<T> extends Iterable<T> {

   /**
    * Ensures that this bag contains the specified element. Returns true if the
    * element was added and false otherwise.
    *
    * @param  element the element to be added
    * @return         true if the element was successfully added
    */
   boolean add(T element);

   /**
    * Removes a single instance of the specified element from this bag. Returns
    * true if the element was removed and false otherwise.
    *
    * @param  element the element to be removed
    * @return         true if the element was removed
    */
   boolean remove(T element);

   /**
    * Returns true if this bag contains the specified element and false
    * otherwise.
    *
    * @param  element the element to be searched for
    * @return         true if this bad contains the element
    */
   boolean contains(T element);

   /**
    * Returns true if this bag contains no elements and false otherwise.
    *
    * @return true if this bag has no elements
    */
   boolean isEmpty();

   /**
    * Returns the number of elements in this bag.
    *
    * @return the number of elements in this bag
    */
   int size();

   /**
    * Returns an iterator over the elements in this bag.
    *
    * @return an iterator over the elements in this bag.
    */
   Iterator<T> iterator();
}
