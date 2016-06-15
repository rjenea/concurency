package Lab8_ThreadPools;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Bank extends Applet
{
    private Account account;
    private TextField balanceField, amountField;
    private final double credit = 257.23;
    private final double defaultAmount = 100.0;
    private ThreadQueue pool;

    public void init()
    {
        balanceField = new TextField(Account.moneyToString(credit),12);
        amountField = new TextField(Account.moneyToString(defaultAmount),10);

        account = new Account(credit,balanceField);

        pool = new ThreadQueue(3);

        Button depositButton1 = new Button("Deposit");
        Button depositButton2 = new Button("Deposit");

        Button withdrawButton1 = new Button("Withdraw");
        Button withdrawButton2 = new Button("Withdraw");

        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        p1.add(balanceField);

        p2.add(depositButton1);
        p2.add(depositButton2);

        p2.add(withdrawButton1);
        p2.add(withdrawButton2);

        p3.add(amountField);
        setLayout(new GridLayout(3,1,10,10));
        add(p1);
        add(p2);
        add(p3);
        depositButton1.addActionListener(new ActionListener()
                              {
                                  public void actionPerformed(ActionEvent evt)
                                  {
                                      /*
                                      // Removed
                                      Thread w = new AccountThread(account, getAmount(), "Deposit");
                                      w.start();
                                      */

                                      // Added in Exercise 3 - Thread pools
                                      Runnable r = makeRunnable("Deposit");

                                      pool.execute(r);

                                    }
                               });

        depositButton2.addActionListener(new ActionListener()
                              {
                                  public void actionPerformed(ActionEvent evt)
                                  {
                                      /*
                                      Thread w = new AccountThread(account, getAmount(), "Deposit");
                                      w.start();
                                      */
                                      Runnable r = makeRunnable("Deposit");

                                      pool.execute(r);

                                  }
                               });


        withdrawButton1.addActionListener(new ActionListener()
                                {
                                  public void actionPerformed(ActionEvent evt)
                                  {
                                      /*
                                      Thread w = new AccountThread(account, getAmount(), "Withdraw");
                                      w.start();
                                      */
                                      Runnable r = makeRunnable("Withdraw");

                                      pool.execute(r);
                                  }
                               });

        withdrawButton2.addActionListener(new ActionListener()
                                {
                                  public void actionPerformed(ActionEvent evt)
                                  {
                                       /*
                                      Thread w = new AccountThread(account, getAmount(), "Withdraw");
                                      w.start();
                                      */
                                      Runnable r = makeRunnable("Withdraw");

                                      pool.execute(r);
                                   }
                               });



    }

  private double getAmount()
  {
    String strAmount = amountField.getText();
    double amount = 0.0;
    try
    {
      amount = Double.parseDouble(strAmount);
    } catch (Exception e)
    {
      amount = 0.0;
      amountField.setText(Account.moneyToString(defaultAmount));
    }
    return amount;
  }

  // Added in Exercise 3 - Thread pools

  private Runnable makeRunnable(final String type)
  {
      return new Runnable()
                {
	            public void run()
                    {
			try
			{
                          if (type.equals("Withdraw"))
                          {
                            account.withdraw(getAmount());
                          }
                          else
                          {
                            account.deposit(getAmount());
                          }
			}
			catch ( Exception x )
			{
				// x.printStackTrace();
			}
		    }

		};
	}


}

