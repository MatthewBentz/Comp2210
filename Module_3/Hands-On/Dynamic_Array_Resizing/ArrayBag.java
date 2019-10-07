import java.util.Iterator;

/**
 * ArrayBag.java
 * Implements bag (multiset) behavior. Duplicates are allowed and no specific
 * order is guaranteed. Method signatures are compatable with the
 * corresponding methods of java.util.Collection, but the semantics of some
 * methods may differ.
 *
 * This implementation is based on a resizeable array data structure, with an
 * initial size of 1. The array is doubled in size each time it reaches
 * capacity and it is halved in size each time it drops below 25% capacity.
 * This resizing strategy is based on a similar scheme described by Sedgewick
 * and Wayne in their algorithms course at Princeton, and guarantees memory
 * usage that is linearly proportional to the size of the bag.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-23
 */
public class ArrayBag<T> implements Bag<T> {

   // default capacity of this bag
   private static final int DEFAULT_CAPACITY = 1;

   // stores the elements in this bag
   private T[] elements;

   // the number of elements in this bag
   private int size;

   //////////////////
   // Constructors //
   //////////////////

   /**
    * Construct an ArrayBag with the default capacity.
    */
   public ArrayBag() {
      this(DEFAULT_CAPACITY);
   }

   /**
    * Construct an ArrayBag of the specified capacity.
    */
   @SuppressWarnings("unchecked")
   public ArrayBag(int capacity) {
      size = 0;
      elements = (T[]) new Object[capacity];
   }

   ///////////////////////////
   // Bag interface methods //
   ///////////////////////////

   /**
    * Ensures that this bag contains the specified element. Returns true if the
    * element was added and false otherwise.
    *
    * @param  element the element to be added
    * @return         true if the element was successfully added
    */
   public boolean add(T element) {
      if (isFull()) {
         resize(size * 2);
      }
      elements[size] = element;
      size++;
      return true;
   }

   /**
    * Removes a single instance of the specified element from this bag. Returns
    * true if the element was removed and false otherwise.
    *
    * @param  element the element to be removed
    * @return         true if the element was removed
    */
   public boolean remove(T element) {
      int loc = locate(element);
      if (loc < 0) {
         return false;
      }
      size--;
      elements[loc] = elements[size];
      elements[size] = null;
   
      if (isSparse()) {
         resize(elements.length / 2);
      }
   
      return true;
   }

   /**
    * Returns true if this bag contains the specified element and false
    * otherwise.
    *
    * @param  element the element to be searched for
    * @return         true if this bad contains the element
    */
   public boolean contains(T element) {
      return locate(element) >= 0;
   }

   /**
    * Returns true if this bag contains no elements and false otherwise.
    *
    * @return true if this bag has no elements
    */
   public boolean isEmpty() {
      return size == 0;
   }

   /**
    * Returns the number of elements in this bag.
    *
    * @return the number of elements in this bag
    */
   public int size() {
      return size;
   }

   /**
    * Returns an iterator over the elements in this bag.
    *
    * @return an iterator over the elements in this bag.
    */
   public Iterator<T> iterator() {
      return new ArrayIterator<T>(elements, size);
   }


   //////////////////////////
   // Other public methods //
   //////////////////////////

   /**
    * Returns a string representation of this ArrayBag.
    *
    * @return a string representing this Arraybag
    */
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < size; i++) {
         sb.append(elements[i] + ", ");
      }
      sb.delete(sb.length() - 2, sb.length());
      sb.append("]");
      return sb.toString();
   }

   /////////////////////////////
   // Private utility methods //
   /////////////////////////////

   /**
    * Returns true if number of elements in this bag is the same
    * as the capacity of the array.
    *
    * @return true if this bag is full
    */
   private boolean isFull() {
      return size == elements.length;
   }


   /**
    * Returns true if the number of elements in this bag is strictly less than
    * 25% of the capacity of the elements array.
    *
    * @return true if this bag is too sparse
    */
   private boolean isSparse() {
      return (size > 0) && (size < elements.length / 4);
   }


   /**
    * Return the index of the specified element in the
    * array or -1 if not present.
    *
    * @param  element the element to be located
    * @return         the index of element in the array
    */
   private int locate(T element) {
      for (int i = 0; i < size; i++) {
         if (elements[i].equals(element)) {
            return i;
         }
      }
      return -1;
   }

   /**
    * Reassign elements to a new array of capacity newSize with the
    * current elements of this bag.
    *
    * @param newSize the new capacity of the array
    */
   private void resize(int newSize) {
      assert newSize > 0;
      @SuppressWarnings("unchecked")
         T[] newArray = (T[]) new Object[newSize];
      System.arraycopy(elements, 0, newArray, 0, size);
      elements = newArray;
   }
}
