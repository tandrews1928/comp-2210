import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   YOUR NAME (YOU@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2018-01-15
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { 
   }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a = an array of ints.
    * @return minvalue = the minvalue.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int minvalue = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] < minvalue) {
            minvalue = a[i]; 
         } 
      }
   
      return minvalue;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a = an array of ints.
    * @return maxvalue = the maxvalue.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int maxvalue = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] > maxvalue) {
            maxvalue = a[i]; 
         }
      }
   
      return maxvalue;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a = an int array.
    * @param k = an int.
    * @return -99 = placeholder.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
   
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      int h = 1;
      int copy = 0;
      for (int val : b) {
         if (!(h < b.length)) {
            break;
         }   
         if (val == b[h]) {
            
            copy++;
         }  
         h++;   
      }
      int answer = (b.length - copy);
      
      if (k > answer) {
         throw new IllegalArgumentException(); 
      }
   
      int[][] rank = new int[b.length][2];
      int solution = 99;
      int counter = 1;
      int rankcounter = 1;
      int catcher = 0;
      if (k == 1 && b.length == 1) {
         solution = a[0]; 
         return solution;
      }
      if (k == 2 && b.length == 2 && b[0] != b[1]) {
         solution = b[1];
         return solution;
      }
      for (int i = 0; i < b.length; i++) {
         rank[i][0] = b[i];
      }
      rank[0][1] = 1;
      if (k == 1) {
         catcher = rank[0][0];
      }
      else {
         for (int t : b) {
            if (counter < b.length) {
               
               if (t == b[counter]) {
                  
                  rank[counter][1] = rankcounter;
                  
                  if (rankcounter == k) {
                     catcher = rank[counter][0];
                     break;
                  }
               }
               else {
                  ++rankcounter;
                  rank[counter][1] = rankcounter;
                  if (rankcounter == k) {
                     catcher = rank[counter][0];
                     break;
                  }
               }
               counter++;
            }
         }
      }
      return catcher;
   }
   
   


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a = an int array.
    * @param k = an int.
    * @return -99 = placeholder.    
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      int h = 1;
      int copy = 0;
      for (int val : b) {
         if (!(h < b.length)) {
            break;
         }   
         if (val == b[h]) {
            
            copy++;
         }  
         h++;   
      }
      int answer = (b.length - copy);
      
      if (k > answer) {
         throw new IllegalArgumentException(); 
      }
     
      for (int i = 0; i < b.length / 2; ++i) { 
         int temp = b[i]; 
         b[i] = b[b.length - i - 1]; 
         b[b.length - i - 1] = temp; 
      }
      int[][] rank = new int[b.length][2];
      int solution = 99;
      int counter = 1;
      int rankcounter = 1;
      int catcher = 0;
      if (k == 1 && b.length == 1) {
         solution = b[0]; 
         return solution;
      }
      if (k == 2 && b.length == 2 && b[0] != b[1]) {
         solution = b[1];
         return solution;
      }
      for (int i = 0; i < b.length; i++) {
         rank[i][0] = b[i];
      }
      rank[0][1] = 1;
      if (k == 1) {
         catcher = rank[0][0];
      }
      else {
         for (int t : b) {
            if (counter < b.length) {
               
               if (t == b[counter]) {
                  
                  rank[counter][1] = rankcounter;
                  
                  if (rankcounter == k) {
                     catcher = rank[counter][0];
                     break;
                  }
               }
               else {
                  ++rankcounter;
                  rank[counter][1] = rankcounter;
                  if (rankcounter == k) {
                     catcher = rank[counter][0];
                     break;
                  }
               }
               counter++;
            }
         }
      }
      return catcher;
   }
   
   

  

   
   private static int[] arrayadd(int[] element, int v) {
   
      int[] aarray = new int[(element.length + 1)];
      int num = 0;
   
      if (element == null) {
      
         throw new IllegalArgumentException();
      }
   
   
      for (int i : element) {
         aarray[num] = i;
         num++;
      }
      aarray[num] = v;
   
      return aarray;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    * @param a = an array of ints.
    * @param low = the low value.
    * @param high = the high value.
    * @return aarray = the new array.
    */
   public static int[] range(int[] a, int low, int high) {
      int[] aarray = new int[0];
   
      if (a == null || a.length == 0) {
      
         throw new IllegalArgumentException();
      }
      
        
      if (low <= high) {
      
         if (a.length == 1 && low >= a[0] && high <= a[0])  {
         
            return a;  
         }
      }
      for (int d : a) {
      
         if (d >= low && d <= high) {
         
            aarray = Selector.arrayadd(aarray, d);
            
         }
      }
       
      return aarray;
   }



   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a = an int array.
    * @param key = an int.
    * @return value = the value.
    */
   public static int ceiling(int[] a, int key) {
      int standard = 999;
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
         
      }
      
         
       
      
      for (int value : a) {
         if (value >= key && value <= standard) {
            standard = value; 
            
         }
      }
      if (standard != 999) {
         return standard;
      }
      else {
         throw new IllegalArgumentException();
      }      
   
   }

   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a = an int array.
    * @param key = an int.
    * @return value = the value.
    */
   public static int floor(int[] a, int key) {
      int standard = -999;
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
         
      }
      
   
         
       
      for (int value : a) {
         if (value <= key && value >= standard) {
            standard = value;
            
         }
      }
      if (standard != -999) {
         return standard;  
      }
      else {
         throw new IllegalArgumentException();
      }
    
   }

}
