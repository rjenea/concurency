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
class ThreadBExample2 extends Thread{
    int total=0;
    @Override
    public void run(){
        synchronized(this){
            System.out.println("Thread B about to enter loop");
            for(int i=0; i<100 ; i++){
                total += i;
            }
            System.out.println("Thread B out of loop and about to notify...");
            notify();
        }
    }
}
