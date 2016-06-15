/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency99;

/**
 *
 * @author Administrator
 */
public class ThreadStoppingExample {

    public static void main(String[] args) {
        int i=0;
        ThreadStoppingExampleRunnable r1 = new ThreadStoppingExampleRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r1);
        t2.start();
        Thread t3 = new Thread(r1);
        t3.start();
        // ...do something for a while
        for(i=0; i < 1000000; i++){  // Try increasing this size and see what happens. 
        }
        System.out.println(" Sending signal to all threads to stop at " + System.currentTimeMillis());
        r1.timeToQuit = true; // send a signal to all threads.
    }
   
}
