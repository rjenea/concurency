/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency03;

/**
 *
 * @author Administrator
 */
public class ThreadRunner  {
    public static void main(String[] args){
	ExampleRunnable rl = new ExampleRunnable();
	Thread tl = new Thread(rl);
	tl.start();
    }
}


