import java.util.*;

class Customer
 {
    int id;
    String name;
    String email;

    public Customer(int id, String name, String email) 
	{
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class CustomerManagementSystem 
{
    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(int id, String name, String email)
	{
        Customer newCustomer = new Customer(id, name, email);
        customerList.add(newCustomer);
    }

    public void removeCustomer(int id) {
        customerList.removeIf(customer -> customer.id == id);
    }

    public Customer searchCustomer(int id) 
	{
        return customerList.stream()
                .filter(customer -> customer.id == id)
                .findFirst()
                .orElse(null);
    }

    public void listAllCustomers()
	{
        customerList.forEach(customer -> System.out.println("ID: " + customer.id + ", Name: " + customer.name + ", Email: " + customer.email));
    }

    public void sortCustomersByName() 
	{
        customerList.sort(Comparator.comparing(customer -> customer.name));
    }

    public void sortCustomersById() 
	{
        customerList.sort(Comparator.comparingInt(customer -> customer.id));
    }

    public static void main(String[] args)
	{
        CustomerManagementSystem cms = new CustomerManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) 
		{
            System.out.println("Choose an operation:");
            System.out.println("1. Add a Customer");
            System.out.println("2. Remove a Customer");
            System.out.println("3. Search for a Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice)
			{
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();
                    cms.addCustomer(id, name, email);
                    break;
                case 2:
                    System.out.print("Enter Customer ID to Remove: ");
                    int removeId = scanner.nextInt();
                    cms.removeCustomer(removeId);
                    break;
                case 3:
                    System.out.print("Enter Customer ID to Search: ");
                    int searchId = scanner.nextInt();
                    Customer foundCustomer = cms.searchCustomer(searchId);
                    if (foundCustomer != null) 
					{
                        System.out.println("Customer found - ID: " + foundCustomer.id + ", Name: " + foundCustomer.name + ", Email: " + foundCustomer.email);
                    } 
					else 
					{
                        System.out.println("Customer not found.");
                    }
                    break;
                case 4:
                    cms.listAllCustomers();
                    break;
                case 5:
                    cms.sortCustomersByName();
                    System.out.println("Customers sorted by Name.");
                    break;
                case 6:
                    cms.sortCustomersById();
                    System.out.println("Customers sorted by ID.");
                    break;
                case 0:
                    System.out.println("Exiting Customer Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
