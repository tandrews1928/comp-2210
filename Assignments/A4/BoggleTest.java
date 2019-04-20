import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.SortedSet;
import java.util.TreeSet;


public class BoggleTest {


   @Test public void TigerTest() {
      WordSearchGame game = WordSearchGameFactory.createGame(); //error states that TIGER is being found. //need to clear variables
      game.loadLexicon("wordfiles/words_medium.txt.");
      SortedSet<String> expected = new TreeSet<String>();
      expected.add("CAT");
      expected.add("ACT");
      expected.add("TAX");
      game.setBoard(new String[]{"C","A","X","T"}); 
      
      Assert.assertEquals("getallvalidwordstest", game.getAllValidWords(3), expected); 
      
   }
    
   @Test public void CatFishTest() {
      WordSearchGame game = WordSearchGameFactory.createGame(); //error states that CATFISH is being found.
      game.loadLexicon("wordfiles/words_medium.txt.");
      SortedSet<String> expected = new TreeSet<String>();
      game.setBoard(new String[]{"X","X","X","X","X","X","X","X","X"}); 
      
      Assert.assertEquals("getallvalidwordstest", game.getAllValidWords(7), expected); 
      
   }
   @Test public void isValidWordTest() {
      WordSearchGame game = WordSearchGameFactory.createGame(); //error states that CATFISH is being found.
      game.loadLexicon("wordfiles/CSW12.txt.");
      Assert.assertEquals("isvalidwordtest", game.isValidWord("AAH"), true);
   
   }
}
