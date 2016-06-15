package Lab5_Callables;

import java.awt.Frame;
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
		System.exit(0);
	}
	
	public void begin() {
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		List<Future<Sale>> selling = new ArrayList<Future<Sale>>();
		for (int i=0; i<10; i++) {
			Salesman salesman = new Salesman(this, "Salesman" + i);
			Future<Sale> futureSale = pool.submit(salesman);
			selling.add(futureSale);
		}
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {}
		
		
		for (Future<Sale> f : selling) {
			try {
				if (f.isDone())
					System.out.println(f.get());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		pool.shutdown();
		dispose();
		
		
	}

}
