package Lab4_Executor_Transfer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Bank {
	private Account account1, account2;
	private static final double credit = 100000.0;
	private static final int numberOfThreads = 100;
	private TransferRunnable[] threads;
	private BankUpdater updater;
	private ExecutorService exec;

	public Bank(BankUpdater gui) {
		this.updater = gui;
		account1 = new Account(credit);
		account2 = new Account(credit);
		exec = Executors.newFixedThreadPool(30);
		gui.refreshAccount(1, account1);
		gui.refreshAccount(2, account2);
		gui.output("Accounts initialised");
	}

	public void startThreads() {
		threads = new TransferRunnable[numberOfThreads];
		for (int i = 0; i < threads.length; i++) {
			if (i % 2 == 0) {
				threads[i] = new TransferRunnable(account1, account2, 100.0);
			} else {
				threads[i] = new TransferRunnable(account2, account1, 100.0);
			}
		}
		for (TransferRunnable at : threads) {
			Future<?> results =  exec.submit(at);
			at.setFuture(results);
		}
	}

	public void stopThreads() {
		new Thread() {
			@Override
			public void run() {
				for (TransferRunnable at : threads) {
					at.setRunning(false);
				}
				for (TransferRunnable at : threads) {
					synchronized (at) {
						while (at.getFuture().isDone()) {
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
