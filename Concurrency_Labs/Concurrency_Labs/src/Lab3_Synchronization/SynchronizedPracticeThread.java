package Lab3_Synchronization;

public class SynchronizedPracticeThread extends Thread {
    
    @Override
    public void run() {
        PurchasingAgent agent = new PurchasingAgent();
        agent.purchase();
    }
    
}