package Lab5_Producer_Consumer;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileSystemProcessor {
	private BlockingQueue<File> queue;

	public static void main(String[] args) {
		List<File> files = new LinkedList<File>();
		for (String fileName : args) {
			File f = new File(fileName);
			if (f.exists()) {
				files.add(f);
			}
		}
		if (files.size() > 0) {
			FileSystemProcessor fsp = new FileSystemProcessor();
			fsp.kickoff(files.toArray(new File[0]));
		}
	}

	public FileSystemProcessor() {
		queue = new LinkedBlockingQueue<File>(10);
	}

	public void kickoff(File[] files) {
		for (File f : files) {
			FileProducer producer = new FileProducer(queue, f);
			new Thread(producer).start();
		}

		int P = Runtime.getRuntime().availableProcessors();
		int N = (P > 1) ? P : 3;
		System.out.println("Processors: " + P + ", using " + N + " consumers.");
		for (int i = 0; i < N; i++) {
			FileConsumer consumer = new FileConsumer(queue, i + 1);
			new Thread(consumer).start();
		}
	}

	private static class FileProducer implements Runnable {
		private BlockingQueue<File> queue;
		private File root;

		public FileProducer(BlockingQueue<File> queue, File root) {
			this.queue = queue;
			this.root = root;
		}

		public void recurse(File f) throws InterruptedException {
			queue.put(f);
			if (!f.isDirectory()) {
				return;
			} else {
				for (File fi : f.listFiles()) {
					recurse(fi);
				}
			}
		}

		@Override
		public void run() {
			try {
				recurse(root);
			} catch (InterruptedException e) {
			}
		}
	}

	private static class FileConsumer implements Runnable {
		private BlockingQueue<File> queue;
		private int id;
		private int count;
		private volatile boolean stopped;

		public void setStopped(boolean stopped) {
			this.stopped = stopped;
		}

		public FileConsumer(BlockingQueue<File> queue, int id) {
			this.id = id;
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (!stopped) {
					File f = queue.take();
					count++;
					System.out.println("Found: " + f.getName() + " (" + id
							+ "." + count + ")");
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
