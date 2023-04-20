public class Grading {
	private int passMark;
	Student stu = new Student("d");
	public Grading(int passMark){
		this.passMark=passMark;
	}		
	public String toLetterGrade(int score){
		String lettergrade = null;
		if (score<=100&&score>=80) {
			lettergrade="A ";
		}
		else if (score<=79&&score>=70) {
			lettergrade="B ";
		}
		else if (score<=69&&score>=60) {
			lettergrade="C ";
		}
		else if (score<=59&&score>=50) {
			lettergrade="D ";
		}
		else if (score<=49&&score>=1) {
			lettergrade="E ";
		}else {
			lettergrade="X ";
		}
		return lettergrade;
		}
	public String calculateAvg(int[] grades) {
		double total=0;
		for(int grade:grades) {
			total += grade;
		}
		String ave = String.format("%.2f", (total/grades.length)); //取成績的平均值到小數點後第二位
		return ave;
	}
	public String summarizeGrade(int[] grades) {
		int pass = 0;
		int fail = 0;
		for (int grade:grades) {
			if (grade>=passMark) { //當成績大於passmark時，pass多1(多1科pass)
				pass+=1;
			}else { //當成績小於passmark時，fail多1(多1科fail)
				fail+=1;
			}	
		}
		String gradeletter = toLetterGrade(grades[0]) ;
		for (int gradesIndex=1;gradesIndex<5;gradesIndex++) {
			gradeletter += toLetterGrade(grades[gradesIndex]); //gradeletter可以字串形式(非陣列形式)儲存grades轉成的所有英文階級使其能return
		}
		return "Avg. Score: "+calculateAvg(grades)+"\nPass: "+pass+", Failed: "+fail+"\nAll Grades Letter: "+gradeletter;
	}
}
