package Lab2_Thread_Safety;

public class TransferThread extends Thread {

	private Account account1;
	private Account account2;
	private double amount;
	private boolean running = true;

	public TransferThread(Account anAccount1, Account anAccount2, double anAmount) {
		this.amount = anAmount;
		this.account1 = anAccount1;
		this.account2 = anAccount2;
	}

	public void run() {
		int delay = (int) (Math.random() * 1000);

		while (running) {
			boolean withdrawOK = account1.withdraw(amount);
			if (withdrawOK) {
				account2.deposit(amount);
			}
			try {
				Thread.sleep(0, delay);
			} catch (InterruptedException e) {
			}
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
