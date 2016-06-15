/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency22_Example_CyclicBarrier_1;

/**
 *
 * @author Administrator
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(2);

        new Thread() {
            public void run() {
                try {
                    System.out.println("before await - thread 1");
                    barrier.await();
                    System.out.println("after await - thread 1");
                } catch (BrokenBarrierException|InterruptedException ex) {

                }
            }
        }.start();
    }
}
