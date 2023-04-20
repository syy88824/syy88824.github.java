import java.util.ArrayList;

public class OvertimeAnalyzer implements Analyzer {
	private ArrayList <Employee> employees = new ArrayList <Employee>();
	
	@Override
	public void addE(ArrayList employees) {
		// TODO Auto-generated method stub
		this.employees = employees;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int i = 0;
		for(Employee employee:employees) {
			if(employee.getOverWork() > 0) {
				i++;
			}
		}
		return i;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		int value2 = 0;
		for(Employee employee:employees) {
			value2 += employee.getOverWork();
		}
		return value2;
	}

	@Override
	public double avg() {
		// TODO Auto-generated method stub
		return (sum()*1.0/count());
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		int maximum2 = employees.get(0).getOverWork();
		for(Employee employee:employees) {
			if(employee.getOverWork() > maximum2) {
				maximum2 = employee.getOverWork();
			}
		}
		return maximum2;
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s\n", "<Over Work info>");
		System.out.printf("%20s%10d\n", "Employees:",count());
		System.out.printf("%20s%10d\n", "Total hours:",sum());
		System.out.printf("%20s%10.2f\n", "Average hours:",avg());
		System.out.printf("%20s%10d\n", "Max hours:",max());
	}

}
