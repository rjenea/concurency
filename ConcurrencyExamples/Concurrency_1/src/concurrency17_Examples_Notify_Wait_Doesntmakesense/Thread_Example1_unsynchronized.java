
package concurrency17_Examples_Notify_Wait_Doesntmakesense;

public class Thread_Example1_unsynchronized { //unsynchronized example
	public static void main(String[] args) {
		Unsynchronized_Thread thread = new Unsynchronized_Thread();
                thread.setName("Unsynchronized Example");
                System.out.println("Starting Thread " + thread.getName());
		thread.start(); // Cast off thread to run asynchronously
		System.out.println("Now back in thread Main : int total is: " + thread.total);
	}
}
class Unsynchronized_Thread extends Thread {
	int total;
	public void run() {
            System.out.println( " Inside the thread " + this.getName() + " we are about to enter the loop");
		for (int i = 0; i < 1000; i++) {
			total += i;
		}
	}
}