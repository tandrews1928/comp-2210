import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  YOUR NAME (YOU@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2018-02-27
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
   
   private int numberof;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) throws FileNotFoundException {
   
    
      Scanner scanFile = new Scanner(new File(filename));
      
      numberof = 0;
      numberof = scanFile.nextInt();;
      int x = 0;
      int y = 0;
      points = new Point[numberof];
      for (int i = 0; i < numberof; i++) {
         x = scanFile.nextInt();
         y = scanFile.nextInt();
         points[i] = new Point(x, y);
      }          
   
      
   
   
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      Point[] copyofpoints = Arrays.copyOf(points, points.length);
      Arrays.sort(copyofpoints);
      for (int a = 0; a < copyofpoints.length - 3; a++) { //gets the first point
         for (int b = a + 1; b < copyofpoints.length - 2; b++) { //gets the second point
            for (int c = b + 1; c < copyofpoints.length - 1; c++) { //gets the third point
               for (int d = c + 1; d < copyofpoints.length; d++) { //gets the fourth point
                  if (copyofpoints[a].slopeTo(copyofpoints[b]) == (copyofpoints[a].slopeTo(copyofpoints[c])) &&  //compares the slopes
                     copyofpoints[a].slopeTo(copyofpoints[b]) == copyofpoints[a].slopeTo(copyofpoints[d])) {
                     Point n = copyofpoints[a];
                     Point m = copyofpoints[d];
                     Line newLine = new Line();
                     newLine.add(n);
                     newLine.add(m);
                     lines.add(newLine);
                     
                     
                  }
               }
            }
         }
      }
                          
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Point[] copyofpoints = Arrays.copyOf(points, points.length);
      Point[] byslopearray = Arrays.copyOf(points, points.length);
      for (int i = 0; i < numberof; i++) {
         Point pivot = copyofpoints[i]; //sets the pivot
         Arrays.sort(byslopearray);
         Arrays.sort(byslopearray, pivot.slopeOrder); // sorts arcording to slope made with the pivot
         
         int j = 1;
         
         while (j < numberof - 1) {
         
            double slope = pivot.slopeTo(byslopearray[j]);
            
            if (pivot.slopeTo(byslopearray[j + 1]) == slope) { //finds the start of the segment
               int begining = j;
               int end = j + 1;
               
               for (int b = j + 1; b < numberof; b++) {    //something is wron here i think    
                  if (pivot.slopeTo(byslopearray[b]) == slope) {  //finds the end of the segment
                     end = b;
                     
                  }
                  else {
                     break;
                  }
               }
               
               if ((end - begining >= 2) && (pivot.compareTo(byslopearray[begining]) < 0)) { //makes sure that there are 4 or more points
                  Line newLine = new Line();
                  newLine.add(pivot);
                  for (int k = begining; k <= end; k++) {
                  
                     Point w = byslopearray[k];
                     
                     newLine.add(w);
                     lines.add(newLine);
                  }
               }  
               j = end + 1; 
            }
            else {
               j++;
            }
         }
      
      }
      return lines;
   }
   
 
}
