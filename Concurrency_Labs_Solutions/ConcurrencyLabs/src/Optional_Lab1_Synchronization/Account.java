package Optional_Lab1_Synchronization;

import java.awt.*;
// No changes required
public class Account
{
    private double balance;
    private TextField t;
    private static final int RATIO = 100;

    public Account(double amount, TextField t)
    {
        balance = amount;
        this.t = t;
    }

    public boolean withdraw(double amount)
    {
        boolean result = false;
        if (amount <= balance)
        {
            balance -= amount;
            result = true;
            t.setText(moneyToString(balance));
        }
        else
        {
            t.setText("Too much, try again");
        }

        return result;
    }

    public void deposit(double amount)
    {
        balance += amount;
        t.setText(moneyToString(balance));
    }

    public static String moneyToString(double money)
    {
        int pence = (int) (money * RATIO);
        int pounds = pence/RATIO;
        pence %= RATIO;
        String s = pounds + ".";
        if (pence < 10)
        {
          s = s + "0" + pence;
        }
        else
        {
          s = s + pence;
        }
        return s;
    }


}