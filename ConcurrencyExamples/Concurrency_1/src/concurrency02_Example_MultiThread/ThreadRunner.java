
package concurrency02_Example_MultiThread;

public class ThreadRunner  {
	public static void main (String[] args) {
		new SimpleThread("Hello").start();
		new SimpleThread("Goodbye").start();
                new SimpleThread("So long").start();
                new SimpleThread("Farewell").start();
              
                
	}
 }


