import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Line.java
 * Models a line segment as a sorted set of points.
 *
 * @author   Tyler Andrews (tja0023@auburn.edu)
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2018-02-27
 *
 */
public class Line implements Comparable<Line>, Iterable<Point> {
 
   SortedSet<Point> line;
   
   /** 
    * Creates a new line containing no points.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Line() {
      line = new TreeSet<Point>();
   }
   
   /** 
    * Creates a new line with containing all distinct collinear points in the
    * Collection c.
    */
   public Line(Collection<Point> c) {
      line = new TreeSet<Point>();
      for (Point point : c) {
         this.add(point);
      }
         
   }
 
   /** 
    * Adds the point p to this line if p is collinear with all points already
    * in the line and p itself is not already in the line. Returns true if this
    * line is changed as a result, false otherwise.
    */
   public boolean add(Point p) {
      if (this.length() > 1) {
         if (p.slopeTo(first()) != p.slopeTo(last())) {
            return false;
         }
      }
      return line.add(p);
   }

        
   /** 
    * Returns the first (minimum) point in this line or null if this line
    * contains no points.
    */
   public Point first() {
      if (length() == 0) {
         return null;
      }
      return line.iterator().next();
      
   }
   
   /** 
    * Returns the last (maximum) point in this line or null if this line
    * contains no points.
    */
   public Point last() {
      if (length() == 0) {
         return null;
      }
      Iterator<Point> itr = line.iterator();
      Point current = null;
      Point last = null;
      while (itr.hasNext()) {
         current = itr.next();
      }
      last = current;
      return last;
   }
   
   /** 
    * Returns the number of points in this line.
    */
   public int length() {
      int size = 0;
      Iterator<Point> itr = line.iterator();
   
      while (itr.hasNext()) {
         size++;
         itr.next();
      }
      return size;
   }

   /**
    * Compares this line with the specified line for order. Returns a negative
    * integer, zero, or a positive integer if this line is less than, equal to,
    * or greater than the specified line. Lines are ordered first by their
    * first point then by their last point. An empty line is less than any
    * non-empty line, and all empty lines are equal. All three properties of
    * compareTo as specified in the Comparable interface are met, and this
    * implementation is consistent with equals.
    */
   @Override
   public int compareTo(Line that) {
      
      
      
      if (this.length() == 0 && that.length() == 0) {
         return 0;
      }        
      if (this.length() == 0 && that.length() > 0) {
         return -1;
      }
      if (this.length() > 0 && that.length() == 0) {
         return 1;
      }
      if (that.first().equals(this.first()) && that.last().equals(this.last())) {
         return 0;
      }
      if (this.first().compareTo(that.first()) < 0) {
         return -1;
      }
      if (this.first().equals(that.first()) && this.last().compareTo(that.last()) < 0) {
         return -1;
      }
      if (this.first().equals(that.first()) && this.last().compareTo(that.last()) > 0) {
         return 1;
      }
      return 1;
   }

   /** 
    * Provide an iterator over all the points in this line. The order in which
    * points are returned must be ascending natural order.
    */
   @Override
   public Iterator<Point> iterator() {
      Iterator<Point> itr = line.iterator();
      return itr;
   }
   
   /** 
    * Return true if this line's first and last points are equal to the
    * parameter's first and last points. Empty lines are equal to each other
    * but are not equal to any non-empty line.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   @Override 
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if (!(obj instanceof Line)) {
         return false;
      }
      Line that = (Line) obj;
      if ((this.length() == 0) && (that.length() == 0)) {
         return true;
      }
      if ((this.length() == 0) && (that.length() != 0)) {
         return false;
      }
      if ((this.length() != 0) && (that.length() == 0)) {
         return false;
      }
      return (this.first().equals(that.first())) && (this.last().equals(that.last()));
   }
 
   /** 
    * Return a string representation of this line.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   @Override
   public String toString() {
      if (length() == 0) {
         return "";
      }
      StringBuilder s = new StringBuilder();
      for (Point p : line) {
         s.append(p + " -> ");
      }
      s = s.delete(s.length() - 4, s.length());
      return s.toString();
   }
 
}
