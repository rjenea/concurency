/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency08;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ThreadJoinDemo implements Runnable {

   public void run() {
   
   Thread t = Thread.currentThread();
   System.out.print(t.getName());
   System.out.println(", status = " + t.isAlive());
   }

   public static void main(String args[]) throws Exception {
   
   Thread t = new Thread(new ThreadJoinDemo());
   // this will call run() function
   t.start();
   
   t.join(); // waits for this thread to die
   System.out.print(t.getName());
   //checks if this thread is alive
   System.out.println(", status = " + t.isAlive());
   }
} 
