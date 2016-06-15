package Lab4_Executor_Transfer;

public interface BankUpdater {
	public void refreshAccount(int accountNumber, Account account);
	public void output(String message);
}
