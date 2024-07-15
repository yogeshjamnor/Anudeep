package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.StudentDBConnection;
import model.Course;

public class CourseDAO {


    static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Course obj) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "INSERT INTO COURSE(CourseID, CourseTitle, Credits) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getCourseID());
            pstmt.setString(2, obj.getCourseTitle());
            pstmt.setInt(3, obj.getCredits());

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

    // Update Course
    public static boolean update(Course obj, String courseID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "UPDATE COURSE SET CourseTitle = ?,  Credits = ? WHERE CourseID = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getCourseTitle());
            pstmt.setInt(2, obj.getCredits());
            pstmt.setString(3, courseID);

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
    public static boolean delete(String courseID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String qDelete = "DELETE FROM COURSE WHERE CourseID=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setString(1, courseID);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Course by CourseID
    public static Course getByCourseID(String courseID) {
        Course course = null;
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM COURSE WHERE CourseID=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, courseID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                course = new Course();
                course.setCourseID(rs.getString("CourseID"));
                course.setCourseTitle(rs.getString("CourseTitle"));
                course.setCredits(rs.getInt("Credits"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return course;
    }

    public static List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM COURSE";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getString("CourseID"));
                course.setCourseTitle(rs.getString("CourseTitle"));
                course.setCredits(rs.getInt("Credits"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return courses;
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
