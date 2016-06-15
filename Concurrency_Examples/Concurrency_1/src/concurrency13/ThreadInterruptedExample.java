/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class ThreadInterruptedExample {
    public static void main(String[] args) {
        Runnable r = new CounterThread();
        Thread t = new Thread(r);
        t.start();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine(); // wait for a return to be typed.
        } catch (IOException e) {}
        
        System.out.println("Thread is alive:" + t.isAlive() );
        t.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread is alive:" + t.isAlive());
    }   
}
