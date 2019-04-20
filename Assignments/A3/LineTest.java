import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Arrays;


public class LineTest {

    
 
   @Test
   public void lengthTest() { 
      SortedSet<Point> set = new TreeSet<Point>();
      Point a = new Point(1,0);
      Point b = new Point(2,0);
      Line l = new Line();
      set.add(a);
      set.add(b);
      Assert.assertEquals(2, l.length());
   }





}
