import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Tyler Andrews (Tja0023@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2018-04-17
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...
   String firstvalue;
   


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
      int a = 0;
      int b = 0;
      int k = K;
      firstvalue = sourceText.substring(0 , k);
      
      while (a + k <= sourceText.length()) {
      
         String check = sourceText.substring (a, a + k);
         String empty = "";
         
         if (!model.containsKey(check)) {
         
            int i = k;
            
            while (b + i < sourceText.length()) {
               String g = sourceText.substring (b, b + i);
               if (b + k >= sourceText.length()) {
                  empty += '\u0000';
               }
               if (check.equals(g)) {
                  empty += sourceText.substring(b + i, b + i + 1);
               }
               b++;
            }
            model.put(check, empty);
         }
         b = 0;
         a++;
      }
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return firstvalue;
   }


   /** Returns  kgram chosen at random from the source text. */
   public String getRandomKgram() {
      int b = 0;
      int size = model.size();
      Random random = new Random();
      
      int at = random.nextInt(size);
      for (String i : model.keySet()) {
         if (at == b) {
            return i;
         }
         b++;
      }
      return null;
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      String empty = "";
      int b = 0;
      Random random = new Random();
      
      for(String i: model.keySet()) {
         if (i.equals(kgram)) {
            empty = model.get(kgram);
            int a = empty.length();
            if (a > 0) {
               b = random.nextInt(a) + 1;
            }
         }
      }
      int c = b - 1;
      if (!empty.equals("")) {
         return empty.charAt(c);
      }
      return '\u0000';
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
   @Override
    public String toString() {
      return model.toString();
   }

}
