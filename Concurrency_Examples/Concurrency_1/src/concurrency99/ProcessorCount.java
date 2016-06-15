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
public class ProcessorCount {


    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("Processor Count:" + count);
    }
}   

