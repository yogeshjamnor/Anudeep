package model;

public class Feedback {
	private int feedbackID;
    private String studentID;
    private String BookName;
    private String feedback;

    // Constructor
    public Feedback(int feedbackID, String studentID, String BookName, String feedback) {
        this.feedbackID = feedbackID;
        this.studentID = studentID;
        this.BookName = BookName;
        this.feedback = feedback;
    }

    public Feedback() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID=" + feedbackID +
                ", studentID='" + studentID + '\'' +
                ", BookName='" + BookName + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }

}
