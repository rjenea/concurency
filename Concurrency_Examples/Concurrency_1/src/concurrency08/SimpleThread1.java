/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency08;

/**
 *
 * @author Administrator
 */
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
