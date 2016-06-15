package Lab7_Cancellation;

import java.io.PrintWriter;

public class VerboseCode implements VerboseUpdater {
	
	private VerboseUpdater updater;
	private volatile boolean running;
	private String[] messages = {"File not Found", "Driver not loaded", "Coffee break", "User entered something stupid"};
	
	private LogService logService;

	public VerboseCode(VerboseUpdater updater) {
		this.updater = updater;
		this.logService = new LogService(new PrintWriter(System.out));
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
		logService.start();
	}
	
	public void stopLogging() {
		logService.stop();
	}

	@Override
	public void update(String text) {
		updater.update(text + "\n");
		try {
			logService.log(text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
