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
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample1 {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(5);
        if(ai.compareAndSet(5, 42)) {
            System.out.println("Replaced 5 with 42");
        }
    }
}
