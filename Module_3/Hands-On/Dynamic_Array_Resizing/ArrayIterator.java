import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayIterator.java
 * Provides iteration behavior over an array of elements.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-02-24
 *
 */
public class ArrayIterator<T> implements Iterator<T> {

   // the array of elements to iterate over
   private T[] elements;
   // the number of elements in the array, beginning at index zero
   private int count;
   // the index of the next element in the iteration sequence
   private int current;

   /**
    * Construct a properly initialized iterator.
    *
    * @param  elem the array to be iterated over
    * @param  size the number of elements in the array
    */
   public ArrayIterator(T[] elem, int size) {
      elements = elem;
      count = size;
      current = 0;
   }

   /**
    * Returns true if there is at least one more element remaining
    * in the iteration sequence.
    *
    * @return true if there is a next element to iterate over
    */
   public boolean hasNext() {
      return current < count;
   }

   /**
    * Returns the next element in the iteration sequence.
    * @return the next element in the iteration sequence
    */
   public T next() {
      if (!hasNext()) {
         throw new NoSuchElementException();
      }
      return elements[current++];
   }

   /**
    * Unsupported operation.
    */
   public void remove() {
      throw new UnsupportedOperationException();
   }
}
