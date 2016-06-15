/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency08;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
class SimpleThread2 extends Thread {
	public SimpleThread2(String str) {
		super(str);
		}
        public void run() {
			try {
				sleep(1000); // sleep for a 2 seconds
                                
                                         
			} catch (InterruptedException e) {}
                        
            try { 
                //System.out.println("About to issue join");
                join(); 
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
	System.out.println("Thread type 2 ending");
        
	}
}
