
public class Course {
	private int courseID;
	private String courseName;
	private int credits;
	private int capacity;
	private int enrolled;
	public Course(int id,String courseName,int credits,int capacity) {
		this.courseID=id;
		this.courseName=courseName;
		this.credits=credits;
		this.capacity=capacity;
		this.enrolled=0;
	}
	public String toString() {
		return courseID+" "+courseName+" "+credits;
	}
	public int getCourseID() {
		return courseID;
	}
	public int getCredits() {
		return credits;
	}
	public boolean isFull() {
		boolean value;
		if (capacity<=enrolled) {
			value=true;
		}else {
			value=false;
		}
		return value;
	}
	public void enroll() {
		enrolled+=1;
	}
	public void drop() {
		enrolled-=1;
	}
	public String getInfo(){
		return courseID+" "+courseName+" "+credits+" "+enrolled+"/"+capacity;
	}
}
