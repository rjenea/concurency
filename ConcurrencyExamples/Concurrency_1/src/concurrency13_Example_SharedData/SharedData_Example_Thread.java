
package concurrency13_Example_SharedData;

public class SharedData_Example_Thread extends Thread {

    private int i; // This will be shared by all threads.

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println( " i =" + i);
        }
    }
}
