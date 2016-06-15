/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency12;

/**
 *
 * @author Administrator
 */
class ThreadBExample1 extends Thread {
	int total;
 
	@Override
	public void run() {
            System.out.println("Thread B about to enter loop");
		for (int i = 0; i < 100; i++) {
			total += i;
		}
	}
}
