/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency01;

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
            for(;;){//for ever in a tight loop
            
            }
	}
}