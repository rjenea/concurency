package Lab3_Synchronization;

public class SynchronizedPurchasingAgent {

    public SynchronizedPurchasingAgent() {
        System.out.println("Creating a purchasing agent");
    }

    public void purchase() {
        Thread t = Thread.currentThread();
        System.out.println("Thread:" + t.getName() + "," + t.getId());
        SynchronizedStore store = SynchronizedStore.getInstance();
        synchronized (store) {
            if (store.getShirtCount() > 0 && store.authorizeCreditCard("1234", 15.00)) {
                SynchronizedShirt shirt = store.takeShirt();
                System.out.println("The shirt is ours!");
                System.out.println(shirt);
            } else {
                System.out.println("No shirt for you");
            }
        }
    }
}