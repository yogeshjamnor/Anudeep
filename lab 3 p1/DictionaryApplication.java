package colleection;
import java.util.*;

public class DictionaryApplication 
{
  public static void main(String[] args)
  {
	  TreeMap<String, String> dictionary = new TreeMap<>();
      Scanner scanner = new Scanner(System.in);

      // Adding word-definition pairs to the dictionary
      dictionary.put("apple", "a round fruit with red or green skin and a whitish interior");
      dictionary.put("book", "a written or printed work consisting of pages glued or sewn together along one side");

      // Retrieving and displaying the definition of a specific word
      System.out.print("Enter a word to get its definition: ");
      String word = scanner.nextLine();
      if (dictionary.containsKey(word)) {
          System.out.println("Definition: " + dictionary.get(word));
      } else {
          System.out.println("Word not found in the dictionary.");
      }

      // Displaying all word-definition pairs in alphabetical order
      System.out.println("\nAll word-definition pairs in the dictionary:");
      for (String key : dictionary.keySet()) {
          System.out.println(key + ": " + dictionary.get(key));
      }

      scanner.close();
  }
}
