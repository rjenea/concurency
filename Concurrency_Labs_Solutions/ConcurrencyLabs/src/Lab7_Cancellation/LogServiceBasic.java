package Lab7_Cancellation;


import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.*;

public class LogServiceBasic {
    private final BlockingQueue<String> queue;
    private final LoggingThread loggerthread;
    private static final int CAPACITY = 1000;

    public LogServiceBasic(Writer out) {
        this.queue = new LinkedBlockingQueue<String>(CAPACITY);
        this.loggerthread = new LoggingThread(out);
    }

    public void start() {
        loggerthread.start();
    }

    public void log(String message) throws InterruptedException {
        queue.put(message);
    }

    private class LoggingThread extends Thread {
        private final PrintWriter out;

        public LoggingThread(Writer out) {
            this.out = new PrintWriter(out, true); 
        }

        public void run() {
            try {
                while (true)
                    out.println(queue.take());
            } catch (InterruptedException e) {
            } finally {
                out.close();
            }
        }
    }
}
