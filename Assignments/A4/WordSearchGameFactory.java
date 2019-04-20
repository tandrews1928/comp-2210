
/**
 * Provides a factory method for creating word search games. 
 *
 * @author Tyler Andrews (tja0023@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version TODAY
 */
public class WordSearchGameFactory {

   /**
    * Returns an instance of a class that implements the WordSearchGame
    * interface.
    */
   public static WordSearchGame createGame() {
   
      WordSearchGame c = new Boggle();
     
      // You must return an instance of your solution class here instead of null.
      return c;
   }

}
