
package concurrency03_Example_Runnable_1;

public class ThreadRunner  {
    public static void main(String[] args){
	ExampleRunnable rl = new ExampleRunnable();
	Thread tl = new Thread(rl);
	tl.start();
    }
}


