import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Matthew Bentz (mlb0119@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-29
 */
public class Doublets implements WordLadderGame {

   HashSet<String> lexicon;

   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         lexicon = new HashSet<String>();
         Scanner s =
            new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            lexicon.add(str.toUpperCase());
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }

   public boolean isWord(String str) {
      str = str.toUpperCase();
      return lexicon.contains(str);
   }

   public int getWordCount() {
      return lexicon.size();
   }
   
   public int getHammingDistance(String str1, String str2) {
      str1 = str1.toUpperCase();
      str2 = str2.toUpperCase();
      
      if (str1.length() != str2.length()) {
         return -1;
      }
      
      int distance = 0;
      for (int i = 0; i < str1.length(); i++) {
         if (str1.charAt(i) != str2.charAt(i)) {
            distance++;
         }
      }
      
      return distance;
      
   }

   public List<String> getNeighbors(String word) {
      List<String> neighbors = new ArrayList<String>();
      
      for (int i = 0; i < word.length(); i++) {
      
         String tempWord = word;
         char[] tempWordChars = tempWord.toCharArray();
         
         for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
         
            tempWordChars[i] = alphabet;
            tempWord = String.valueOf(tempWordChars);
            
            if (isWord(tempWord) && !neighbors.contains(tempWord.toUpperCase())
                                 && !tempWord.equals(word)) {
               neighbors.add(tempWord.toUpperCase());
            }
         }
      }
      
      return neighbors;
   }
   
   public boolean isWordLadder(List<String> sequence) {
      if (sequence.isEmpty()) {
         return false;
      }
      
      for (String word : sequence) {
         if (!isWord(word)) {
            return false;
         }
      }
      
      for (int i = 0; i < sequence.size() - 1; i++) {
         if (getHammingDistance(sequence.get(i), sequence.get(i + 1)) != 1) {
            return false;
         }
      }
      
      return true;
   }
   
   public List<String> getMinLadder(String start, String end) {
      List<String> minLadder = new ArrayList<String>();
      ArrayList<String> memory = new ArrayList<String>();
   
      start = start.toUpperCase();
      end = end.toUpperCase();
      
      if (start.equals(end)) {
         minLadder.add(start.toLowerCase());
         return minLadder;
      }
      
      if (getHammingDistance(start, end) == -1) {
         return minLadder;
      }
      
      if (isWord(start) && isWord(end)) {
         memory = bfs(start, end);
      }
      
      for (int i = memory.size() - 1; i >= 0; i--) {
         minLadder.add(memory.get(i));
      }
      
      return minLadder;
   }
   
   private ArrayList<String> bfs(String start, String end) {
      Deque<Node> queue = new ArrayDeque<>();
      HashSet<String> visited = new HashSet<String>();
      
      visited.add(start);
      queue.addLast(new Node(start, null));
      Node endNode = new Node(end, null);
      
      while (!queue.isEmpty()) {
      
         Node n = queue.removeFirst();
         String word = n.word;
         List<String> neighbors = getNeighbors(word);
         
         for (String neighbor : neighbors) {
         
            if (!visited.contains(neighbor)) {
               visited.add(neighbor);
               queue.addLast(new Node(neighbor, n));
               
               if (neighbor.equals(end)) {
                  endNode.predecessor = n;
               }
            }
         }
      }
      
      ArrayList<String> memory = new ArrayList<String>();
      
      if (endNode.predecessor == null) {
         return memory;
      }
      
      Node m = endNode;
      while (m != null) {
         memory.add(m.word);
         m = m.predecessor;
      }
      
      return memory;
   }
   
   
   private class Node {
      String word;
      Node predecessor;
   
      public Node(String s, Node pred) {
         word = s;
         predecessor = pred;
      }
   }
}