package Lab1_Withdraw;

public class WithdrawThread extends Thread {

	private Account account;
	private double amount;
	private BankUpdater updater;

	public WithdrawThread(Account anAccount, double anAmount, BankUpdater updater) {
		this.amount = anAmount;
		this.account = anAccount;
		this.updater = updater;
	}

	@Override
	public void run() {
		boolean withdrawOK = false;
		while (!withdrawOK) {
			synchronized (account) {
				withdrawOK = account.withdraw(amount);
				if (!withdrawOK) {
					updater.update("Account doesn't have " + Account.moneyToString(amount) + ", try depositing...");
					try {
						account.wait();
					} catch (InterruptedException e) {
					}
				} else {
					updater.update("Yes it worked");
					updater.updateAccount(Account.moneyToString(account.getBalance()));
				}
			}
		}
	}
}
