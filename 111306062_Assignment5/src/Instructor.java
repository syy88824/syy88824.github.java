import java.util.ArrayList;

public class Instructor extends Person {
	private String department;
	private ArrayList <String> lectureList = new ArrayList <String>();
	private ArrayList <Student> studentList = new ArrayList <Student>();
	public Instructor(int ID, String name, String department) {
		super(ID, name);
		this.department = department;
		// TODO Auto-generated constructor stub
	}
	public String getDepartment() {
		return department;
	}
	public ArrayList<String> getLectureList() {
		return lectureList;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void addLecture(String lectureName) {
		lectureList.add(lectureName);
	}
	public boolean addStudent(Student student) {
		if (student.getTutorName() == getName()) {
			studentList.add(student);
			return true;
		}else {
			return false;
		}
	}
	public String getStudentName() {
		String value = studentList.get(0).getName();
		for (int i = 1; i<studentList.size();i++) {
			value = value+","+studentList.get(i).getName();
		}
		return value;
	}
	public double getStudentAverage() {
		double scoreTotal = 0;
		for (Student studentScore:studentList) {
			scoreTotal += studentScore.getGrade();
		}
		return scoreTotal/studentList.size();
	}
	public String getInfo() {
		String lectureValue = lectureList.get(0);
		for (int i = 1;i<lectureList.size();i++) {
			lectureValue = lectureValue+","+lectureList.get(i);
		}
		String studentValue = studentList.get(0).getName();
		for (int i = 1;i<studentList.size();i++) {
			studentValue = studentValue+ ","+studentList.get(i).getName();
		}
		return "Instructor[ID="+getID()+",name="+getName()+",department="+getDepartment()+",lectureList="+lectureValue+",studentList="+studentValue+"]";				
	}
}
