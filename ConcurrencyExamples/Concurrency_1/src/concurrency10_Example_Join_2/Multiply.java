
package concurrency10_Example_Join_2;

class Multiply extends Thread {
	int value;
 
	public void run() {
		value = 1 * 2;
                System.out.println("Multiply thread finished : value = " + value);
            try {
                sleep(500);
            } catch (InterruptedException ex) { }

	}
}
