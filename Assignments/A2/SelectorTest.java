import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Test;


public class SelectorTest {


   
   /** Test case for the ceiling method. */ 
   @Test
   public void testCeiling(){
      int[] coll = {9,7};
      int key = 5;
      Comparator<T> comp = new Selector.CompareIntegerAscending();
      int expected = 7;
      int actual = Selector.floor(coll, key, comp);
      assertEquals(expected, actual);
   }
   /** Test case for the ceiling method. */ /**
   @Test
   public void testCeiling2() {
      int[] a = {2, 4, 6, 8, 10};
      int key = 7;
      int expected = 8;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }
   /** Test case for the ceiling method. */ /**
   @Test
   public void testCeiling3() {
      int[] a = {9, 4, 6, 8, 10};
      int key = 3;
      int expected = 4;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }
  
  /** Test case for the kmin method. */
  
}
