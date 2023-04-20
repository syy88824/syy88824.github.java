import java.util.ArrayList;

public class Student {
	private int courseID;
	private int courseCredits;
	private int studentID;
	private String studentName;
	private ArrayList<Course> enrolledCourses;
	private int currentCredits;
	private int maxCredits;
	
	public Student(int studentID,String name) {
		this.studentID=studentID;
		this.studentName=name;
		currentCredits=0;
		maxCredits=25;
		enrolledCourses=new ArrayList<Course>();
	}
	public Student(int studentID1,String name1,int maxCredits) {
		this.studentID=studentID1;
		this.studentName=name1;		
		this.maxCredits=maxCredits;
		this.currentCredits=0;
		this.enrolledCourses=new ArrayList<Course>();
	}
	public Course getCourse(int courseID) {
		Course value = null;
		//Course course = null;
		for(Course info : enrolledCourses) {
			if(info.getCourseID() == courseID) {
				value = info;
				break;
			}
		}
		return value;
	}
	public void enroll(Course course) {
		int courseCredits=course.getCredits();
		courseID=course.getCourseID();
		if(course.isFull()==true) {
			System.out.println("Course "+courseID+" is full");
		}else {
			if(currentCredits+courseCredits>maxCredits) {
				System.out.println("Student "+studentID+" cannot enroll in this course");
			}else {
				enrolledCourses.add(course);
				course.enroll();
				currentCredits+=courseCredits;
			}
		}
	}
	public void drop(int courseID) {
		Course course=getCourse(courseID);
		if (course!=null) {				
			courseCredits=course.getCredits();
			course.drop();
			currentCredits-=courseCredits;
			enrolledCourses.remove(course);
		}else {
			System.out.println("Course "+courseID+" not found in student "+studentID);
		}
	}
	public void drop(Course course) {
		int ID=course.getCourseID();
		drop(ID);
	}
	public String getInfo() {
		String info = "";
		for(Course inform: enrolledCourses) {
			info+=inform;
		}
		return "Student ID: "+studentID+"\nName: "+studentName+"\nCredits: "+currentCredits+"/"+maxCredits+"\nCourse list: \n"+info;		
	}
}
