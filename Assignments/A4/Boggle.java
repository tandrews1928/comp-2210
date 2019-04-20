import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * word search game using depth-first search with backtracking.
 *
 * @author Tyler Andrews
 * 
 */
public class Boggle implements WordSearchGame {
   private String[][] grid;
   private String[] lexicon;
   private int width;
   private int height;
   private int minlength;
   private boolean[][] visited;
   private boolean lcalled = false;
   private List<Integer> list2 = new ArrayList<Integer>();
   private List<Integer> list2copy = new ArrayList<Integer>();

   private SortedSet<String> valid = new TreeSet<String>();
   
    /**
    * Loads the lexicon into a data structure for later use. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
     
      
      try {
       
      
         lcalled = true;
         Scanner scanFile = new Scanner(new File(fileName));   
         String currentline = "";
         List<String> size = new ArrayList<String>();
         
      
         while (scanFile.hasNext()) {
            currentline = scanFile.next().toUpperCase();
         
            size.add(currentline);
            
            
         }
         lexicon = new String[size.size()];
         int a = size.size();
         for (int i = 0; i < a; i++) {
            lexicon[i] = size.get(i);
         }
         
      }
      catch (FileNotFoundException e) {
         throw new IllegalArgumentException();
      }
      catch (NullPointerException e) {
         throw new IllegalArgumentException();
      }
   
      
      
      
      
   }
   
   
  


   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    */
    
   public void setBoard(String[] letterArray) {
      
      try {
         if (letterArray.length % Math.sqrt(letterArray.length) != 0) {  // checks to see if the list of numbers is a square.
            throw new IllegalArgumentException();
         } 
         int n = 0;
         for (String a : letterArray) { 
            n++;   // gets the length of the Array
         }
      
         height = (int) Math.sqrt(n);  // width and height are equal to the sqare root of the length.
         width = (int) Math.sqrt(n);
         
         grid = new String[width][height];
      
      
         int a = 0;
         while (a < height) {     
            for (int i = 0; i < width; i++) {
               int position = (a * height) + i;
               grid[a][i] = letterArray[position];   //sets each position in the grid
            
            }
            a++;
         } 
      }
      catch (NullPointerException e) {
         throw new IllegalArgumentException();
      }
      
   }
   
   /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard() {
   
      return null;
   }
   
   /**
    * Retrieves all valid words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
    
    
    
   public SortedSet<String> getAllValidWords(int minimumWordLength) { //depth first search with backtracking
      valid.clear();
      try {
         if (minimumWordLength < 1) {
            throw new IllegalArgumentException();
         }
         if (lcalled = false) {
            throw new IllegalStateException();
         }
         int length = grid.length;
         for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
               visited = new boolean[width][height];
               String testword = "";
               gameTile(i, j, testword, minimumWordLength);
            
            }
         }
         
      
      
      
           
         return valid;
      }
      catch (NullPointerException h ) {
         throw new IllegalStateException();
      }
   }
   /** looks at each individual tile. */
   
   public void gameTile(int i, int j, String testword, int min) {
   
      if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) {
         return;
      }
      if (visited[i][j]) {
         return;
      }
      
      visited[i][j] = true;
      testword += grid[i][j];
   
      if (isValidWord(testword) && testword.length() >= min) {
         valid.add(testword);
      }
      if (isValidPrefix(testword)) {
         recursion(i, j, testword, min);
      }
      visited[i][j] = false;
   
   }
   
   private void recursion(int i, int j, String testword, int min) { // looks at all surrounding 8 tiles
   
      gameTile(i - 1, j - 1, testword, min);
      gameTile(i - 1, j, testword, min);
      gameTile(i - 1, j + 1, testword, min);
      gameTile(i, j + 1, testword, min);
      gameTile(i + 1, j + 1, testword, min);
      gameTile(i + 1, j, testword, min);
      gameTile(i + 1, j - 1, testword, min);
      gameTile(i, j - 1, testword, min);
   }
   
        
   
     /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
   
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (lcalled = false) {
         throw new IllegalArgumentException();
      }
      return 0;
   }
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
    
   public boolean isValidWord(String wordToCheck) {
      if (wordToCheck.equals(null)) {  
         throw new IllegalArgumentException();
      }
      if (lcalled = false) {
         throw new IllegalArgumentException();
      }
      
      if (wordsearch(lexicon, wordToCheck, 0, lexicon.length - 1)) {
         return true;
      }
      else {
         return false;
      }
      
   
   }
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
    
   public boolean isValidPrefix(String prefixToCheck) {
      if (prefixToCheck.equals(null)) {
         throw new IllegalArgumentException();
      }
      if (lcalled = false) {
         throw new IllegalArgumentException();
      }
      
      
      
      return prefixsearch(lexicon, prefixToCheck, 0, lexicon.length - 1);
   
   }
   /**
    * Mark this valid position as having been visited.
    */
    
   /**
    * Process this valid position.
    */
 
      
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
 
   public List<Integer> isOnBoard(String wordToCheck) {
      try {
         if (wordToCheck.equals(null)) {
            throw new IllegalArgumentException();
         }
         if (lcalled = false) {
            throw new IllegalStateException();
         }
         List<String> list = new ArrayList<String>();  
         list.clear();
         int length = wordToCheck.length(); //finds the length of the word that needs to be checked
      
      
         for (int s = 0; s < length; s++) {
            list.add(wordToCheck.substring(s, s + 1)); //adds the substring of the word
         }
         String[] partsofword = new String[list.size()]; // creates an array to hold the substrings
         for (int i = 0; i < partsofword.length; i++) { 
            partsofword[i] = list.get(i); //converts the arraylist of substrings to and array of substrings
         }
      
         int count = 0;
         visited = new boolean[width][height]; 
      
         list2.clear();  //clears the list that will be used to return the positions of the word
         list2copy.clear();
         boolean t;
         for (int i = 0; i < grid.length; i++) { //looks at x positions of grid
            for (int j = 0; j < grid.length; j++) { //looks at y positions of grid
            
               if (grid[i][j].equalsIgnoreCase(partsofword[count])) { //sees if the point of the grid matches the substring
                  goodPaths(i, j, partsofword, count); //finds the path
                  if (checklist(wordToCheck)) { //makes sure that the list of positions and the word to check are the same length
                     return list2;
                  }
               }
            }
         }
         return list2;
      }
      catch (Exception e) {
         throw new IllegalArgumentException(); 
         
      }
   }
   
   private boolean checklist(String wordToCheck) {
      if (list2.size() == wordToCheck.length()) {
         return true;
      }
      return false;
   }
   /** finds the paths. */ 
   
   public void goodPaths(int i, int j, String[] partsofword, int count) {
   
      if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) { //illegal actions
         return;
      }
      if (visited[i][j]) { //makes sure the point hasnt already been used
         return;
      }
      if (count >= partsofword.length) {
         return;
      }
      if (!grid[i][j].equalsIgnoreCase(partsofword[count])) { //if part of grid is not equal to substring
         return;
      }
   
      list2copy.add(i * grid.length + j); //adds the number that corresponds to the position
      visited[i][j] = true; //this point has been visited
   
      count++;
   
      if (list2copy.size() == partsofword.length) {
         list2 = new ArrayList<Integer>(list2copy); //swithces list2 copy and list2
      }
      //looks at all surrounding cells
      goodPaths(i - 1, j - 1, partsofword, count);
      goodPaths(i - 1, j, partsofword, count);
      goodPaths(i - 1, j + 1, partsofword, count);
      goodPaths(i, j + 1, partsofword, count);
      goodPaths(i + 1, j + 1, partsofword, count);
      goodPaths(i + 1, j, partsofword, count);
      goodPaths(i + 1, j - 1, partsofword, count);
      goodPaths(i, j - 1, partsofword, count);
      list2copy.remove(list2copy.size() - 1);
      visited[i][j] = false;
   }
   
   
  /** searches for words. */ 
   
   public boolean wordsearch(String[] list, String target, int bottom, int top) { //binary search
      int middle = (bottom + top) / 2;
      if (bottom > top) {
         return false;
      }
      if ((target.compareTo(list[list.length - 1]) > 0) || (target.compareTo(list[0]) < 0)) {
         return false;
      }
      
      if (list[middle].equals(target)) {
         return true;
      }
      else if (list[middle].compareTo(target) > 0) {
         return wordsearch(list, target, bottom, middle - 1);
      }
      else {
         return wordsearch(list, target, middle + 1, top);
      }      
         
   }
   /** searches for prefixes. */
   
   public boolean prefixsearch(String[] list, String target, int bottom, int top) { //binary search
      int middle = (bottom + top) / 2;
      if (bottom > top) {
         return false;
      }
      if (list[middle].startsWith(target)) {
         return true;
      }
      else if (list[middle].compareTo(target) > 0) {
         return prefixsearch(list, target, bottom, middle - 1);
      }
      else {
         return prefixsearch(list, target, middle + 1, top);
      }      
         
   }
         
         

}