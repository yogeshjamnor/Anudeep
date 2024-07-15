package model;

public class Course {
	private String courseID;
    private String courseTitle;
    private int credits;

    // Constructor
    public Course(String courseID, String courseTitle, int credits) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.credits = credits;
    }

    public Course() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", credits=" + credits +
                '}';
    }

}
