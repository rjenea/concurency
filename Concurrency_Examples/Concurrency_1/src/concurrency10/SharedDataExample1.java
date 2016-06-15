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
public class SharedDataExample1 {

    public static void main(String[] args) {
        SharedDataExample1Thread r1 = new SharedDataExample1Thread();
        Thread t1 = new Thread(r1);
        t1.setName("TestThread 1");
        t1.start();
        Thread t2 = new Thread(r1);
        t2.setName("TestThread 2");
        t2.start();
        Thread t3 = new Thread(r1);
        t3.setName("TestThread 3");
        t3.start();
        Thread t4 = new Thread(r1);
        t4.setName("TestThread 4");
        t4.start();
        
    }
}
