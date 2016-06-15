package Lab2_Thread_Safety;

public class TransferThread extends Thread {

	private Account account1;
	private Account account2;
	private double amount;
	private volatile boolean running = true;

	public TransferThread(Account anAccount1, Account anAccount2, double anAmount) {
		this.amount = anAmount;
		this.account1 = anAccount1;
		this.account2 = anAccount2;
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
}
