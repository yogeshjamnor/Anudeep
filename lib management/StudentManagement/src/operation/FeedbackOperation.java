package operation;

import java.util.List;
import java.util.Scanner;

import dao.FeedbackDAO;
import model.Feedback;

public class FeedbackOperation {

    public static void addFeedback(Scanner sc) {
        System.out.println("Enter student ID:");
        String studentID = sc.next();

        System.out.println("Enter instructor name:");
        String instructorName = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter feedback:");
        String feedbackText = sc.nextLine();

        // Creating object of Feedback class
        Feedback obj = new Feedback(0, studentID, instructorName, feedbackText);

        // Calling method to insert into table and passing the object of Feedback class
        boolean result = FeedbackDAO.insert(obj);
        if (result) {
            System.out.println("The feedback is successfully added.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void updateFeedback(Scanner sc) {
        System.out.println("Enter feedback ID to update:");
        int feedbackID = sc.nextInt();

        System.out.println("Enter student ID:");
        String studentID = sc.next();

        System.out.println("Enter instructor name:");
        String instructorName = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter feedback:");
        String feedbackText = sc.nextLine();

        // Creating object of Feedback class
        Feedback obj = new Feedback(feedbackID, studentID, instructorName, feedbackText);

        // Calling method to update the record in the table
        boolean result = FeedbackDAO.update(obj, feedbackID);
        if (result) {
            System.out.println("The feedback is successfully updated.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

    public static void showFeedbacks(Scanner sc) {
        // Get all Feedbacks
        List<Feedback> feedbacks = FeedbackDAO.getAllFeedbacks();
        for (Feedback feedback : feedbacks) {
            System.out.println(feedback);
        }
    }

    public static void showFeedbackById(Scanner sc) {
        System.out.println("Enter feedback ID to get data:");
        int feedbackID = sc.nextInt();
        Feedback obj = FeedbackDAO.getByFeedbackID(feedbackID);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Feedback with ID " + feedbackID + " not found.");
        }
    }
    
    public static void showFeedbackByStudentId(Scanner sc) {
        System.out.println("Enter student ID to get data:");
        String studentID = sc.next();
        Feedback obj = FeedbackDAO.getByStudentID(studentID);
        if (obj != null) {
            System.out.println(obj);
        } else {
        }
    }

    public static void deleteFeedbackById(Scanner sc) {
        System.out.println("Enter feedback ID to delete:");
        int feedbackID = sc.nextInt();

        // Calling method to delete a particular record
        boolean result = FeedbackDAO.delete(feedbackID);
        if (result) {
            System.out.println("The feedback is successfully deleted.");
        } else {
            System.out.println("Something went wrong.");
        }
    }

}
