package Lab5_Callables;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

@SuppressWarnings("serial")
public class Salesman extends Dialog implements Callable<Sale> {
	private String name;
	private int numberOfSales;
	private static final int MAX_VALUE = 1000;
	private static final int VALUE_INCREMENT = 100;
	private volatile boolean finished = false;

	public Salesman(Frame parent, String name) {
		super(parent);
		this.name = name;
		setTitle(name);
		setLayout(new FlowLayout());
		Button ok = new Button("Confirm");
		add(ok);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				finished = true;
			}
		});
	}

	@Override
	public Sale call() throws Exception {
		setSize(60,80);
		setLocation((int) (800 * Math.random()),(int) (500 * Math.random()));
		setVisible(true);
		while (!finished) Thread.yield();
		Sale sale = new Sale(name,
				((int) Math.random() * (MAX_VALUE / VALUE_INCREMENT))
						* VALUE_INCREMENT);
		numberOfSales++;
		return sale;
	}

	public int getNumberOfSales() {
		return numberOfSales;
	}

}
