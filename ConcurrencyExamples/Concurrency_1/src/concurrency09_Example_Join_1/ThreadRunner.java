
package concurrency09_Example_Join_1;

public class ThreadRunner  {
	public static void main (String[] args) {
		new SimpleThread1("a").start();
		new SimpleThread1("b").start();
                new SimpleThread1("c").start();
                new SimpleThread1("d").start();
                new SimpleThread2("e").start(); // will send the join()
               
	}
 }


