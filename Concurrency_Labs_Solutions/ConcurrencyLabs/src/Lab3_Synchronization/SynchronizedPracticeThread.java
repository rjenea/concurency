package Lab3_Synchronization;

public class SynchronizedPracticeThread extends Thread {
    
    @Override
    public void run() {
        SynchronizedPurchasingAgent agent = new SynchronizedPurchasingAgent();
        agent.purchase();
    }
    
}