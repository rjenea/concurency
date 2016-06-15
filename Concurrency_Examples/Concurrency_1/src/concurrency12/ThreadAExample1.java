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
public class ThreadAExample1 { //unsynchronized example
	public static void main(String[] args) {
		ThreadBExample1 b = new ThreadBExample1();
                System.out.println("Starting Thread B");
		b.start();
 
		System.out.println("Now back in thread A : total is: " + b.total);
 
	}
}
