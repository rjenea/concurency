package Lab2_Thread_Safety;

public interface BankUpdater {
	public void refreshAccount(int accountNumber, Account account);
	public void output(String message);
}
