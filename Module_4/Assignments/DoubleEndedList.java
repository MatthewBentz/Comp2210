
/**
 * DoubleEndedList.java. Describes the abstract behavior of a double-ended
 * list. Elements can be inserted and deleted from either end of the list, but
 * not from any other location.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2017-07-11
 */
public interface DoubleEndedList<T> extends List<T> {
   
   /**
    * Adds element to the front of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   void addFirst(T element);
   
   /**
    * Adds element to the end of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   void addLast(T element);
      
   /**
    * Delete and return the element at the front of the list.
    * If the list is empty, this method returns null.
    */
   T removeFirst();
   
   /**
    * Delete and return the element at the end of the list.
    * If the list is empty, this method returns null.
    */
   T removeLast();
   
}