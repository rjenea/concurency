
package concurrency05_Example_Thread_InnerClass;

import static java.lang.Thread.sleep;

class ThreadRunner {
    public static void main(String[] args) {
	Thread t1 = new Thread() { 
                        public void run(){ 
 			
                        try { for (;;) {
                            System.out.println("Ping");
                            sleep(100);
                                }
                            } catch (InterruptedException e) {return;}
			} 
		}; 
        t1.start(); 
	
        Thread t2 = new Thread() { 
                        public void run(){ 
 			
                        try { for (;;) {
                            System.out.println("Pong");
                            sleep(100);
                                }
                            } catch (InterruptedException e) {return;}
			} 
		}; 
        t2.start(); 
	}
}

