package operation;

import java.util.List;
import java.util.Scanner;

import dao.InstructorDAO;
import model.Instructor;

public class InstructorOperation {
	 public static void addInstructor(Scanner sc) {
	        System.out.println("Enter instructor ID:");
	        String instructorID = sc.next();

	        System.out.println("Enter email:");
	        String email = sc.next();

	        System.out.println("Enter first name:");
	        String firstName = sc.nextLine();
	        sc.nextLine();

	        System.out.println("Enter last name:");
	        String lastName = sc.nextLine();

	        // Creating object of Instructor class
	        Instructor obj = new Instructor(instructorID, email, firstName, lastName);

	        // Calling method to insert into table and passing the object of Instructor class
	        boolean result = InstructorDAO.insert(obj);
	        if (result) {
	            System.out.println("The instructor is successfully added.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void updateInstructor(Scanner sc) {
	        System.out.println("Enter instructor ID to update:");
	        String instructorID = sc.next();

	        System.out.println("Enter email:");
	        String email = sc.next();

	        System.out.println("Enter first name:");
	        String firstName = sc.nextLine();
	        sc.nextLine();

	        System.out.println("Enter last name:");
	        String lastName = sc.nextLine();

	        // Creating object of Instructor class
	        Instructor obj = new Instructor(instructorID, email, firstName, lastName);

	        // Calling method to update the record in the table
	        boolean result = InstructorDAO.update(obj, instructorID);
	        if (result) {
	            System.out.println("The instructor is successfully updated.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void showInstructors(Scanner sc) {
	        // Get all Instructors
	        List<Instructor> instructors = InstructorDAO.getAllInstructors();
	        for (Instructor instructor : instructors) {
	            System.out.println(instructor);
	        }
	    }

	    public static void showInstructorById(Scanner sc) {
	        System.out.println("Enter instructor ID to get data:");
	        String instructorID = sc.next();
	        Instructor obj = InstructorDAO.getByInstructorID(instructorID);
	        if (obj != null) {
	            System.out.println(obj);
	        } else {
	            System.out.println("Instructor with ID " + instructorID + " not found.");
	        }
	    }

	    public static void deleteInstructorById(Scanner sc) {
	        System.out.println("Enter instructor ID to delete:");
	        String instructorID = sc.next();

	        // Calling method to delete a particular record
	        boolean result = InstructorDAO.delete(instructorID);
	        if (result) {
	            System.out.println("The instructor is successfully deleted.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }
	    
	    public static void showAssignedCourses(Scanner sc) {
	        // Get all Instructors
	        List<Instructor> instructors = InstructorDAO.getAssignedCourse();
	        for (Instructor instructor : instructors) {
	            System.out.println(instructor);
	        }
	    }

}
