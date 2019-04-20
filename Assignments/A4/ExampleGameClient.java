
/**
 * ExampleGameClient.java
 * A sample client for the assignment handout.
 *
 * @author      Dean Hendrix (dh@auburn.edu)
 * @version     2018-03-22
 *
 */
public class ExampleGameClient {

   /** Drives execution. */
   public static void main(String[] args) {
   
      WordSearchGame game = WordSearchGameFactory.createGame();
      
   
      game.loadLexicon("wordfiles/words_medium.txt.");
     
      game.setBoard(new String[]{"T","A","C","L"}); 
      System.out.print("TIGER is on the board at the following positions: ");
      System.out.println(game.isOnBoard("TAX"));
      System.out.print("POPE is on the board at: ");
      System.out.println(game.isOnBoard("TAX"));
      System.out.println("All words of length 3 or more: ");
      System.out.println(game.getAllValidWords(3));
   }
   
      
}

/*

RUNTIME OUTPUT:

LENT is on the board at the following positions: [5, 6, 9, 13]
POPE is not on the board: []
All words of length 6 or more:
[ALEPOT, BENTHAL, PELEAN, TOECAP]

 */
