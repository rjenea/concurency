/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency04;

/**
 *
 * @author Administrator
 */
class RunPingPong implements Runnable {
	String word;
	int delay;
	RunPingPong (String whatToSay, int delayTime) {
	word = whatToSay;
	delay = delayTime;
        }
public void run() {
	try { for (;;) {
		System.out.println(word + " ");
		Thread.sleep(delay);
		}
	} catch (InterruptedException e) {return;}
    }
}
