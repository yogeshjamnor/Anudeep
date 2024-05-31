// program for Addition of even numbers using collection
import java.util.ArrayList;

public class EvenSumCalculator 
{
    public static void main(String[] args)
    {
    	// creating collection
        ArrayList<Integer> numbers = new ArrayList<>();
        // adding values in arraylist
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        
        int sum = 0;
        //calculating sum using foreach loop
        for (int num : numbers)
        {
            if (num % 2 == 0) 
            {
                sum += num;
            }
        }
        // printing sum
        System.out.println("Sum of even numbers: " + sum);
    }
}
