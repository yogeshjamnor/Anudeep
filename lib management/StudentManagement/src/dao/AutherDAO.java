package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.StudentDBConnection;
import model.Enrollment;

public class EnrollmentDAO {

    static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Enrollment obj) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "INSERT INTO Auther(AutherID, BookID, CourseID, Price) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getAutherID());
            pstmt.setString(2, obj.getBookID());
            pstmt.setString(3, obj.getCourseID());
            pstmt.setString(4, obj.getPrice());

            pstmt.executeUpdate();

            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
        return f;
    }

    // Update Enrollment
    public static boolean update(Enrollment obj, String AutherID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "UPDATE ENROLLMENT SET BookID = ?, CourseID = ?, Price = ? WHERE AutherID = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getBookID());
            pstmt.setString(2, obj.getCourseID());
            pstmt.setString(3, obj.getPrice());
            pstmt.setString(4, AutherID);

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
    public static boolean delete(String AutherID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String qDelete = "DELETE FROM ENROLLMENTS WHERE AutherID=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setString(1, AutherID);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Enrollment by AutherID
    public static Enrollment getByAutherID(String AutherID) {
        Enrollment enrollment = null;
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM ENROLLMENT WHERE AutherID=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, AutherID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                enrollment = new Enrollment();
                enrollment.setAutherID(rs.getString("AutherID"));
                enrollment.setBookID(rs.getString("BookID"));
                enrollment.setCourseID(rs.getString("CourseID"));
                enrollment.setPrice(rs.getString("Price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return enrollment;
    }
    

    // Enrollment by AutherID
    public static Enrollment getByBookID(String BookID) {
        Enrollment enrollment = null;
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM ENROLLMENT WHERE BookID=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, BookID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                enrollment = new Enrollment();
                enrollment.setAutherID(rs.getString("AutherID"));
                enrollment.setBookID(rs.getString("BookID"));
                enrollment.setCourseID(rs.getString("CourseID"));
                enrollment.setPrice(rs.getString("Price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return enrollment;
    }

    public static List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM ENROLLMENT";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setAutherID(rs.getString("AutherID"));
                enrollment.setBookID(rs.getString("BookID"));
                enrollment.setCourseID(rs.getString("CourseID"));
                enrollment.setPrice(rs.getString("Price"));
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return enrollments;
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
