package Optional_Lab3_ExecutorService;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ExecutorServiceNetworkClientCallable implements Callable<ExecutorServiceRequestResponse> {

    private ExecutorServiceRequestResponse lookup;

        public ExecutorServiceNetworkClientCallable(ExecutorServiceRequestResponse lookup) {
        this.lookup = lookup;
    }

    @Override
    public ExecutorServiceRequestResponse call() throws IOException {
        try (Socket sock = new Socket(lookup.host, lookup.port);
                Scanner scanner = new Scanner(sock.getInputStream())) {
            lookup.response = scanner.next();
            return lookup;
        }
    }
}