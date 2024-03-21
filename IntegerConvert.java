import java.util.Scanner;
public class IntegerConvert 
{
public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		boolean continueConversion = true;
		while (continueConversion) {
		boolean validInput = false;
		while (!validInput) {
	try 
	{
		// Prompt the user to enter a number as a string
		System.out.print("Enter a number: ");
		String userInput = scanner.nextLine();
		// Attempt to convert the user input to an integer
		int number = Integer.parseInt(userInput);
		// If no exception occurs, display the converted integer
		System.out.println("Converted number: " + number);
		validInput = true; // Set validInput to true to exit the inner loop
	} 
	catch (NumberFormatException e)
	{
		// If NumberFormatException occurs (invalid number format), display error message
		System.out.println("Error: Invalid number format. Please enter a valid integer.");
	} 
	catch (NullPointerException e)
	{
		// If NullPointerException occurs (user input is null), display error message
		System.out.println("Error: Null input. Please enter a valid string.");
	}
	}
		// Ask the user if they want to convert another number
		System.out.print("Do you want to convert another number? (yes/no): ");
		String choice = scanner.nextLine();
		continueConversion = choice.equalsIgnoreCase("yes");
	}
		scanner.close(); // Close the scanner to release resources
}
}