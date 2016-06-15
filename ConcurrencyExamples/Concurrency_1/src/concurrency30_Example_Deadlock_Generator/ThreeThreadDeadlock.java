
package concurrency30_Example_Deadlock_Generator;

import java.util.Scanner;

public class ThreeThreadDeadlock {
 
    public static void main(String[] args) throws InterruptedException {
        Object firstSynchObject = new Object();
        Object secondSynchObject = new Object();
        Object thirdSynchObject = new Object();
 
        Thread thread1 = new Thread(new SynchronizeThread(firstSynchObject, secondSynchObject), "Deadlock Thread1");
        Thread thread2 = new Thread(new SynchronizeThread(secondSynchObject, thirdSynchObject), "Deadlock Thread2");
        Thread thread3 = new Thread(new SynchronizeThread(thirdSynchObject, firstSynchObject), "Deadlock Thread3");
 
        thread1.start();
        Thread.sleep(3000); // Wait for a while before starting next thread
        thread2.start();
        Thread.sleep(3000); // Wait for a while before starting next thread
        thread3.start();
        Thread.sleep(3000); // Wait for while to allow threads to display 
        Scanner inKey = new Scanner(System.in);
                System.out.println("Press Enter to close down threads....");
                if ((inKey.nextLine()) != null){
                    System.exit(0);
                }
    }
}
 
class SynchronizeThread implements Runnable {
    private Object obj1;
    private Object obj2;
 
    public SynchronizeThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(name + " Acquired first lock on : " + obj1);
            try { // Now wait for a while to allow the other threads to get their first lock
                Thread.sleep(10000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(name + " Now attempting to get a lock on : " + obj2);
            synchronized (obj2) { 
                System.out.println(name + " Acquired second lock on : " + obj2);
            }
            System.out.println(name + " Released lock on : " + obj2);
        }
        System.out.println(name + " Released lock on: " + obj1);
        System.out.println(name + " Finished Deadlock Test.");
    }
  
}
