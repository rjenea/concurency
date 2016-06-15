package Lab6_Callables;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("serial")
public class SellingApp extends Frame {

	public static void main(String[] args) {
		SellingApp app = new SellingApp();
		app.setVisible(true);
		app.begin();
	}
	
	public void begin() {
		
		final List<Salesman> salesmen = new ArrayList<Salesman>();
		
		
		for (int i=0; i<10; i++) {
			Salesman s = new Salesman(this, "Salesman" + i);
			salesmen.add(s);
		}
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				for (Salesman s : salesmen) {
					System.out.println(s.getSale());
				}
				System.exit(0);
			}
		});
		
		
	}

}
