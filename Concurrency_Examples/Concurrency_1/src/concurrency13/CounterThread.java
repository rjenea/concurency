/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency13;

/**
 *
 * @author Administrator
 */

public class CounterThread implements Runnable {
    
    @Override
    public void run() {
        int x = 0;
        while(!Thread.currentThread().isInterrupted()) {
            System.out.println("The current value of x is: " + x++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}   

