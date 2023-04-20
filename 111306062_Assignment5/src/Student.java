
public class Student extends Person {
	private String major;
	private String tutorName;
	private int enrolledYear;
	private double grade;
	public Student(int ID, String name, String major, int enrolledYear, String tutorName, double grade) {
		super(ID, name);
		this.enrolledYear = enrolledYear;
		this.tutorName = tutorName;
		this.major = major;
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public int getEnrolledYear() {
		return enrolledYear;
	}
	public void setEnrolledYear(int enrolledYear) {
		this.enrolledYear = enrolledYear;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getInfo() {
		String dGrade = String.format("%.2f", grade);
		return "Student[ID="+getID()+", name="+getName()+", major="+major+", enrolledYear="+enrolledYear+", grade="+dGrade+"]";
	}
}
