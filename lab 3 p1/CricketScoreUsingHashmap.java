package colleection;
import java.util.HashMap;
import java.util.Map;
public class CricketScoreKey
{
  public static void main(String[] args)
  {
	  // creating hashmap to store name and score of cricketer
      Map<String, Integer> cricketerScores = new HashMap<>();
      // adding values
      cricketerScores.put("Virat Kohli", 72);
      cricketerScores.put("Rohit Sharma", 56);
      cricketerScores.put("Steve Smith", 45);
      cricketerScores.put("Kane Williamson", 68);
      // searching Batsman
      String batsmanName = "Virat Kohli";
      if (cricketerScores.containsKey(batsmanName)) 
      {
          System.out.println(batsmanName + "'s score: " + cricketerScores.get(batsmanName));
      } 
      else
      {
          System.out.println("Batsman not found in the records.");
      }
  }
}

