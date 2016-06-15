
package concurrency14_Example_Atomics;

import java.util.concurrent.atomic.AtomicInteger;
 
public class AtomicExample2 { // a simple counter
    /* This snippet is not thread safe, the counter++ is not an atomic operation.
	private static int counter = 0;
 
	public static int getCount() {
		return counter++;
	}
    */
    
    /* So this snippet would improve by synchronizing access to the getCount method to attempt to ensure thread safety
	private static int counter = 0;
 
	public static synchronized int getCount() {
		return counter++;
	}
    // Note that if the method is not static, then adding synchronized keyword will only synchronize the instance of the class, not the Class object. 
    */
    // So, the following ensures that getCount increment is threadsafe
	private static AtomicInteger counter = new AtomicInteger(0);
 
	public static int getCount() {
		return counter.getAndIncrement();
	}
}
