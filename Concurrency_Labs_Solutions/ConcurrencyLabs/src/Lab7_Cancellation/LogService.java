package Lab7_Cancellation;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LogService {
	
	private final BlockingQueue<String> queue;
	private final LoggingThread loggerThread;
	private final PrintWriter out;
	private boolean running;
	private int remaining;

	public LogService(Writer out) {
		this.queue = new LinkedBlockingQueue<String>();
		this.loggerThread = new LoggingThread();
		this.out = new PrintWriter(out);
	}

	public void start() {
		running = true;
		loggerThread.start();
	}

	public void stop() {
		synchronized (this) {
			running = false;
		}
		loggerThread.interrupt();
	}

	public void log(String message) throws InterruptedException {
		synchronized (this) {
			if (!running)
				throw new IllegalStateException();
			remaining++;
		}
		queue.put(message);
	}

	private class LoggingThread extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					try {
						synchronized (LogService.this) {
							if (!running && remaining == 0)
								break;
						}
						String message = queue.take();
						synchronized (LogService.this) {
							remaining--;
						}
						out.println(message);
					} catch (InterruptedException e) { 
					}
				}
			} finally {
				out.close();
			}
		}
	}
}
