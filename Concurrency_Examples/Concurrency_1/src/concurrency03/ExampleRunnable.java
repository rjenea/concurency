/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency03;

/**
 *
 * @author Administrator
 */
public class ExampleRunnable implements Runnable {
	public void run(){
		for(int i = 0; i < 100; i++){
			System.out.println("i:" + i);
		}
	}
}