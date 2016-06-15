package Lab1_Withdraw;

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
		account.deposit(amount);
		updater.updateAccount(Account.moneyToString(account.getBalance()));
	}

	public void withdraw(String amountString) {
		double amount = getAmountFromString(amountString);
		boolean success = account.withdraw(amount);
		if (!success) {
			updater.update("Account doesn't have " + amountString);
		}
		updater.updateAccount(Account.moneyToString(account.getBalance()));
	}




}
