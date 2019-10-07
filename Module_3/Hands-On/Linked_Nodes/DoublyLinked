/**
 * DoublyLinked.java
 * Sample code for working doubly-linked nodes. The Node class is defined
 * as an inner class, so direct access to the fields of Node is available.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2015-02-25
 *
 */
public class DoublyLinked {

   /**
    * Call a method to perform example operations on nodes.
    */
   public static void main(String[] args) {

      DoublyLinked client = new DoublyLinked();
      client.basicExamples();
      client.add();
      client.delete();
   }

   /**
    * Defines a doubly-linked node.
    * Type Object is used instead of a generic type to make
    * this example cleaner and easier to read. If this class
    * were to be used in the context of implementing a collection,
    * generic types should be used.
    */
   private class Node {
      private Object element;
      private Node next;
      private Node prev;

      public Node(Object e) {
         element = e;
      }
   }


   /**
    * Creates basic examples.
    */
   public void basicExamples() {

      // Declaration;
      Node n;
      Node m;

      // Constructor, garbage
      n = new Node(1);
      m = new Node(2);
      m.prev = n;
      n.next = m;
      n = new Node(3);
      System.out.println("n -> " + toString(n));
      System.out.println("m -> " + toString(m));
      n = null;
      System.out.println("n -> " + toString(n));

      // basic linking
      n = new Node("A");
      m = new Node("B");
      n.next = m;
      m.prev = n;
      m.next = new Node("C");
      m = m.next;
      m.prev = n.next;
      Node x = m;
      m.next = new Node("D");
      m = m.next;
      m.prev = x;
      x.next = m;
   }

   /**
    * Returns a string representation of the pointer chain accessible
    * from n.
    */
   public String toString(Node n) {
      if (n == null) {
         return "NULL";
      }

      StringBuffer s = new StringBuffer();
      Node p = n;
      while (p != null) {
         s.append(p.element);
         s.append(" -> ");
         p = p.next;
      }
      s.delete(s.length() - 3, s.length());
      return s.toString();
   }

   /**
    * Returns the number of nodes accessible from n.
    */
   public int length(Node n) {
      Node p = n;
      int len = 0;
      while (p != null) {
         len++;
         p = p.next;
      }
      return len;
   }

   /**
    * Searches for target in the pointer chain accessible from n.
    */
   public boolean contains(Node n, Object target) {
      Node p = n;
      while (p != null) {
         if (p.element.equals(target)) {
            return true;
         }
         p = p.next;
      }
      return false;
   }

   /**
    * Sets up an example to add a new node into an
    * existing pointer chain.
    */
   public void add() {
      Node n = new Node("A");
      n.next = new Node("B");
      n.next.prev = n;
      n.next.next = new Node("C");
      n.next.next.prev = n.next;
      n.next.next.next = new Node("D");
      n.next.next.next.prev = n.next.next;

      Node p = null; // to find the right spot
      Node temp = new Node("X"); // to create new node

      System.out.println(toString(n));
   }

   /**
    * Sets up an example to delate a new node from an
    * existing pointer chain.
    */
   public void delete() {
      Node n = new Node("A");
      n.next = new Node("B");
      n.next.prev = n;
      n.next.next = new Node("C");
      n.next.next.prev = n.next;
      n.next.next.next = new Node("D");
      n.next.next.next.prev = n.next.next;

      Node p = null; // to find the right spot

      System.out.println(toString(n));
   }

}
