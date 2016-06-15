package Lab6_Callables;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Salesman extends Dialog {
	private String name;
	private int numberOfSales;
	private static final int MAX_VALUE = 1000;
	private static final int VALUE_INCREMENT = 100;
	private boolean finished = false;
	private Sale sale;

	public Salesman(final Frame parent, final String name) {
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
				sale = new Sale(name,
						((int) Math.random() * (MAX_VALUE / VALUE_INCREMENT))
								* VALUE_INCREMENT);
				
				finished = true;
			}
		});
		setSize(60,80);
		setLocation((int) (800 * Math.random()),(int) (500 * Math.random()));
		setVisible(true);
	}
	
	public Sale getSale() {
		return sale;
	}


	public int getNumberOfSales() {
		return numberOfSales;
	}

}
