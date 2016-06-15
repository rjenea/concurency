
package concurrency31_Example_Thread_Spinning;

import java.util.Scanner;

public class SpinningThreads {
    public static void main(String[] args){  
        createThreads(8,5);     
    }
    public static void createThreads(int numberOfThreads,int threadPriority){
        for(int i=1;i<=numberOfThreads;i++){ 
            new Thread("SpinningThread " +i){ 
                    public void run() {                              
                        this.setPriority(threadPriority);
                        System.out.println(this.getName() + " TID= " + this.getId() + " priority= "+ this.getPriority() +" starting...");                    
                        for (;;) {} // now tight loop forever.
                    }
            }.start();     
        }
        try {
             Thread.sleep(1000); // Wait for while to allow threads to start up and display info 
             } catch (InterruptedException ex) {
        }
        Scanner inKey = new Scanner(System.in);
        System.out.println("Press Enter to close down threads....");
        if ((inKey.nextLine()) != null){
             System.exit(0);
        }
    }
}

