/**
 * Provides a sample client for the AvlTree class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-05-02
 */
public class AvlTreeClient {

	/** Drives execution. */
   public static void main(String[] args) {
      Integer[] values = {1,8,4,2,3,5,6,7};
      AvlTree<Integer> avl = new AvlTree<>();
      for (Integer value : values) {
         avl.add(value);
      }
      System.out.println(avl);
      System.out.println(avl.size());
   }
}
