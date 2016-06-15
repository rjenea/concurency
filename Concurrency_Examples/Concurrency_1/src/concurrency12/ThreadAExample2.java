/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ThreadAExample2 {
    public static void main(String[] args){
        ThreadBExample2 b = new ThreadBExample2();
        System.out.println("Starting Thread B");
        
        b.start();
        
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadAExample2.class.getName()).log(Level.SEVERE, null, ex);
        }  */
        
// if(!b.isAlive()){ // good practice as b may well have finished already..uncomment above sleep to see what happens.
        synchronized(b){
            try{
                System.out.println("Now waiting for B to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Now back in thread A : total is: " + b.total);
        }
    }
//}
}
