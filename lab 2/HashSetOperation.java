// program for the operation of hashset
package colleection;
import java.util.HashSet;
public class HashSetOperation 
{
	    public static void main(String[] args)
	    {
	        HashSet<Integer> numbers = new HashSet<>();
	        //adding numbers to hashset
	        numbers.add(5);
	        numbers.add(10);
	        numbers.add(15);
	        numbers.add(20);
	        numbers.add(25);
	        // printing the added integers of hashset
	        System.out.println("Elements in the HashSet: " + numbers);
	        // check whether 10 preset
	        System.out.println("Does the set contain 10? " + numbers.contains(10));
	        //  15 remove from hashset
	        numbers.remove(15);
	        // printing size of hashset
	        System.out.println("Size of the HashSet: " + numbers.size());
	    }
	}

