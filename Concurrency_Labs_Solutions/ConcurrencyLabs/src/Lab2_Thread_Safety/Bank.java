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
		for (int i = 0; i < threads.length; i++) {
			if (i % 2 == 0) {
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
		new Thread() {
			@Override
			public void run() {
				for (TransferThread at : threads) {
					at.setRunning(false);
				}
				for (TransferThread at : threads) {
					synchronized (at) {
						while (at.isAlive()) {
							try {at.wait();} catch (InterruptedException e) {}
						}
					}
				}
				Account first = account1.hashCode() < account2.hashCode() ? account1 : account2;
				Account second = account1.hashCode() >= account2.hashCode() ? account1 : account2;
				synchronized (first) {
					synchronized (second) {
						updater.output("Finished");
						updater.refreshAccount(1, account1);
						updater.refreshAccount(2, account2);
					}
				}
			}
		}.start();
	}

}
