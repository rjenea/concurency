/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency05;

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

