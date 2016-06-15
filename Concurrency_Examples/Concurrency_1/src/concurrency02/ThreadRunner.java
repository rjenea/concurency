/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency02;

/**
 *
 * @author Administrator
 */
public class ThreadRunner  {
	public static void main (String[] args) {
		new SimpleThread("Hello").start();
		new SimpleThread("Goodbye").start();
                new SimpleThread("So long").start();
                new SimpleThread("Farewell").start();
	}
 }


