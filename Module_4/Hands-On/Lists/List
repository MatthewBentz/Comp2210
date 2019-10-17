import java.util.Iterator;

/**
 * Abstract behavior common to many lists.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-19
 */
public interface List<T> extends Iterable<T> {

	/** Returns the first element in this list. */
   T first();

	/** Returns the last element in this list. */
   T last();

	/** Removes the first element in this list. */
   T removeFirst();

	/** Removes the last element in this list. */
   T removeLast();

	/** Removes the specified element from this list. */
   T remove(T element);

	/** Returns true if this list has no elements, false otherwise. */
   boolean isEmpty();

	/** Returns the number of elements in this list. */
   int size();

	/** Returns an iterator over the elements in this list. */
   Iterator<T> iterator();

	/** Returns a string representation of this list. */
   String toString();
}
