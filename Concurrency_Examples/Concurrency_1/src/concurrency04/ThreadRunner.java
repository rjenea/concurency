/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrency04;

class ThreadRunner {
	public static void main(String[] args) {
	Runnable ping = new RunPingPong("Ping",100);
        Runnable pong= new RunPingPong("Pong",10);
	new Thread(ping).start();
	new Thread(pong).start();
	}
}

