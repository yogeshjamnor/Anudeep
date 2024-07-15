package operation;

import java.util.List;
import java.util.Scanner;

import dao.CourseDAO;
import model.Course;

public class CourseOperation {
	public static void addCourse(Scanner sc) {
		System.out.println("Enter course ID:");
        String courseId = sc.next();

        System.out.println("Enter course Title:");
        String courseTitle = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter credits:");
        int credits = sc.nextInt();
        
        // Creating object of Course class
        Course obj = new Course(courseId, courseTitle, credits);

        // Calling method to insert into table and passing the object of Movie class
        boolean result = CourseDAO.insert(obj);
        if (result) {
            System.out.println(" The Course is successfully added.");
            System.out.println("To continue follow the steps...");
        } else {
            System.out.println("Something went wrong.");
        }
	}
	
	public static void updateCourse(Scanner sc) {
		System.out.println("Enter Id to which update:");
        String courseId = sc.next();
        
        System.out.println("Enter course Title:");
        String courseTitle = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter credits:");
        int credits = sc.nextInt();
        
        // Creating object of Course class
        Course obj = new Course(courseId, courseTitle, credits);

        // Calling method to insert into table and passing the object of Movie class
        boolean result = CourseDAO.update(obj, courseId);
        if (result) {                        
        	System.out.println("The course is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }  
	}
        
    public static void showCourses(Scanner sc) {
    	//Get all Course
    	List<Course> courses = CourseDAO.getAllCourses();
        for (Course course : courses) {
        	System.out.println(course);
        }
    }
    
    public static void showCourseById(Scanner sc) {
    	System.out.println("Enter Course id to get data:");
        String courseId = sc.next();
        Course obj = CourseDAO.getByCourseID(courseId);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }
    
    public static void deleteCourseById(Scanner sc) {
    	System.out.println("Enter Course id to delete:");
        String courseId = sc.next();

        // Calling method to delete a particular row
        boolean result = CourseDAO.delete(courseId);
        if (result) {
            System.out.println("The course is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
