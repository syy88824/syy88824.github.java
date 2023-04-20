
public class Employee {
	private String name;
	private int wage;
	private int workDay;
	private int overWork;
	private String position;
	public Employee(String name, int wage, String position) {
		this.name = name;
		this.wage = wage;
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public void setWorkDay() {
		workDay++;
	}
	public void setOverWork(int workHour) {
		if (workHour > 8) {
			this.overWork += workHour-8;
		}
	}
	public String getName() {
		return name;
	}
	public int getWorkDay() {
		return workDay;
	}
	public int getOverWork() {
		return overWork;
	}
	public int payment() {
		double val = Math.floor(wage*workDay+wage/8*1.5*getOverWork());
		int value = (int)val;
		return value;
	}
}
