package Lab4_Executor_Withdraw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank {
	private Account account;
	private BankUpdater updater;
	private final double credit = 257.23;
	private final double defaultAmount = 100.0;
	private ExecutorService exec;
	
	public Bank(BankUpdater updater) {
		this.updater = updater;
		account = new Account(credit);
		updater.updateAccount(Account.moneyToString(account.getBalance()));
		exec = Executors.newSingleThreadExecutor();
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
		final double amount = getAmountFromString(amountString);
		exec.submit(new Runnable() {
			@Override
			public void run() {
				synchronized (account) {
					account.deposit(amount);
					account.notifyAll();			
				}
				updater.updateAccount(Account.moneyToString(account.getBalance()));				
			}
		});

	}

	public void withdraw(String amountString) {
		double amount = getAmountFromString(amountString);
		WithdrawRunnable r = new WithdrawRunnable(account, amount, updater);
		exec.submit(r);
	}




}
