public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student("Jack");
		Grading grading1 = new Grading(60);
		Grading grading2 = new Grading(80);
		int[] grades = stu1.getGrades();
		stu1.addGrade(100);
		stu1.addGrade(78);
		stu1.addGrade(55);
		stu1.addGrade(67);
		stu1.addGrade(98);
		stu1.addGrade(90);
		
		System.out.println("\nInformation");
		System.out.println(stu1.info());
		System.out.println("\ngrading1 summarizeGrade(...)");
		System.out.print(grading1.summarizeGrade(grades));
		System.out.println("\n\ngrading2 summarizeGrade(...)");
		System.out.print(grading2.summarizeGrade(grades));
	}

}
