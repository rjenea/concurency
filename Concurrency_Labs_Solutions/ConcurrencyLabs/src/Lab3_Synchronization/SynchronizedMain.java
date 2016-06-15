package Lab3_Synchronization;

public class SynchronizedMain {

    public static void main(String[] args) {
        SynchronizedStore store = SynchronizedStore.getInstance();
        store.addShirt(new SynchronizedShirt("1", "Polo", "Rainbow", "Large"));
        
        SynchronizedPracticeThread p1 = new SynchronizedPracticeThread();
        SynchronizedPracticeThread p2 = new SynchronizedPracticeThread(); 
        p1.start();
        p2.start();
    }
}