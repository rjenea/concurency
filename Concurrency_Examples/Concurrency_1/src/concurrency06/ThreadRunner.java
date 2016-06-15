/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency06;


import static java.lang.Thread.sleep;


class ThreadRunner {
    public static void main(String[] args) {
        new Thread( new Runnable() { // anonymous inner way...
                public void run() {
                    try { for (;;) {
                                    System.out.println("Ping");
                                     sleep(10);
                                  }
                       } catch (InterruptedException e) {return;}
                }
        }).start(); //cast the thread off to run in the background
                
                new Runnable() { // alternative anonymous inner way...
                public void run() {
                  try { for (;;) {
                                    System.out.println("Pong");
                                     sleep(10);
                                  }
                       } catch (InterruptedException e) {return;}  
                }
        }.run(); // Note this does not run the thread in background!! ie following code wll not get entered until above is interupted
                new Runnable() {
                public void run() {
                  try { for (;;) {
                                    System.out.println("Pang");
                                     sleep(10);
                                  }
                       } catch (InterruptedException e) {return;}  
                }
        }.run();
        
    }
 
}
