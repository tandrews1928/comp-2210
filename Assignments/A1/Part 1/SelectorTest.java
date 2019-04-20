import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


   /** Test case for the ceiling method. */
   @Test
   public void testFloor1() {
      int[] a = {-12, 3, 9, 7, 0};
      int key = 11;
      int expected = 9;
      int actual = Selector.floor(a, key);
      assertEquals(expected, actual);
   }
   /** Test case for the ceiling method. */
   @Test
   public void testCeiling2() {
      int[] a = {2, 4, 6, 8, 10};
      int key = 7;
      int expected = 8;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }
   /** Test case for the ceiling method. */
   @Test
   public void testCeiling3() {
      int[] a = {9, 4, 6, 8, 10};
      int key = 3;
      int expected = 4;
      int actual = Selector.ceiling(a, key);
      assertEquals(expected, actual);
   }
  /** Test case for the kmin method. */
   @Test
   public void testkmin1() {
      int[] a = {2, 8, 7, 3, 4};
      int k = 1;
      int expected = 2;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
   /** Test case for the kmin method. */
   @Test
   public void testkmin2() {
      int[] a = {5, 9, 1, 7, 3};
      int k = 3;
      int expected = 5;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
   /** Test case for the kmin method. */
   @Test
   public void testkmin3() {
      int[] a = {8, 7, 6, 5, 4};
      int k = 5;
      int expected = 8;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
    /** Test case for the kmin method. */
   @Test
   public void testkmin4() {
      int[] a = {2, 8, 8, 7, 3, 3, 4};
      int k = 3;
      int expected = 4;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }
   /** Test case for the kmax method. */
   @Test
   public void testkmax4() {
      int[] a = {-4,-4};
      int k = 2;
      int expected = 4;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }
  /** Test case for the kmin method. */
   @Test
   public void testkmax3() {
      int[] a = {8, 7, 6, 5, 4};
      int k = 5;
      int expected = 4;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }
    /** Test case for the kmin method. */
   @Test
   public void testkmax2() {
      int[] a = {5, 9, 1, 7, 3};
      int k = 3;
      int expected = 5;
      int actual = Selector.kmax(a, k);
      assertEquals(expected, actual);
   }
    /** Test case for the kmin method. */
   @Test
   public void testkmax1() {
      int[] a = {2, 8, 7, 3, 4};
      int k = 1;
      int expected = 2;
      int actual = Selector.kmin(a, k);
      assertEquals(expected, actual);
   }

   
   

}
