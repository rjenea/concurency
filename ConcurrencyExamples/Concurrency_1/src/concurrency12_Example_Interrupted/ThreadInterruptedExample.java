
package concurrency12_Example_Interrupted;

import java.util.Scanner;

public class ThreadInterruptedExample {
    public static void main(String[] args) {
        Runnable counter = new CounterThread();
        Thread counterThread = new Thread(counter);
        counterThread.start();
        
        System.out.println(" Thread isAlive() = " + counterThread.isAlive() );
        Scanner inKey = new Scanner(System.in);
        System.out.println("Press Enter to interrupt() thread....");
        if ((inKey.nextLine()) != null){
           counterThread.interrupt();
           try {// give it a chance to close down...
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        System.out.println(" Thread isAlive() = " + counterThread.isAlive());
    }
    }   
}
