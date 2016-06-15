/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency01;
/**
 *
 * @author Administrator
 */
public class ThreadRunner  {
    public static void main(String[] args){
	ExampleThread t1 = new ExampleThread();
	t1.start();
    }
}

