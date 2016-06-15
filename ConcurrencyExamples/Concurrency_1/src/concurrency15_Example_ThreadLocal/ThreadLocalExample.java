
package concurrency15_Example_ThreadLocal;

public class ThreadLocalExample {
 public static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> threadLocal =  new ThreadLocal<Integer>();
        
        public void run() {
		threadLocal.set( (int) (Math.random() * 100D) ); // stick a random value inside
           	try {
                    Thread.sleep(2000); // A 'Dramatic' pause for effect....
            	} catch (InterruptedException e) {}
            		
            	System.out.println(Thread.currentThread().getName() + " Threadlocal value = " + threadLocal.get());
        }
    }
    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        Thread thread3 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
   

