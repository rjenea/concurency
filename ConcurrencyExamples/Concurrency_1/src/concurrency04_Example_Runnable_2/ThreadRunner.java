
package concurrency04_Example_Runnable_2;

class ThreadRunner {
	public static void main(String[] args) {
	Runnable ping = new RunPingPong("Ping",100);
        Runnable pong= new RunPingPong("Pong",10);
	new Thread(ping).start();
	new Thread(pong).start();
	}
}

