
package concurrency07_Example_Runnable_setName_setPriority_isDaemon;

// Note how the results of this can vary depending upon the scheduling of the thread...

public class ExampleRunnable implements Runnable {
	public void run(){
		System.out.println("Starting Thread....");
                System.out.println(Thread.currentThread());
		while(!Thread.interrupted()){ 
                    
                    System.out.println("....thread pretending to do something......");
			} 
                
		System.out.println("....Interrupt detected!"  );
	}
}
