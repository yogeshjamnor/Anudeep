// program for potato game using queue and perform enqueue and dequeue for win
package colleection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class HotGames 
{
    public static void main(String[] args)
    {
    	// crating queue and adding elements
        Queue<String> players = new LinkedList<>();
        players.add("Player1");
        players.add("Player2");
        players.add("Player3");
        players.add("Player4");
        players.add("Player5");
        players.add("Player6");
        // choose random for random player win
        Random random = new Random();
        // running loop to eliminate all except 1
        while (players.size() > 1)
        {
            int count = random.nextInt(players.size());
            // adding randomly and removing
            for (int i = 0; i < count; i++) 
            {
                String currentPlayer = players.poll();
                players.add(currentPlayer);
            }
            
            String eliminatedPlayer = players.poll();
            System.out.println("Player eliminated: " + eliminatedPlayer);
        }
        // printing winner
        System.out.println("Winner: " + players.poll());
    }
}