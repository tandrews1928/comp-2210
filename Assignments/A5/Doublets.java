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

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. The lexicon
 * is stored as a HashSet of Strings.
 *
 * @author Your Name (you@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-04-06
 */
public class Doublets implements WordLadderGame {

   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   private HashSet<String> lexicon;


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
            lexicon.add(str.toLowerCase());
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }


   //////////////////////////////////////////////////////////////
   // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
   //////////////////////////////////////////////////////////////


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
   public int getHammingDistance(String str1, String str2) {
      int hd = 0;
      int length1 = str1.length();
      int length2 = str2.length();
      if (length1 != length2) {
         return -1;
      }
      for (int i = 0; i < length1; i++) {
         if (str1.charAt(i) != str2.charAt(i)) {
            hd++;
         }
      }
      return hd;
   }


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
   public List<String> getMinLadder(String start, String end) {
      List<String> validladder = new ArrayList<String>();
      List<String> empty = new ArrayList<String>();
      Deque<Node> deque = new ArrayDeque<>();
      HashSet<String> first = new HashSet<>();
      
      if (start.equals(end)) {
         validladder.add(start);
         return validladder;
      }
     
    
     
    
      first.add(start);
      deque.addLast(new Node(start, null));
      while (!deque.isEmpty()) {
       
         Node firstgone = deque.removeFirst();
         
         String position = firstgone.location;
          
         for (String neighbors : getNeighbors(position)) {
            if (!first.contains(neighbors)) {
               first.add(neighbors);
               deque.addLast(new Node(neighbors, firstgone));
            }
            if (neighbors.equals(end)) {   
               Node lastgone = deque.removeLast();
               while (lastgone != null) {
                  validladder.add(0, lastgone.location);
                  lastgone = lastgone.previous;
               }
               return validladder;
            }
            
         }
      }      
      return empty;
   
   }


   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return      the neighbors of the given word
    */
   public List<String> getNeighbors(String word) {
   
      List<String> neighbor = new ArrayList<String>();
      HashSet<String> set = new HashSet<String>();
      List<String> empty = new ArrayList<String>();
       
      if (word == null)
         return empty;
      
      for (String lword : lexicon) {
         if (getHammingDistance(word, lword) == 1)
            neighbor.add(lword);
      }
      
      return neighbor;
   }


   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   public int getWordCount() {
      int count = lexicon.size();
      return count;
   }


   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return     true if str is a word, false otherwise
    */
   public boolean isWord(String str) {
      if (lexicon.contains(str))
      {
         return true;
      }
      return false;
   }


   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   public boolean isWordLadder(List<String> sequence) {
      int count = 0;
      if ((sequence.isEmpty()) || (sequence == null)) {
         return false;
      }
      
      for (int i = 0; i < sequence.size() - 1; i++) {
         if (isWord(sequence.get(i + 1)) != true || (getHammingDistance(sequence.get(i), sequence.get(i + 1)) != 1) || (isWord(sequence.get(i)) != true)) {
            count++;  
         }
        
      }
      boolean is = (count == 0);
      return is;
   }


   private class Node {
      String location;
      Node previous;
   
      public Node(String a, Node prev) {
         location = a;
         previous = prev;
      }
   }
}

