package Lab4_Executor_Transfer;

import Lab2_Thread_Safety.Account;
import java.util.concurrent.Future;

public class TransferRunnable implements Runnable {

	private Account account1;
	private Account account2;
	private double amount;
	private volatile boolean running = true;
	private Future<?> future;

	public TransferRunnable(Account anAccount1, Account anAccount2, double anAmount) {
		this.amount = anAmount;
		this.account1 = anAccount1;
		this.account2 = anAccount2;
	}

    TransferRunnable(Lab4_Executor_Transfer.Account account1, Lab4_Executor_Transfer.Account account2, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public void run() {
		int delay = (int) (Math.random() * 1000);
		
		Account first = account1.hashCode() < account2.hashCode() ? account1 : account2;
		Account second = account1.hashCode() >= account2.hashCode() ? account1 : account2;
		
		while (running) {
			synchronized (first) {
				synchronized (second) {
					boolean withdrawOK = account1.withdraw(amount);
					if (withdrawOK) {
						account2.deposit(amount);
					}
					try {
						Thread.sleep(0, delay);
					} catch (InterruptedException e) {}
				}
			}
		}
		synchronized (this) { notifyAll(); }
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public Future<?> getFuture() {
		return future;
	}

	public void setFuture(Future<?> future) {
		this.future = future;
	}
}
