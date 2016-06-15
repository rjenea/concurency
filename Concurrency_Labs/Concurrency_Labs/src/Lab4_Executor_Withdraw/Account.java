package Lab4_Executor_Withdraw;


public class Account {
	private double balance;
	private static final int RATIO = 100;

	public Account(double amount) {
		balance = amount;
	}

	public boolean withdraw(double amount) {
		boolean result = false;
		if (amount <= balance) {
			balance -= amount;
			result = true;
		} 
		return result;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public double getBalance() {
		return balance;
	}

	public static String moneyToString(double money) {
		int pence = (int) (money * RATIO);
		int pounds = pence / RATIO;
		pence %= RATIO;
		String s = pounds + ".";
		if (pence < 10) {
			s = s + "0" + pence;
		} else {
			s = s + pence;
		}
		return s;
	}

}