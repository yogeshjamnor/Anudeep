
// Banking system in java
import java.util.*;
class Account 
{
    int accountNumber;
    float balance;
    Customer customer;

    Account(int accNo, Customer cust) 
    {
        accountNumber = accNo;
        customer = cust;
    }

    void deposit(float amount)
    {
        balance += amount;
    }

    void withdraw(float amount) 
    {
        if (balance >= amount) 
        {
            balance -= amount;
        } 
        else 
        {
            System.out.println("Insufficient funds.");
        }
    }

    float getBalance() {
        return balance;
    }

    Customer getCustomer() {
        return customer;
    }
}

class Customer 
{
    String name;
    int accountNumber;

    Customer(String custName, int accNo) 
    {
        name = custName;
        accountNumber = accNo;
    }

    int getAccountNumber()
    {
        return accountNumber;
    }

    String getName() 
    {
        return name;
    }
}

public class BankingSystem 
{
    public static void main(String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter your name :");
    	String name=sc.nextLine();
    	System.out.println("enter Amount You want Deposite :");
    	int bal=sc.nextInt();
    	Random rand = new Random();
    	int accno = rand.nextInt(900000) + 100000;
    	
        Customer customer1 = new Customer(name, accno);
        Account account1 = new Account(accno, customer1);

        System.out.println("Customer Name: " + customer1.getName());
        System.out.println("Customer Account Number: " + customer1.getAccountNumber());

        account1.deposit(bal);
        System.out.println("Balance after deposit: " + account1.getBalance());
        System.out.println("enter ammount You want Withdraw :");
        float wi=sc.nextFloat();
        account1.withdraw(wi);
        System.out.println("Balance after withdrawal: " + account1.getBalance());
    }
}
