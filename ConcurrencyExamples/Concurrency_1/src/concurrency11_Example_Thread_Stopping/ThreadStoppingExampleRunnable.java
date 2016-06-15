
package concurrency11_Example_Thread_Stopping;

import static java.lang.Thread.sleep;

public class ThreadStoppingExampleRunnable implements Runnable {

    public boolean timeToQuit = false;
    public void run() {
        System.out.println("Thread started at " + System.currentTimeMillis());
        while (!timeToQuit) {
            try {
                sleep(10000);
            } catch (InterruptedException ex) { }
        }
        System.out.println("Thread finishing at " + System.currentTimeMillis());
    }
}    

