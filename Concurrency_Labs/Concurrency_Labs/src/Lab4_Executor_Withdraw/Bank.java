package Lab4_Executor_Withdraw;

public class Bank {
	private Account account;
	private BankUpdater updater;
	private final double credit = 257.23;
	private final double defaultAmount = 100.0;
	
	public Bank(BankUpdater updater) {
		this.updater = updater;
		account = new Account(credit);
		updater.updateAccount(Account.moneyToString(account.getBalance()));
	}
	
	private double getAmountFromString(String amountString) {
		try {
			return Double.parseDouble(amountString);
		} catch (Exception e) {
			updater.update(e.getMessage());
			return 0.0;
		}
	}
	
	public double getDefaultAmount() {
		return defaultAmount;
	}

	public void deposit(String amountString) {
		double amount = getAmountFromString(amountString);
		synchronized (account) {
			account.deposit(amount);
			account.notifyAll();			
		}
		updater.updateAccount(Account.moneyToString(account.getBalance()));
	}

	public void withdraw(String amountString) {
		double amount = getAmountFromString(amountString);
		WithdrawRunnable r = new WithdrawRunnable(account, amount, updater);
		Thread t = new Thread(r);
		t.start();
	}




}
