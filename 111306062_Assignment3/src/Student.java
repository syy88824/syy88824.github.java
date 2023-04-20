public class Student {
	private String name;
	private int[] grades = new int[5];
	private int gradesIndex;
	
	public Student(String name) {
		this.name=name;
	}
	public int getGrade(int gradesIndex) {
		return grades[gradesIndex];
	}
	public int[] getGrades() {
		return grades;
	}
	public void addGrade(int grade) {					
		if(grades[4]!=0 || grade==0) { //若grades中最後一項不為零(陣列的成績都輸入進去了)或輸入成績為零，輸入數字不會進入陣列中
			System.out.print("Array index out of bounds.");
		}else { //若輸入成績是合適的，可進入陣列中
			grades[gradesIndex]=grade;
			gradesIndex+=1; //下個輸入的成績不會取代此成績
		}
	}
	public String info() {
		String gradenum = String.valueOf(grades[0]) ;
		for (gradesIndex=1;gradesIndex<5;gradesIndex++) {
			gradenum += " "+grades[gradesIndex]; //gradenum可以字串形式(非陣列形式)儲存grades中所有元素使其能return
		}
		return "Name: "+name+"\nGrades: "+gradenum;
	}
}
