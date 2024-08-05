import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookUtility
 {
    private static String[] bookTitles = new String[10];
    private static int size = 0;

    public static void addBookTitle(String title)
     {
        bookTitles[size] = title;
        size++;
    }

    public static void removeBookTitle(String title)
     {
        for (int i = 0; i < size; i++)
         {
            if (bookTitles[i].equals(title)) 
            {
                bookTitles[i] = null;
                size--;
                break;
            }
        }
    }

    public static int searchBookTitle(String title)
     {
        for (int i = 0; i < size; i++) 
        {
            if (bookTitles[i].equals(title)) 
            {
                return i;
            }
        }
        return -1;
    }

    public static void listAllBookTitles()
     {
        for (int i = 0; i < size; i++)
         {
            System.out.println(bookTitles[i]);
        }
    }

    public static void sortBookTitles() 
    {
        Arrays.sort(bookTitles, 0, size);
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        addBookTitle("Java Programming");
        addBookTitle("Data Structures and Algorithms");
        addBookTitle("Design Patterns");

        System.out.println("Enter a book title to search:");
        String searchTitle = scanner.nextLine();

        int index = searchBookTitle(searchTitle);
        if (index != -1) 
        {
            System.out.println("Book found at index: " + index);
        } 
        else 
        {
            System.out.println("Book not found.");
        }

        sortBookTitles();
        listAllBookTitles();

        scanner.close();
    }
}
