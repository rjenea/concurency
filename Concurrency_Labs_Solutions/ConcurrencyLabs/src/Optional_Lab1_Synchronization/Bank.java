package Optional_Lab1_Synchronization;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Bank extends Applet {
	private Account account;
	private TextField balanceField, amountField;
	private final double credit = 257.23;
	private final double defaultAmount = 100.0;

	public void init() {
		balanceField = new TextField(Account.moneyToString(credit), 12);
		amountField = new TextField(Account.moneyToString(defaultAmount), 10);

		account = new Account(credit, balanceField);
		Button depositButton1 = new Button("Deposit");

		Button withdrawButton1 = new Button("Withdraw");

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		p1.add(balanceField);
		p2.add(depositButton1);
		p2.add(withdrawButton1);
		p3.add(amountField);
		setLayout(new GridLayout(3, 1, 10, 10));
		add(p1);
		add(p2);
		add(p3);
		depositButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Added in Exercise 1 Part B
				synchronized (account) {
					account.deposit(getAmount());
					account.notifyAll();
				}
			}
		});

		withdrawButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Added in Exercise 1 Part A
				Thread w = new AccountThread(account, getAmount());
				w.start();
			}
		});

	}

	private double getAmount() {
		String strAmount = amountField.getText();
		double amount = 0.0;
		try {
			amount = Double.parseDouble(strAmount);
		} catch (Exception e) {
			amount = 0.0;
			amountField.setText(Account.moneyToString(defaultAmount));
		}
		return amount;
	}

}
