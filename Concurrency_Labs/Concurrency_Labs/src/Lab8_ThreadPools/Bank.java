package Lab8_ThreadPools;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// Change to use Runnable objects and a thread pool
public class Bank extends Applet
{
    private Account account;
    private TextField balanceField, amountField;
    private final double credit = 257.23;
    private final double defaultAmount = 100.0;

    //** TO DO
    // Create a reference to the ThreadQueue object

    public void init()
    {
        balanceField = new TextField(Account.moneyToString(credit),12);
        amountField = new TextField(Account.moneyToString(defaultAmount),10);

        account = new Account(credit,balanceField);

        //** TO DO
        // Create the ThreadQueue of size 3

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
                                      //** TO DO
                                      // Remove these two statements
                                      Thread w = new AccountThread(account, getAmount(), "Deposit");
                                      w.start();

                                      //** TO DO
                                      // Use the returned Runnable object from makeRunnable()
                                      // as argument to the pool's execute method
                                    }
                               });

        depositButton2.addActionListener(new ActionListener()
                              {
                                  public void actionPerformed(ActionEvent evt)
                                  {
                                     //** TO DO
                                      // Remove these two statements
                                      Thread w = new AccountThread(account, getAmount(), "Deposit");
                                      w.start();

                                      //** TO DO - see above
                                   }
                               });


        withdrawButton1.addActionListener(new ActionListener()
                                {
                                  public void actionPerformed(ActionEvent evt)
                                  {

                                      //** TO DO
                                      // Remove these two statements
                                      Thread w = new AccountThread(account, getAmount(), "Withdraw");
                                      w.start();

                                      //** TO DO - see above (use "Withdraw")
                                  }
                               });

        withdrawButton2.addActionListener(new ActionListener()
                                {
                                  public void actionPerformed(ActionEvent evt)
                                  {
                                      //** TO DO
                                      // Remove these two statements
                                      Thread w = new AccountThread(account, getAmount(), "Withdraw");
                                      w.start();

                                      //** TO DO - see above (use "Withdraw")
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

  // ** TO DO
  // Implement the private makeRunnable() method
  //
  // takes a single final String to indicate type of Runnable
  //    - Withdraw or Deposit
  //
      // return new Runnable using an anonymous class
                //
	            // implement run() method
                    //
			// try
			//
                          // if type is Withdraw
                          //
                            // invoke account.withdraw(getAmount())
                          //
                          // else //assume "Deposit"
                          //
                            // invoke account.deposit(getAmount())
                          //
			//
			// catch block nothing fancy

		    //

		//
	//


}

