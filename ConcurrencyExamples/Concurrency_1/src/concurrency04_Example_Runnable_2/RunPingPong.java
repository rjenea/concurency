
package concurrency04_Example_Runnable_2;

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
