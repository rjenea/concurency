/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency99;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ThreadStoppingExampleRunnable implements Runnable {

    public boolean timeToQuit = false;
    public void run() {
        System.out.println("Thread started at " + System.currentTimeMillis());
        while (!timeToQuit) {
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadStoppingExampleRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Thread finishing at " + System.currentTimeMillis());
    }
}    

