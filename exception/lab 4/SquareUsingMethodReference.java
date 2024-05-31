// program for square of number using method reference using static
@FunctionalInterface
interface Calculator 
{
	//creating function interface with one parameter
    int calculate(int number);
}

public class MethodReference 
{
	// crating static method
    public static int square(int number) 
    {
        return number * number;
    }

    public static void main(String[] args) 
    {
    	// creating reference and access it
        Calculator calculator = MethodReference::square;
        
        int result = calculator.calculate(9);
       // Printing the output
        System.out.println("Square of 9 is: " + result);
    }
}
