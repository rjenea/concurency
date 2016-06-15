/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency01_Example_SingleThread;

/**
 *
 * @author Administrator
 */
public class ExampleThread extends Thread {
	public void run(){
		/*for(int i = 0; i < 100; i++){
			System.out.println("i:" + i);
			}*/
            System.out.println(Thread.currentThread());
            for(;;){try {
                //for ever in a tight loop
                System.out.println("I'm going to sleep");sleep(1000);System.out.println("I've woken up!");
                   } catch (InterruptedException ex) {                   
                }
            }
	}
}