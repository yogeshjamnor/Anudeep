package operation;

import java.util.List;
import java.util.Scanner;

import dao.StudentDAO;
import model.Student;

public class StudentOperation {
	public static void addStudent(Scanner sc) {
        System.out.println("Enter student ID:");
        String studentID = sc.next();

        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter date of birth (YYYY-MM-DD):");
        String dateOfBirthStr = sc.next();

        System.out.println("Enter gender:");
        String gender = sc.next();

        System.out.println("Enter email:");
        String email = sc.next();

        System.out.println("Enter phone:");
        String phone = sc.next();

        // Creating object of Student class
        Student obj = new Student(studentID, firstName, lastName, java.sql.Date.valueOf(dateOfBirthStr), gender, email, phone);

        // Calling method to insert into table and passing the object of Student class
        boolean result = StudentDAO.insert(obj);
        if (result) {
            System.out.println("The student is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void updateStudent(Scanner sc) {
        System.out.println("Enter student ID to update:");
        String studentID = sc.next();

        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter date of birth (YYYY-MM-DD):");
        String dateOfBirthStr = sc.next();

        System.out.println("Enter gender:");
        String gender = sc.next();

        System.out.println("Enter email:");
        String email = sc.next();

        System.out.println("Enter phone:");
        String phone = sc.next();

        // Creating object of Student class
        Student obj = new Student(studentID, firstName, lastName, java.sql.Date.valueOf(dateOfBirthStr), gender, email, phone);

        // Calling method to update the record in the table
        boolean result = StudentDAO.update(obj, studentID);
        if (result) {
            System.out.println("The student is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void showStudents(Scanner sc) {
        // Get all Students
        List<Student> students = StudentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void showStudentById(Scanner sc) {
        System.out.println("Enter student ID to get data:");
        String studentID = sc.next();
        Student obj = StudentDAO.getByStudentID(studentID);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

    public static void deleteStudentById(Scanner sc) {
        System.out.println("Enter student ID to delete:");
        String studentID = sc.next();

        // Calling method to delete a particular record
        boolean result = StudentDAO.delete(studentID);
        if (result) {
            System.out.println("The student is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
