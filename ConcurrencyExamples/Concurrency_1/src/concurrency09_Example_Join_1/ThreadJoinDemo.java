
package concurrency09_Example_Join_1;

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
