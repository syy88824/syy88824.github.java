import java.util.ArrayList;

public class WageAnalyzer implements Analyzer {
	private ArrayList <Employee> employees = new ArrayList <Employee>();

	@Override
	public void addE(ArrayList employees) {
		// TODO Auto-generated method stub
		this.employees = employees;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return employees.size();
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		int value1 = 0;
		for (Employee employee:employees) {
			value1 += employee.payment();
		}
		return value1;
	}

	@Override
	public double avg() {
		// TODO Auto-generated method stub
		return sum()/count();
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		int maximum1 = employees.get(0).payment();
		for(Employee employee:employees) {
			if (employee.payment() > maximum1) {
				maximum1 = employee.payment();
			}
		}
		return maximum1;
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s\n", "<Wage info>");
		System.out.printf("%20s%10d\n", "Employees:",count());
		System.out.printf("%20s%10d\n", "Total payment:",sum());
		System.out.printf("%20s%10.2f\n", "Average payment:",avg());
		System.out.printf("%20s%10d\n", "Max payment:",max());
	}

}
