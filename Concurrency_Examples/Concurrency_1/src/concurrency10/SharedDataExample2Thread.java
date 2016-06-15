/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency10;

/**
 *
 * @author Administrator
 */
public class SharedDataExample2Thread extends Thread {

    private long i; // This will be shared by all threads.

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println( " i =" + i);
        }
    }
}
