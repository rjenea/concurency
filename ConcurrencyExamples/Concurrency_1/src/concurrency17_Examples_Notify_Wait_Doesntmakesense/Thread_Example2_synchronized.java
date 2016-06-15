
package concurrency17_Examples_Notify_Wait_Doesntmakesense;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Example2_synchronized {
    public static void main(String[] args){
        Synchronized_Thread thread = new Synchronized_Thread();
        thread.setName("Synchronized_Example");
        System.out.println("Thread "+thread.getName() + " starting");   
        thread.start(); // cast off to run asynchronously
        // This is not good practice as we are relying on the cast off thread actually running at this point and getting a lock first.
        // If it doesn't run, when we get to the next line of code, this main will get the lock and is then going to wait forever.
        
            /*try {
            Thread.sleep(5000);
            } catch (InterruptedException ex) {}
            */
        
           
// if(!thread.isAlive()){ // good practice as thread may well have finished already..uncomment above sleep to see what happens.
        synchronized(thread){ // Has to wait for lock to be released
            try{
                System.out.println("Now synchronized waiting for thread "+thread.getName() + " to complete and release the lock...");
                thread.wait();
            }catch(InterruptedException e){ }
    
            System.out.println("Now back in main : total is " + thread.total);
        }
    }
//}
}

class Synchronized_Thread extends Thread{
    int total=0;
    public void run(){
       
        try {
            sleep(5000);
        } catch (InterruptedException ex) {}
           
        synchronized(this){ // gets the lock.
            System.out.println("Thread " +this.getName() + " has lock and about to enter loop");
            for(int i=0; i<1000 ; i++){
                total += i;
            }
            System.out.println("Thread " +this.getName() + " out of loop and about to notify...");
            notify();
        } // lock released
    }
}