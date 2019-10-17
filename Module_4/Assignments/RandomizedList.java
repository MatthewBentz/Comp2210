
/**
 * RandomizedList.java. Describes the abstract behavior of a
 * randomized list collection; that is, a list with order defined as "random
 * order." The order described by a radomized list is "random" in the sense
 * that the element accessed by either the sample or remove method is selected
 * uniformly at random from the current elements in the list. In addition, an
 * iterator on a randomized list will sequentially access each element in some
 * uniformly random sequence. Simultaneous iterators on the same randomized
 * list are independent of each other. That is, they will with high probability
 * have different iteration sequences.
 * 
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2017-07-11
 */
public interface RandomizedList<T> extends List<T> {
 
   /**
    * Adds the specified element to this list. If the element is null, this
    * method throws an IllegalArgumentException.
    */
   void add(T element);
  
   /**
    * Selects and removes an element selected uniformly at random from the
    * elements currently in the list. If the list is empty this method returns
    * null.
    */
   T remove();
   
   /**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    */
   T sample();
   
}