/**
 * Abstract behavior of a list that keeps its elements in absolute positional order
 * denoted by a zero-based index.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-19
 */
public interface IndexedList<T> extends List<T> {

	/** Adds the given element at the specified index in this list. */
   boolean add(T element, int index);

	/** Adds the given element at the end of this list. */
   boolean add(T element);

	/** Replaces the current element at the specified index with the given elemeent. */
   boolean set(T element, int index);

	/** Returns the element at the given index in this list. */
   T get(int index);

	/** Returns the index of the specified element in this list. */
   int indexOf(T element);

	/** Removes the element at the specified index in this list. */
   T remove(int index);
}
