package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.StudentDBConnection;
import model.Instructor;

public class InstructorDAO {
	static PreparedStatement pstmt = null;
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // Insert method handles auto-increment
    public static boolean insert(Instructor obj) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "INSERT INTO INSTRUCTOR(InstructorID, Email, FirstName, LastName) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getInstructorID());
            pstmt.setString(2, obj.getEmail());
            pstmt.setString(3, obj.getFirstName());
            pstmt.setString(4, obj.getLastName());

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

    // Update Instructor
    public static boolean update(Instructor obj, String instructorID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String q = "UPDATE INSTRUCTOR SET Email = ?, FirstName = ?, LastName = ? WHERE InstructorID = ?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getFirstName());
            pstmt.setString(3, obj.getLastName());
            pstmt.setString(4, instructorID);

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
    public static boolean delete(String instructorID) {
        boolean f = false;
        try {
            conn = StudentDBConnection.createC();

            String qDelete = "DELETE FROM INSTRUCTOR WHERE InstructorID=?";
            pstmt = conn.prepareStatement(qDelete);
            pstmt.setString(1, instructorID);

            pstmt.executeUpdate();
            f = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return f;
    }

    // Instructor by InstructorID
    public static Instructor getByInstructorID(String instructorID) {
        Instructor instructor = null;
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM INSTRUCTOR WHERE InstructorID=?";
            pstmt = conn.prepareStatement(q);

            pstmt.setString(1, instructorID);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                instructor = new Instructor();
                instructor.setInstructorID(rs.getString("InstructorID"));
                instructor.setEmail(rs.getString("Email"));
                instructor.setFirstName(rs.getString("FirstName"));
                instructor.setLastName(rs.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return instructor;
    }

    public static List<Instructor> getAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT * FROM INSTRUCTOR";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            while (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setInstructorID(rs.getString("InstructorID"));
                instructor.setEmail(rs.getString("Email"));
                instructor.setFirstName(rs.getString("FirstName"));
                instructor.setLastName(rs.getString("LastName"));
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return instructors;
    }
    
    public static List<Instructor> getAssignedCourse() {
        List<Instructor> instructors = new ArrayList<>();
        try {
            conn = StudentDBConnection.createC();

            String q = "SELECT c.CourseID, c.CourseTitle, c.Credits " +
                    "FROM Course c " +
                    "INNER JOIN Enrollment e ON c.CourseID = e.CourseID " +
                    "WHERE e.InstructorID = ?";
            stmt = conn.createStatement();

            rs = stmt.executeQuery(q);

            if (!rs.isBeforeFirst()) {
                System.out.println("No courses assigned to the instructor.");
            } else {
                System.out.println("Assigned Courses:");
                while (rs.next()) {
                    String courseID = rs.getString("CourseID");
                    String courseTitle = rs.getString("CourseTitle");
                    int credits = rs.getInt("Credits");
                    System.out.println("Course ID: " + courseID + ", Title: " + courseTitle + ", Credits: " + credits);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return instructors;
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
