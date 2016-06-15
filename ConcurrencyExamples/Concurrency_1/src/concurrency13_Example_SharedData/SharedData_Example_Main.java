
package concurrency13_Example_SharedData;

public class SharedData_Example_Main {

    public static void main(String[] args) {
        SharedData_Example_Thread r1 = new SharedData_Example_Thread();
        Thread t1 = new Thread(r1);
        t1.setName("TestThread 1");
        t1.start();
        Thread t2 = new Thread(r1);
        t2.setName("TestThread 2");
        t2.start();
        Thread t3 = new Thread(r1);
        t3.setName("TestThread 3");
        t3.start();
        Thread t4 = new Thread(r1);
        t4.setName("TestThread 4");
        t4.start();
        
    }
}
