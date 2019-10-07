/**
 * SinglyLinked.java
 * Sample code for working singly-linked nodes. The Node class is defined
 * as an inner class, so direct access to the fields of Node is available.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2015-02-25
 *
 */
public class SinglyLinked {

  /**
   * Call a method to perform example operations on nodes.
   */
   public static void main(String[] args) {

      SinglyLinked client = new SinglyLinked();
      client.basicExamples();
      client.add();
      client.delete();
   }

   /**
    * Defines a singly-linked node.
    * Type Object is used instead of a generic type to make
    * this example cleaner and easier to read. If this class
    * were to be used in the context of implementing a collection,
    * generic types should be used.
    */
   private class Node {
      private Object element;
      private Node next;

      public Node(Object e) {
         element = e;
      }

      public Node(Object e, Node n) {
         element = e;
         next = n;
      }
   }


   /**
    * Creates the examples from lecture notes.
    */
   public void basicExamples() {

      // Declaration;
      Node n;

      // Constructors, garbage
      n = new Node(1);
      n = new Node(2, n);
      n = new Node(3);
      n = null;

      // basic linking
      n = new Node(1);
      n = new Node(2, n);
      n.next = new Node(3, n.next);

      n = new Node(1, new Node(2));
      n.next.next = new Node(3, null);
      n = new Node(4, n.next);

      // quick question from the notes
      n = new Node(1);
      n.next = new Node(2, new Node(3));
      n = new Node(4, n.next.next);

      // a question from a previous exam
      n = new Node(1);
      n.next = new Node(2);
      Node m = new Node(3, n);
      m.next = new Node(4, n);
      Node p = m.next;
      n = n.next;
      p.next = n;
      n = null;
      p = null;

      // calling length and contains
      n = new Node(1, new Node(2, new Node(3, new Node(4))));
      int len = length(n);
      String s = toString(n);
      System.out.println("n -> " + s);
      System.out.println("length = " + len);
      System.out.println(contains(n, 3));
      System.out.println(contains(n, 0));
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
      n.next.next = new Node("C");
      n.next.next.next = new Node("D");

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
      n.next.next = new Node("C");
      n.next.next.next = new Node("D");

      Node p = null; // to find the right spot

      System.out.println(toString(n));
   }

}
