import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Your Name (you@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2018-01-25
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T> = t.
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    
    
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      T minvalue = coll.iterator().next();
      for (T element : coll) {
         if (comp.compare(element, minvalue) < 0) {
            minvalue = element; 
         } 
      }
      
      return minvalue;
   }
  


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T> = t.
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      T maxvalue = coll.iterator().next();
      for (T element : coll) {
         if (comp.compare(element, maxvalue) > 0) {
            maxvalue = element; 
         } 
      }
      
      return maxvalue;
   }

   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param <T> = T.
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      if (k < 1 || k > coll.size()) {
         throw new NoSuchElementException();
      }
      ArrayList<T> list = new ArrayList<T>(coll);
      java.util.Collections.sort(list, comp);
      for (int i = list.size() - 1; i > 0; i--) {
         if (comp.compare(list.get(i), list.get(i - 1)) == 0) {
            list.remove(i);
         }
      }
      list.trimToSize();
      if (k > list.size()) {
         throw new NoSuchElementException();
      }
      T kmin;
      kmin = list.get(k - 1);
      
      
      return kmin;
   
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param <T> = t.
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      if (k < 1 || k > coll.size()) {
         throw new NoSuchElementException();
      }
     
      ArrayList<T> list = new ArrayList<T>(coll);
      java.util.Collections.sort(list, comp);
      for (int i = list.size() - 1; i > 0; i--) {  
      // gets rid of duplicate values
         if (comp.compare(list.get(i), list.get(i - 1)) == 0) {
            list.remove(i);
         }
      }
      list.trimToSize();
      if (k > list.size()) {
         throw new NoSuchElementException();
      }
      T kmax;   
      kmax = list.get(list.size() - k);
      
      return kmax;
   }
   /**
   * finds the range.
    @param coll    the Collection from which the ceiling value is selected
    * @param low     the reference value
    * @param high  the high.
    * @param <T> = t.
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above

   */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
                                         
      if (coll == null || comp == null) {
         throw new IllegalArgumentException(); 
      }
         
      if (coll.isEmpty()) {
         throw new NoSuchElementException(); 
      }
          
      Collection<T> range = new ArrayList<>();
      
      for (T element : coll) {
         if ((comp.compare(element, low) >= 0) 
            && (comp.compare(element, high) <= 0)) {
            range.add(element); 
         }
      }
      if (range.size() == 0) {
         throw new NoSuchElementException(); 
      }
      return range;
   }
      
      
      

   


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param <T> = t.
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException(); 
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException(); 
      }
      T minvalue = coll.iterator().next();
      for (T element : coll) {
         if (comp.compare(minvalue, key) < 0) {
            minvalue = element;
         }
      }
       //problem is the first value is to big
      
      for (T element : coll) {
         if ((comp.compare(element, key) >= 0)
            && (comp.compare(element, minvalue) <= 0)) {
            minvalue = element; 
         }
      }
     
      if (comp.compare(minvalue, key) < 0) {
         throw new NoSuchElementException();
      }
      
   
      return minvalue;
   
   
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param <T> = t.
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException(); 
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException(); 
      }
      
      T maxvalue = coll.iterator().next();
      
      for (T element : coll) {
         if (comp.compare(maxvalue, key) > 0) {
            maxvalue = element;
         }
      }
      for (T element : coll) {
         if ((comp.compare(element, key) <= 0)
            && (comp.compare(element, maxvalue) >= 0)) {
            maxvalue = element; 
         }
      }
      if (comp.compare(maxvalue, key) > 0) {
         throw new NoSuchElementException();
      }
      
      
   
      return maxvalue;
   }
    
}
