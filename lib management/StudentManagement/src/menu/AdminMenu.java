package menu;

import java.util.Scanner;

import operation.AutherOperation;
import operation.FeedbackOperation;
import operation.BookOperation;
import operation.ScoreOperation;
import operation.AdminOperation;

public class StudentMenu {

    // Student menu
    public static void AdminMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("Student Menu");
            System.out.println("1. View Book");
            System.out.println("2. View Book By Auther");
            System.out.println("3. View Book By Id");
            System.out.println("4. View Feedback By student Id");
            System.out.println("5. Add Book");
            System.out.println("0. Logout");

           // System.out.println("0. Logout");

            choice = sc.nextInt();
            switch (choice) {
            	case 1:
	            	processBook(sc);
	                break;    
            	case 2:
            		processAuther(sc);
                    break;
                case 3:
                	StudentOperation.showBookById(sc);
                    break;
                case 4:
                	FeedbackOperation.showFeedbackByStudentId(sc);
                    break;
                case 5:
                	FeedbackOperation.addBook(sc);
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    
    public static void processBook(Scanner sc) {
        int choice;
        do {
            System.out.println("Welcome to Book operation");
            System.out.println("1. View Book By Id");
            System.out.println("2. View Books");
            System.out.println("0. Back");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BookOperation.showBookById(sc);
                    break;
                case 2:
                    BookOperation.showBooks(sc);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    
    
    public static void processAuther(Scanner sc) {
        int choice;
        do {
            System.out.println("Welcome to Auther operation");
            System.out.println("1. View Auther By Id");
            System.out.println("2. View all Authers");
            System.out.println("0. Back");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AutherOperation.showAutherById(sc);
                    break;
                case 2:
                	AutherOperation.showAuthers(sc);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    

}
