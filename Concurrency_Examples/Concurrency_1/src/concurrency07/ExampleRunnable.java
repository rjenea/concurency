/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency07;

// Note how the results of this can vary depending upon the scheduling of the thread...
/**
 *
 * @author Administrator
 */
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
