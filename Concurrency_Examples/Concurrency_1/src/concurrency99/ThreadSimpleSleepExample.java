/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency99;

/**
 *
 * @author Administrator
 */
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
