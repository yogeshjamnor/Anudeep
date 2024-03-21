import java.util.Scanner;
public class SimpleCalc 
{
public static void main(String[] args) 
{
		Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
		char choice; // Variable to store user's choice for continuing or exiting the program
		do {
		System.out.println("Welcome to Simple Calculator!");
		System.out.print("Enter the first number: ");
		double num1 = scanner.nextDouble(); // Read the first number from the user
		System.out.print("Enter the operator (+, -, *, /): ");
		char operator = scanner.next().charAt(0); // Read the operator from the user
		System.out.print("Enter the second number: ");
		double num2 = scanner.nextDouble(); // Read the second number from the user
		double result = 0; // Variable to store the result of the calculation
		try {
				// Perform the calculation based on the operator
				switch (operator) {
				case '+':
				result = num1 + num2;
				break;
				case '-':
				result = num1 - num2;
				break;
				case '*':
				result = num1 * num2;
				break;
				case '/':
					if (num2 == 0) 
					{
						throw new ArithmeticException("Division by zero is not allowed");
					}
				result = num1 / num2;
				break;
				default:
				throw new IllegalArgumentException("Invalid operator: " + operator);
				}
				System.out.println("Result: " + result); // Display the result
		}
		catch (ArithmeticException e) 
		{
			System.err.println("Error: " + e.getMessage()); // Handle division by zero exception
		} 
		catch (IllegalArgumentException e) 
		{
			System.err.println("Error: " + e.getMessage()); // Handle invalid operator exception
		}
			System.out.print("Do you want to perform another calculation? (y/n): ");
			choice = scanner.next().charAt(0); // Ask the user if they want to continue
		} 
		while (choice == 'y' || choice == 'Y'); // Continue the loop if the user enters 'y' or 'Y'
		System.out.println("Thank you for using Simple Calculator!");
		scanner.close(); // Close the Scanner object to release resources
	}
}