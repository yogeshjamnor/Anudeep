package operation;

import java.util.List;
import java.util.Scanner;

import dao.ScoreDAO;
import model.Score;

public class ScoreOperation {
	 public static void addScore(Scanner sc) {
	        System.out.println("Enter score ID:");
	        String scoreID = sc.next();

	        System.out.println("Enter student ID:");
	        String studentID = sc.next();

	        System.out.println("Enter course ID:");
	        String courseID = sc.next();

	        System.out.println("Enter credit obtained:");
	        String creditObtained = sc.next();

	        System.out.println("Enter date of exam (YYYY-MM-DD):");
	        String dateOfExamStr = sc.next();

	        // Creating object of Score class
	        Score obj = new Score(scoreID, studentID, courseID, creditObtained, java.sql.Date.valueOf(dateOfExamStr));

	        // Calling method to insert into table and passing the object of Score class
	        boolean result = ScoreDAO.insert(obj);
	        if (result) {
	            System.out.println("The score is successfully added.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void updateScore(Scanner sc) {
	        System.out.println("Enter score ID to update:");
	        String scoreID = sc.next();

	        System.out.println("Enter student ID:");
	        String studentID = sc.next();

	        System.out.println("Enter course ID:");
	        String courseID = sc.next();

	        System.out.println("Enter credit obtained:");
	        String creditObtained = sc.next();

	        System.out.println("Enter date of exam (YYYY-MM-DD):");
	        String dateOfExamStr = sc.next();

	        // Creating object of Score class
	        Score obj = new Score(scoreID, studentID, courseID, creditObtained, java.sql.Date.valueOf(dateOfExamStr));

	        // Calling method to update the record in the table
	        boolean result = ScoreDAO.update(obj, scoreID);
	        if (result) {
	            System.out.println("The score is successfully updated.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

	    public static void showScores(Scanner sc) {
	        // Get all Scores
	        List<Score> scores = ScoreDAO.getAllScores();
	        for (Score score : scores) {
	            System.out.println(score);
	        }
	    }

	    public static void showScoreById(Scanner sc) {
	        System.out.println("Enter score ID to get data:");
	        String scoreID = sc.next();
	        Score obj = ScoreDAO.getByScoreID(scoreID);
	        if (obj != null) {
	            System.out.println(obj);
	        } else {
	            System.out.println("Score with ID " + scoreID + " not found.");
	        }
	    }

	    public static void deleteScoreById(Scanner sc) {
	        System.out.println("Enter score ID to delete:");
	        String scoreID = sc.next();

	        // Calling method to delete a particular record
	        boolean result = ScoreDAO.delete(scoreID);
	        if (result) {
	            System.out.println("The score is successfully deleted.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }
	    
	    public static void addScoreByStudentId(Scanner sc) {
	        System.out.println("Enter Score ID:");
	        String scoreID = sc.next();

	        System.out.println("Enter Student ID:");
	        String studentID = sc.next();

	        System.out.println("Enter Course ID:");
	        String courseID = sc.next();

	        System.out.println("Enter Credit Obtained:");
	        String creditObtained = sc.next();

	        System.out.println("Enter Date Of Exam (YYYY-MM-DD):");
	        String dateOfExam = sc.next();

	        // Creating object of Score class
	        Score score = new Score(scoreID, studentID, courseID, creditObtained, java.sql.Date.valueOf(dateOfExam));

	        // Calling method to add score and passing the object of Score class
	        boolean result = ScoreDAO.addScoreByStudentId(score);
	        if (result) {
	            System.out.println("The score is successfully added.");
	        } else {
	            System.out.println("Something went wrong.");
	        }
	    }

}
