// Banking application withdraw and deposite with initial amount
import java.util.Scanner;
class BankingApplication 
{
    private double balance;

    public BankingApplication(double initialBalance)
    {
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws NegativeDepositException 
	{
      	  if (amount < 0)
		{
       		     throw new NegativeDepositException("Error: Cannot deposit a negative amount.");
       		 }
        balance += amount;
        }

    public void withdraw(double amount) throws InsufficientFundsException 
	{
        if (amount > balance) 
		{
            throw new InsufficientFundsException("Error: Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public double checkBalance() 
	{
        return balance;
    }

    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankingApplication bankingApp = new BankingApplication(initialBalance);

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        try {
            bankingApp.deposit(depositAmount);
            System.out.println("Deposit successful.");
        } 
		catch (NegativeDepositException e)
		{
            System.out.println(e.getMessage());
        }

        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        try {
            bankingApp.withdraw(withdrawAmount);
            System.out.println("Withdrawal successful.");
        } 
		catch (InsufficientFundsException e) 
		{
            System.out.println(e.getMessage());
        }

        System.out.println("Current Balance: " + bankingApp.checkBalance());

        scanner.close();
    }
}

class NegativeDepositException extends Exception 
{
    public NegativeDepositException(String message) 
	{
        super(message);
    }
}

class InsufficientFundsException extends Exception 
{
    public InsufficientFundsException(String message) 
	{
        super(message);
    }
}
