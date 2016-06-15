
package concurrency03_Example_Runnable_1;

import static java.lang.Thread.sleep;

public class ExampleRunnable implements Runnable {
	public void run(){
		for(int i = 0; i < 100; i++){
			System.out.println("i:" + i);
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {                   
                    }
		}
	}
}