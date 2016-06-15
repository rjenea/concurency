package Optional_Lab3_ExecutorService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceNetworkClientMain {

    public static void main(String[] args) {
//        //Single-threaded version
//        String host = "localhost";
//        for (int port = 10000; port < 10010; port++) {
//            RequestResponse lookup = new RequestResponse(host, port);
//            try (Socket sock = new Socket(lookup.host, lookup.port);
//                    Scanner scanner = new Scanner(sock.getInputStream());) {
//                lookup.response = scanner.next();
//                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
//            } catch (NoSuchElementException | IOException ex) {
//                System.out.println("Error talking to " + host + ":" + port);
//            }
//        }
        
        //ThreadPool used to execute Callables
        ExecutorService es = Executors.newCachedThreadPool();
        //A Map used to connect the the request data with the potential result
        Map<ExecutorServiceRequestResponse, Future<ExecutorServiceRequestResponse>> callables = new HashMap<>();

        String host = "localhost";
        //loop to create and submit a bunch of Callable instances
        for (int port = 10000; port < 10010; port++) {
            ExecutorServiceRequestResponse lookup = new ExecutorServiceRequestResponse(host, port);
            ExecutorServiceNetworkClientCallable callable = new ExecutorServiceNetworkClientCallable(lookup);
            Future<ExecutorServiceRequestResponse> future = es.submit(callable);
            callables.put(lookup, future);
        }

        //Stop accepting new Callables
        es.shutdown();

        try {
            //Block until all Callables have a chance to finish
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Stopped waiting early");
        }

        for (ExecutorServiceRequestResponse lookup : callables.keySet()) {
            Future<ExecutorServiceRequestResponse> future = callables.get(lookup);
            try {
                lookup = future.get();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (ExecutionException | InterruptedException ex) {
                //This is why the callables Map exists
                //future.get() fails if the task failed
                System.out.println("Error talking to " + lookup.host + ":" + lookup.port);
            }
        }
    }
}