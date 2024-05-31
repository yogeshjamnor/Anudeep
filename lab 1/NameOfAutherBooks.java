// program for the printing Authers of book using collection
import java.util.ArrayList;
class Book 
{
	//creating global variable
    int bookId;
    String bookName;
    String authorName;
    // crating parameter constructor
    public Book(int bookId, String bookName, String authorName)
    {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public static void main(String[] args) 
    {
    	// creating arraylist
        ArrayList<Book> books = new ArrayList<>();
        // craeting the object to arraylist
        Book book1 = new Book(1, "Java Programming", "John Doe");
        Book book2 = new Book(2, "Data Structures", "Jane Smith");
        Book book3 = new Book(3, "Algorithms", "Alice Johnson");
     // adding the object to arraylist
        books.add(book1);
        books.add(book2);
        books.add(book3);
        // printing using foreach loop
        for (Book book : books) 
        {
            System.out.println("Book ID: " + book.bookId);
            System.out.println("Book Name: " + book.bookName);
            System.out.println("Author: " + book.authorName);
            System.out.println();
        }
    }
}
