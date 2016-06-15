/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency09;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
class Add extends Thread {
	int value;
 
	public void run() {
		value = 1 + 2;
                System.out.println("Add thread finished : value = " + value);
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}