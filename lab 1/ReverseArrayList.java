// program for reverse string print using collection
import java.util.ArrayList;
import java.util.Collections;

public class ReverseArrayList 
{
    public static void main(String[] args) 
    {
    	//creating arraylist
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Cherry");
        // printing original arraylist         
        System.out.println("Original List: " + stringList);
        // printing arralist in reverse order
        Collections.reverse(stringList);        
        System.out.println("Reversed List: " + stringList);
    }
}
