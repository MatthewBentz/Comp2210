import java.util.Iterator;
/**
 * BstClient.java. Provides sample client code for the BinarySearchTree class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-03-29
 */

public class BstClient {

   /** Drives execution. */
   public static void main(String[] args) {
      Integer[] values = {10,85,15,70,20,60,30,50,65,80,90,40,5,55};
      BinarySearchTree<Integer> bst = new BinarySearchTree<>();
      for (Integer value : values) {
         bst.put(value);
      }
      System.out.println(bst);
      System.out.println(bst.size());
   
      bst = new BinarySearchTree<>();
      for (int i = 0; i < 10; i++) {
         bst.put(99);
      }
      System.out.println(bst);
      System.out.println(bst.size());
   }
}
