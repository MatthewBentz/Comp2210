import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

/* DynamicDoubleEndedList.java implements the DoubleEndedList interface
   using node based data structure. Designed to have O(1) time complexity
   in all implementing methods.
   
   @author Matthew Bentz (mlb0119@auburn.edu)
   @version 10/16/19
*/

public class DynamicDoubleEndedList<T> implements DoubleEndedList<T> {
   //FIELDS
   private Node front;
   private int size;
   private Node end;
   
   public DynamicDoubleEndedList() {
      front = null;
      size = 0;
      end = null;
   }
      
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public void addFirst(T element) {
      if (element == null) {
         throw new IllegalArgumentException("null");
      }
      Node n = new Node(element);
      if (size() == 0) {
         front = n;
         end = n;
      } else {
         n.next = front;
         front.prev = n;
         front = n;
      }
      size++;
   }
   
   public void addLast(T element) {
      if (element == null) {
         throw new IllegalArgumentException("null");
      }
      Node n = new Node(element);
      if (size() == 0) {
         front = n;
         end = n;
      } else {
         n.prev = end;
         end.next = n;
         end = n;
      }
      size++;
   }
   
   public T removeFirst() {
      if (isEmpty()) {
         return null;
      }
      T removedVal = front.element;
      if (size() == 1) {
         front = null;
         end = null;
      } else {
         front = front.next;
         front.prev = null;
      }
      size--;
      return removedVal;
   }
   
   public T removeLast() {
      if (isEmpty()) {
         return null;
      }
      T removedVal = end.element;
      if (size() == 1) {
         front = null;
         end = null;
      } else {
         end = end.prev;
         end.next = null;
      }
      size--;
      return removedVal;
   }
   
   //NODE CLASS
   private class Node {
      private T element;
      private Node next;
      private Node prev;
      
      //Default Constructor
      public Node(T e) {
         element = e;
      }
      
      public Node(T e, Node n) {
         element = e;
         next = n;
      }
      
      public Node(T e, Node n, Node p) {
         element = e;
         next = n;
         prev = p;
      }
      
      public int length(Node n) {
         Node p = n;
         int len = 0;
         while (p != null) {
            len++;
            p = p.next;
         }
         return len;
      }
   }

   //overriding class for iterator
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }
   
   //nested class (access to private fields)
   private class LinkedIterator implements Iterator<T> {
      private Node current = front;
      
      public boolean hasNext() {
         return current != null;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T result = current.element;
         current = current.next;
         return result;
      }
   }
}
