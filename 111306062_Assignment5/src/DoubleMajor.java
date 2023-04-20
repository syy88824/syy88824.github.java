
public class DoubleMajor extends Student{
	private String major2;
	public DoubleMajor(int ID, String name, String major, int enrolledYear, String tutorName, double grade, String major2Name) {
		super(ID, name, major, enrolledYear, tutorName, grade);
		major2 = major2Name;
		// TODO Auto-generated constructor stub
	}
	public String getMajor2() {
		return major2;
	}
	public String getInfo() {
		String dGrade = String.format("%.2f", super.getGrade());
		return "DoubleMajor[ID="+getID()+", name="+getName()+", major="+getMajor()+", major2="+major2+", enrolledYear="+getEnrolledYear()+", grade="+dGrade+"]";
	}
}
