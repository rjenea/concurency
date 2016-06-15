package Lab8_ThreadPools;

public class AccountThread extends Thread
{

    private Account account;
    private double amount;
    String threadtype;

    // Added Type in Synch Exercise 2A
    public AccountThread(Account anAccount, double anAmount, String type)
    {
        this.amount = anAmount;
        this.account = anAccount;

        // Exercise 2A
	this.threadtype = type;
    }

    // Added if statement in Exercise 2B
    public void run()
    {
	if (threadtype.equals("Withdraw"))
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
	else
	{
       	    	synchronized (account)
       		{
              		account.deposit(amount);
                	try {account.wait();} catch (InterruptedException e) {}
            	}
        }
     }
}
