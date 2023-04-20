import java.util.Scanner;
public class Assignment6 {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		WageAnalyzer company1 = new WageAnalyzer();
		OvertimeAnalyzer company2 = new OvertimeAnalyzer();
		System.out.println("Input company employees information");
		String companyName = scan.next();
		Company company = new Company(companyName);
		int employeeNum = scan.nextInt();
		for (int i = 0; i < employeeNum; i++) {
			String position = scan.next();
			String employeeName = scan.next();
			int wagePerDay = scan.nextInt();
			if (position.equals("manager")) {
				float bonusRate = scan.nextFloat();
				Employee manager = new Manager(employeeName, wagePerDay, position, bonusRate);
				company.addE(manager);
			}else if(position.equals("staff")){
				Employee employee = new Employee(employeeName, wagePerDay, position);
				company.addE(employee);
			}
			
		}
		System.out.println("Input employees working data");
		int dataRound = scan.nextInt();
		for(int j = 0; j < dataRound; j++) {
			String name = scan.next();
			int workHour = scan.nextInt();
			company.addWork(name, workHour);
		}
		company.getInfo();
		company.callA();
	}

}
