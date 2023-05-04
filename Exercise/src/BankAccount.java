
public class BankAccount {
	private int ID;
	private double balance;
	private double interestRate;
	private double commissionFee;
	public BankAccount(int ID) {
		this.ID = ID;
		this.balance = 0;
		this.interestRate = 0.01;
		this.commissionFee = 10;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public void setCommissionFee(double commissionFee) {
		this.commissionFee = commissionFee;
	}
	public int getID() {
		return ID;
	}
	public double getBalance() {
		return balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public double getCommissionFee() {
		return commissionFee;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public boolean withdraw(double amount) {
		boolean result = false;
		if (balance>=amount) {
			balance -= amount;
			result = true;
		}else {
			System.out.println("No money");
		}
		return result;
	}
	public void transfer(double amount, BankAccount receivedAccount) {
		if (withdraw(amount) == true) {
			withdraw(amount);
			receivedAccount.deposit(amount);
		}else {
			System.out.println("交易失敗(transfer)");
		}
	}
	public void convert(double amount, BankAccount receivedAccount, double exchangeRate) {
		if(withdraw(amount)) {
			receivedAccount.deposit(amount/exchangeRate);
		}else {
			System.out.println("交易失敗(convert)");
		}
	}
	public void yearEnd() {
		balance += balance*interestRate;
	}
	public String getInfo() {
		return "ID："+ID+" balance："+balance;
	}
}
