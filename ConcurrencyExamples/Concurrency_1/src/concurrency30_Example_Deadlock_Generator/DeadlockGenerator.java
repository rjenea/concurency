/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency30_Example_Deadlock_Generator;

import java.util.Scanner;

public class DeadlockGenerator {

	public static void main(String[] args) {
		Object left = "left";
		Object right = "right";
		Thread t1 = new SwapThread(left, right);
		Thread t2 = new SwapThread(right, left);
		t1.setName("Deadlock Thread 1");
		t2.setName("Deadlock Thread 2");
		// Start the two threads. If all goes as planned, deadlock will occur, 
		// and the program will never exit.
		t1.start();
		t2.start();
                try {
                    Thread.sleep(3000); // Wait for while to allow threads to start up and display info 
                    } catch (InterruptedException ex) {
                }
                       
           
        
                Scanner inKey = new Scanner(System.in);
                System.out.println("Press Enter to close down threads....");
                if ((inKey.nextLine()) != null){
                    System.exit(0);
                }
	}

        static class SwapThread extends Thread {
            Object left, right;
            public SwapThread(Object left, Object right) {
		this.left = left;
		this.right = right;
            }
            public void run() {
            // Lock resource 1
                synchronized (left) {
                    System.out.println(Thread.currentThread().getName() + ": locked " + left);
                    // simulate some work happening
                    try {
                        Thread.sleep(50);
                        } catch (InterruptedException e) {
                    } 
                    // Now try to get a lock on resource 2
                    System.out.println(Thread.currentThread().getName() + ": trying to lock " + left);
                    synchronized (right) {
			System.out.println(Thread.currentThread().getName() + ": locked " + right);
                    }
            }
	}

    }
}
