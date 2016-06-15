
package concurrency07_Example_Runnable_setName_setPriority_isDaemon;

public class ThreadRunner  {
    public static void main(String[] args){
	int i=0;
        ExampleRunnable r1 = new ExampleRunnable();
        Thread t1 = new Thread(r1);
        System.out.println("Priority = " + t1.getPriority() + " isDaemon = " + t1.isDaemon() + " getID = " + t1.getId() );
     // the getID value remains unchanged even if the thread is renamed with setName
        System.out.println("Thread.currentThread()= " + Thread.currentThread()); // The Runnable instance of this thread.
        t1.setPriority(6); // Try changing this between 1 and 9 (highest) and observe the results
        //t1.yield(); // a hint to the processor to say we will yeild to other things ....
        // t1.setDaemon(true); // allows the JVM to quit even when a thread is running
        t1.setName("MyTestThread"); // Useful when tracing activities with multiple threads
	t1.start();  
        //loop for a while to give thread a bit of a chance to start...
        for(i=0; i < 10000000; i++){  
        }
        //if(!t1.isInterrupted()){ System.out.println(t1.getName() + " Thread has not been interrupted yet");}
        System.out.println(t1.getName() + ": About to interrupt thread");
        t1.interrupt(); // Interrupt the thread.
        if(t1.isInterrupted()){ System.out.println(t1.getName() + ": Thread has been interrupted");}
        // loop for a while to give thread a chance to die...not how this too is very variable
       // while(t1.isAlive()){System.out.println(t1.getName() + ": Igor, The Monster, it still Lives!");} 
       
       for(i=0; i < 1000; i++){ // You might need to increase this loop time to ensure the next statement is false...
           if(t1.isAlive()){System.out.println(t1.getName() + ": Igor, The Monster, it still Lives!");} }
        
        //}
    }
}


