import java.io.Console;
public class AddNumbers
{
    public static void main(String[] args) 
    {
    	// console object
        Console console = System.console();
        
        if (console == null)
        {
        	//checking console available 
            System.err.println("No console.");
            System.exit(1);
        }
      //getting string  values
        String num1 = console.readLine("Enter first number: ");
        String num2 = console.readLine("Enter second number: ");
      //converting string  values
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        // adding
        int sum = number1 + number2;
        // print values in console
        console.printf("The sum of %d and %d is: %d%n", number1, number2, sum);
    }
}