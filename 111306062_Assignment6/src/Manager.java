
public class Manager extends Employee {
	public Manager(String name, int wage, String position, float bonusRate) {
		super(name, wage, position);
		// TODO Auto-generated constructor stub
		this.bonusRate = bonusRate;
	}
	private double bonusRate;
	public int payment() {
		long pay = Math.round(super.payment()*bonusRate);
		int payy = (int)pay;
		return payy;
	}
}
