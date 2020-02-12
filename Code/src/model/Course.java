package model;

public class Course {

	private String subject;
	private String teacherName;
	private String nrc;
	private String credits;
	private String studentsAmount;

	public Course(String subject, String teacherName, String nrc, String credits, String studentsAmount) {
		super();
		this.subject = subject;
		this.teacherName = teacherName;
		this.nrc = nrc;
		this.setCredits(credits);
		this.setStudentsAmount(studentsAmount);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getnrc() {
		return nrc;
	}

	public void setnrc(String nrc) {
		this.nrc = nrc;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}
	
	public int getCreditsInt() {
		return Integer.parseInt(credits);
	}
	public String getStudentsAmount() {
		return studentsAmount;
	}


	public void setStudentsAmount(String studentsAmount) {
		this.studentsAmount = studentsAmount;
	}
}