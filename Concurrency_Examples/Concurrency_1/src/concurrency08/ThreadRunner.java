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
public class ThreadRunner  {
	public static void main (String[] args) {
		new SimpleThread1("a").start();
		new SimpleThread1("b").start();
                new SimpleThread1("c").start();
                new SimpleThread1("d").start();
                new SimpleThread2("e").start(); // will send the join()
               
	}
 }


