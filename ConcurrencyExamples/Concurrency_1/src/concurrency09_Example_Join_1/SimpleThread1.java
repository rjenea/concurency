
package concurrency09_Example_Join_1;

class SimpleThread1 extends Thread {
	public SimpleThread1(String str) {
		super(str);
		}
        public void run() {
			try {
				sleep(5000); // sleep for a long time
			} catch (InterruptedException e) {}
		
	System.out.println("Thread type 1 ending");
        
	}
}
