import java.util.List;

/**
 * WordLadderGame.java Defines an interface for games that construct word
 * ladders. See https://en.wikipedia.org/wiki/Word_ladder for a definition and
 * history.
 *
 * Word ladders are constructed in the context of some predefined list of valid
 * words. We will refer to this word list as the lexicon. An implementing class
 * of this interface must provide a way to explicitly set the lexicon. This will
 * typically be done in the constructor.
 *
 * For the purposes of this interface and all implementing classes, a string is
 * a word if and only if it appears in the current lexicon. In the documentation
 * of each interface method, the use of 'string' means that the referenced
 * string does not have to be a word, while the use of 'word' implies that the
 * referenced string must be a word.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-29
 */
public interface WordLadderGame {

   /**
    * Returns the Hamming distance between two strings, str1 and str2. The
    * Hamming distance between two strings of equal length is defined as the
    * number of positions at which the corresponding symbols are different. The
    * Hamming distance is undefined if the strings have different length, and
    * this method returns -1 in that case. See the following link for
    * reference: https://en.wikipedia.org/wiki/Hamming_distance
    *
    * @param  str1 the first string
    * @param  str2 the second string
    * @return      the Hamming distance between str1 and str2 if they are the
    *                  same length, -1 otherwise
    */
   int getHammingDistance(String str1, String str2);


  /**
   * Returns a minimum-length word ladder from start to end. If multiple
   * minimum-length word ladders exist, no guarantee is made regarding which
   * one is returned. If no word ladder exists, this method returns an empty
   * list.
   *
   * Breadth-first search must be used in all implementing classes.
   *
   * @param  start  the starting word
   * @param  end    the ending word
   * @return        a minimum length word ladder from start to end
   */
   List<String> getMinLadder(String start, String end);


   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return      the neighbors of the given word
    */
   List<String> getNeighbors(String word);


   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   int getWordCount();


   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return     true if str is a word, false otherwise
    */
   boolean isWord(String str);


   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   boolean isWordLadder(List<String> sequence);
}
