package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.StudentDBConnection;
import model.Feedback;

public class FeedbackDAO {

    static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Feedback obj) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "INSERT INTO FEEDBACK(StudentID,Course, Feedback) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getStudentID());
            pstmt.setString(2, obj.getInstructorName());
            pstmt.setString(3, obj.getFeedback());

            pstmt.executeUpdate();

            // Retrieve the auto-generated key (ID)
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                // You might want to handle the auto-generated key if required
            }

            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
        return f;
    }

    // Update Feedback
    public static boolean update(Feedback obj, int feedbackID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "UPDATE FEEDBACK SET StudentID = ?, Course = ?, Feedback = ? WHERE FeedbackID = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getStudentID());
            pstmt.setString(2, obj.getCourseName());
            pstmt.setString(3, obj.getFeedback());
            pstmt.setInt(4, feedbackID);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Delete Method
    public static boolean delete(int feedbackID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String qDelete = "DELETE FROM FEEDBACK WHERE FeedbackID=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setInt(1, feedbackID);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Feedback by FeedbackID
    public static Feedback getByFeedbackID(int feedbackID) {
        Feedback feedback = null;
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM FEEDBACK WHERE FeedbackID=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setInt(1, feedbackID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                feedback = new Feedback();
                feedback.setFeedbackID(rs.getInt("FeedbackID"));
                feedback.setStudentID(rs.getString("StudentID"));
                feedback.setInstructorName(rs.getString("Course"));
                feedback.setFeedback(rs.getString("Feedback"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return feedback;
    }

    public static List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM FEEDBACK";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackID(rs.getInt("FeedbackID"));
                feedback.setStudentID(rs.getString("StudentID"));
                feedback.setInstructorName(rs.getString("Course"));
                feedback.setFeedback(rs.getString("Feedback"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return feedbacks;
    }
    

    // Feedback by FeedbackID
    public static Feedback getByStudentID(String studentID) {
        Feedback feedback = null;
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM FEEDBACK WHERE StudentID=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, studentID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                feedback = new Feedback();
                feedback.setFeedbackID(rs.getInt("FeedbackID"));
                feedback.setStudentID(rs.getString("StudentID"));
                feedback.setInstructorName(rs.getString("Course"));
                feedback.setFeedback(rs.getString("Feedback"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return feedback;
    }

    // Close resources method
    private static void closeResources() {
        try {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
