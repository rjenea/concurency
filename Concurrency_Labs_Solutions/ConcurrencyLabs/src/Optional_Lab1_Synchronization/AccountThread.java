package Optional_Lab1_Synchronization;

// Added in Exercise 1  (enhanced in Exercise 2)
public class AccountThread extends Thread
{

    private Account account;
    private double amount;

    public AccountThread(Account anAccount, double anAmount)
    {
        this.amount = anAmount;
        this.account = anAccount;
    }

    public void run()
    {
      	boolean withdrawOK = false;
       	while (!withdrawOK)
       	{
       		synchronized (account)
       		{
              		withdrawOK = account.withdraw(amount);
               		if (!withdrawOK)
              		{
               			try {account.wait();} catch (InterruptedException e) {}
               		}
       		}
       	}
     }
}
