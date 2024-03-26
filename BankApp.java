// program for bank deposite, withdraw, display the balance of user
import java.util.Scanner;
// BankAccount class to represent a simple bank account
class BankAccount 
{
	private double balance; // Instance variable to store the account balance
// Constructor to initialize the bank account with an initial balance
public BankAccount(double initialBalance) 
	{
	balance = initialBalance;
	}
// Method to deposit funds into the account
public void deposit(double amount) {
	if (amount > 0) 
	{ // Check if the deposit amount is valid
	balance += amount; // Add the deposit amount to the balance
	System.out.println("Deposited: " + amount);
	} 
	else 
	{
	System.out.println("Invalid amount for deposit."); // Display error message for invalid amount
	}
}
// Method to withdraw funds from the account
public void withdraw(double amount) {
		try 
		{
		if (amount > balance) 
		{ // Check if withdrawal amount exceeds the balance
		throw new IllegalArgumentException("Withdrawal amount exceeds balance.");
		} 
		else
		{
		balance -= amount; // Subtract the withdrawal amount from the balance
		System.out.println("Withdrawn: " + amount);
		}
		} 
		catch (IllegalArgumentException e) 
		{ // Catch exception for overdrawing
		System.out.println("Error: " + e.getMessage()); // Display error message
		}
}
// Method to display the current balance
		public void displayBalance() 
		{
		System.out.println("Current Balance: " + balance);
		}
}
// Main class for the banking application
public class BankApp 
	{
		public static void main(String[] args) 
		{
		Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
		// Prompt the user to enter initial balance
		System.out.print("Enter initial balance: ");
		double initialBalance = scanner.nextDouble();
		BankAccount account = new BankAccount(initialBalance); // Create a bank account object
		// Display options to the user in a loop
		while (true) 
			{
			System.out.println("\nChoose an option:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Display Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt(); // Read user's choice
			switch (choice) 
			{
			case 1:
			// Prompt the user to enter deposit amount and perform deposit
			System.out.print("Enter deposit amount: ");
			double depositAmount = scanner.nextDouble();
			account.deposit(depositAmount);
			break;
			case 2:
			// Prompt the user to enter withdrawal amount and perform withdrawal
			System.out.print("Enter withdrawal amount: ");
			double withdrawAmount = scanner.nextDouble();
			account.withdraw(withdrawAmount);
			break;
			case 3:
			account.displayBalance(); // Display current balance
			break;
			case 4:
			System.out.println("Exiting..."); // Exit the program
			scanner.close(); // Close the Scanner object
			System.exit(0);
			default:
			System.out.println("Invalid choice. Please try again."); // Display error message for invalid choice
			}
    }
  }
}
