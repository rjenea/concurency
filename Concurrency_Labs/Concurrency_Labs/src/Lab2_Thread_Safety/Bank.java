package Lab2_Thread_Safety;


public class Bank {
	private Account account1, account2;
	private static final double credit = 100000.0;
	private static final int numberOfThreads = 100;
	private TransferThread[] threads;
	private BankUpdater updater;

	public Bank(BankUpdater gui) {
		this.updater = gui;
		account1 = new Account(credit);
		account2 = new Account(credit);
		gui.refreshAccount(1, account1);
		gui.refreshAccount(2, account2);
		gui.output("Accounts initialised");
	}
	
	public void startThreads() {
		threads = new TransferThread[numberOfThreads];
		for (int i=0; i<threads.length; i++) {
			if (i%2==0) {
				threads[i] = new TransferThread(account1, account2, 100.0);
			} else {
				threads[i] = new TransferThread(account2, account1, 100.0);
			}
		}
		for (TransferThread at : threads) {
			at.start();
		}
	}
	
	public void stopThreads() {
		for (TransferThread at : threads) {
			at.setRunning(false);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		updater.output("Finished");
		updater.refreshAccount(1, account1);
		updater.refreshAccount(2, account2);
	}

}
