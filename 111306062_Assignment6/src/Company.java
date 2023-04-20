import java.util.ArrayList;

public class Company {
	private String name;
	private ArrayList <Employee> employees;
	public Company(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}
	public void addE(Employee employee) {
		employees.add(employee);
	}
	public void addWork(String name, int hour) {
		boolean result = false;		
		for(Employee employee:employees) {		
			if(employee.getName().equals(name)) {
				employee.setWorkDay();
				employee.setOverWork(hour);
				result = true;
			}
		}
		if(result == false) {
			System.out.println("The employee is not found.");
		}
	}
	public void callA() {
		Analyzer wageAna = new WageAnalyzer();
		Analyzer overtimeAna = new OvertimeAnalyzer();
		wageAna.addE(employees);
		overtimeAna.addE(employees);
		wageAna.getInfo();
		overtimeAna.getInfo();
	}
	public void getInfo() {
		System.out.println("<Company:"+name+">");
		System.out.printf("%10s%10s%10s%10s%10s\n", "Name","WorkDay","OverTime","Wage","Title");
		for (Employee employee:employees) {
			System.out.printf("%10s%10s%10s%10d%10s\n", employee.getName(),employee.getWorkDay(),employee.getOverWork(),employee.payment(),employee.getPosition());
		}
	}
}
