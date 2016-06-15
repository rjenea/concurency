package Lab7_Cancellation;


public class VerboseCode implements VerboseUpdater {
	
	private VerboseUpdater updater;
	private volatile boolean running;
	private String[] messages = {"File not Found", "Driver not loaded", "Coffee break", "User entered something stupid"};
	
	public VerboseCode(VerboseUpdater updater) {
		this.updater = updater;
	}
	
	public void startMessages() {
		running = true;
	
		for (int i = 0; i < 10; i++) {
			new RandomMessagesThread().start();
		}
		
	}
	
	public void stopMessages() {
		running = false;
	}

	
	public void startLogging() {
	}
	
	public void stopLogging() {
	}

	@Override
	public void update(String text) {
		updater.update(text + "\n");
	}
	
	private class RandomMessagesThread extends Thread {
		@Override
		public void run() {
			while (running) {
				int x = (int) (Math.random() * messages.length);
				update(messages[x]);
				try {
					Thread.sleep(0, (int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					
				}
			}
			update(this.getId() + " stopped");
		}
	}
	
}
