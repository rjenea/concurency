
package concurrency08_Example_SimpleSleep;

public class ThreadSimpleSleepExample {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            // What to do?
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Slept for " + time + " ms");
    }
}
