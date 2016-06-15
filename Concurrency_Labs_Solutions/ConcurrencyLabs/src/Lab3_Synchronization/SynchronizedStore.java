package Lab3_Synchronization;

import java.util.Deque;
import java.util.LinkedList;

public class SynchronizedStore {

    private Deque<SynchronizedShirt> shirts = new LinkedList<>();
    //singleton
    private static SynchronizedStore instance = new SynchronizedStore();
    //singleton

    private SynchronizedStore() {
    }
    //singleton

    public static SynchronizedStore getInstance() {
        return instance;
    }

    public void addShirt(SynchronizedShirt shirt) {
        System.out.println("Adding a shirt to the store.");
        shirts.push(shirt);
        System.out.println("Total shirts in stock: " + shirts.size());
    }

    public SynchronizedShirt takeShirt() {
        return shirts.pop();
    }

    public int getShirtCount() {
        return shirts.size();
    }

    public boolean authorizeCreditCard(String accountNumber, double amount) {
        //placeholder method to test workflow
        //since this would normally communicate with a external source
        //this method should take longer to execute...
        int seconds = (int) (Math.random() * 3 + 1);
        System.out.println("Sleeping for " + seconds + " seconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        return true;
    }
}