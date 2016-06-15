
package concurrency09_Example_Join_1;

class SimpleThread2 extends Thread {
	public SimpleThread2(String str) {
		super(str);
		}
        public void run() {
			try {
				sleep(1000); // sleep for a 2 seconds                                    
			} catch (InterruptedException e) {}                    
            try { 
                System.out.println("Thread type 2 About to issue join");
                join();                         
            } catch (InterruptedException ex) { }
	}
}
