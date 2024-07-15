package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.StudentDBConnection;
import model.Student;

public class StudentDAO {

	   static PreparedStatement pstmt = null;
	    static Connection conn = null;
	    static Statement stmt = null;
	    static ResultSet rs = null;

	    // Insert method handles auto-increment
	    public static boolean insert(Student obj) {
	        boolean f = false;
	        try {
	            conn = StudentDBConnection.createC();

	            String q = "INSERT INTO STUDENT(StudentID, FirstName, LastName, DateOfBirth, Gender, Email, Phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

	            pstmt.setString(1, obj.getStudentID());
	            pstmt.setString(2, obj.getFirstName());
	            pstmt.setString(3, obj.getLastName());
	            pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(obj.getDateOfBirth()));
	            pstmt.setString(5, obj.getGender());
	            pstmt.setString(6, obj.getEmail());
	            pstmt.setString(7, obj.getPhone());

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

	    // Update Student
	    public static boolean update(Student obj, String studentID) {
	        boolean f = false;
	        try {
	            conn = StudentDBConnection.createC();

	            String q = "UPDATE STUDENT SET FirstName = ?,  LastName = ?,  DateOfBirth = ?, Gender = ?, Email = ?, Phone = ? WHERE StudentID = ?";
	            pstmt = conn.prepareStatement(q);

	            pstmt.setString(1, obj.getFirstName());
	            pstmt.setString(2, obj.getLastName());
	            pstmt.setDate(3, new java.sql.Date(obj.getDateOfBirth().getTime())); // Converting Date to SQL Date
	            pstmt.setString(4, obj.getGender());
	            pstmt.setString(5, obj.getEmail());
	            pstmt.setString(6, obj.getPhone());
	            pstmt.setString(7, studentID);

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
	    public static boolean delete(String studentID) {
	        boolean f = false;
	        try {
	            conn = StudentDBConnection.createC();

	            String qDelete = "DELETE FROM STUDENT WHERE StudentID=?";
	            pstmt = conn.prepareStatement(qDelete);
	            pstmt.setString(1, studentID);
	            
	            pstmt.executeUpdate();
	            f = true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return f;
	    }


	    // Student by StudentID
	    public static Student getByStudentID(String studentID) {
	        Student student = null;
	        try {
	            conn = StudentDBConnection.createC();

	            String q = "SELECT * FROM STUDENT WHERE StudentID=?";
	            pstmt = conn.prepareStatement(q);

	            pstmt.setString(1, studentID);

	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                student = new Student();
	                student.setStudentID(rs.getString("StudentID"));
	                student.setFirstName(rs.getString("FirstName"));
	                student.setLastName(rs.getString("LastName"));
	                student.setDateOfBirth(rs.getDate("DateOfBirth"));
	                student.setGender(rs.getString("Gender"));
	                student.setEmail(rs.getString("Email"));
	                student.setPhone(rs.getString("Phone"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return student;
	    }

	    public static List<Student> getAllStudents() {
	        List<Student> students = new ArrayList<>();
	        try {
	            conn = StudentDBConnection.createC();

	            String q = "SELECT * FROM STUDENT";
	            stmt = conn.createStatement();

	            rs = stmt.executeQuery(q);

	            while (rs.next()) {
	                Student student = new Student();
	                student.setStudentID(rs.getString("StudentID"));
	                student.setFirstName(rs.getString("FirstName"));
	                student.setLastName(rs.getString("LastName"));
	                student.setDateOfBirth(rs.getDate("DateOfBirth"));
	                student.setGender(rs.getString("Gender"));
	                student.setEmail(rs.getString("Email"));
	                student.setPhone(rs.getString("Phone"));
	                students.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	        return students;
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
