
public class TaiCurrAccount extends BankAccount {
	private int transCount;
	private int freeTimes;
	public TaiCurrAccount(int ID) {
		super(ID);
		transCount = 0;
		freeTimes = 3;
		// TODO Auto-generated constructor stub
	}
	public void deposit(double amount) {		
		if (freeTimes < transCount) {
			amount -= getCommissionFee();
		}	
		super.deposit(amount);
		transCount++;
	}
	public boolean withdraw(double amount) {
		if (freeTimes < transCount) {
			amount += getCommissionFee();
		}	
		super.withdraw(amount);
		transCount++;
	}
}
