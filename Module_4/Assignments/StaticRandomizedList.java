import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

/* StaticRandomizedList.java implements the RandomizedList interface
   using array based data structure. Designed to have O(1) time complexity
   besides iterator with O(N). 
   
   @author Matthew Bentz (mlb0119@auburn.edu)
   @version 10/11/19
*/

public class StaticRandomizedList<T> implements RandomizedList<T> {

   // FIELDS
   private static final int DEFAULT_CAPACITY = 5;
   private int size;
   private T[] elements;
   
   //Default constructor
   public StaticRandomizedList() {
      this(DEFAULT_CAPACITY);
   }
   
   //Constructor with parameters
   @SuppressWarnings("unchecked") //it'll be okay elements the generics won't hurt you
   public StaticRandomizedList(int capacity) {
      elements = (T[]) new Object[capacity];
      size = 0;
   }
   
   //returns randomizedlist size
   public int size() {
      return size;
   }
   
   //returns randomizedlist empty boolean
   public boolean isEmpty() {
      return size == 0;
   }
   
   //returns randomizedlist full boolean
   private boolean isFull() {
      return size == elements.length;
   }
   
   //resizes the array
   @SuppressWarnings("unchecked")
   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      for (int i = 0; i < size(); i++) {
         a[i] = elements[i];
      }
      elements = a;
   }
   
   //adds element
   public void add(T element) {
      if (element == null) {
         throw new IllegalArgumentException("null");
      }
      if (isFull()) {
         resize(elements.length * 2);
      }
      elements[size] = element;
      size++;
   }
   
   //removes random element
   public T remove() {
      if (isEmpty()) {
         return null;
      }
      Random random = new Random();
      int rNumber = random.nextInt(size);
      T removedVal = elements[rNumber];
      elements[rNumber] = elements[--size];
      elements[size] = null;
      if (size > 0 && size < elements.length / 4) {
         resize(elements.length / 2);
      }
      return removedVal;
   }
   
   //samples random element
   public T sample() {
      if (isEmpty()) {
         return null;
      }
      Random random = new Random();
      int rNumber = random.nextInt(size);
      return elements[rNumber];
   }
   
   
   
      //overriding class for iterator
   @SuppressWarnings("unchecked")
   public Iterator<T> iterator() {
      return new ArrayIterator(elements, size);
   }

   //nested class (access to private fields)
   public class ArrayIterator<T> implements Iterator<T> {
      //array of elements to be iterated over
      private T[] items;
      
      //number of elements in the array
      private int count;
      
      public ArrayIterator(T[] elementsIn, int sizeIn) {
         // for (int i = 0; i < sizeIn; i++) {
            // items[i] = elementsIn[i];
         // }
         items = elementsIn;
         count = sizeIn;
      }
      
      public boolean hasNext() {
         //return (current < count);
         return (count > 0);
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         Random random = new Random();
         int nextVal = random.nextInt(count);
         T next = items[nextVal];
         items[nextVal] = items[count - 1];
         items[count - 1] = next;
         count--;
         return next;
         
      }
   }
}


