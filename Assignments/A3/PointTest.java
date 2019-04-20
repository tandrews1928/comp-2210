import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PointTest {

   @Test
   public void shouldreturn() {
      Point p1 = new Point(0, 0);
      Point p2 = new Point(0, 0);
      Assert.assertEquals(-1, p1.compareTo(p2));
   }
   @Test
   public void shouldreturn2() {
      Point p1 = new Point(0, 0);
      Point p2 = new Point(0, 0);
      Assert.assertEquals(0.0, p1.slopeTo(p2), 0.001);
   }
  

 

}
