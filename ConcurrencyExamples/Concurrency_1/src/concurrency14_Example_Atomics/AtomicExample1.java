
package concurrency14_Example_Atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample1 {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(5);
        if(ai.compareAndSet(5, 42)) {
            System.out.println("Replaced 5 with 42");
        }
    }
}
