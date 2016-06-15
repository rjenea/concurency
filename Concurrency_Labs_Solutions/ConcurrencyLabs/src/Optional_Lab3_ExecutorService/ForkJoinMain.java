package Optional_Lab3_ExecutorService;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {

    //We use a lot of memory
    //The project properties should have a Run, VM Option of -Xmx1024m
    public static void main(String[] args) {
        int[] data = new int[1024 * 1024 * 128]; //512MB

//        for (int i = 0; i < data.length; i++) {
//            data[i] = ThreadLocalRandom.current().nextInt();
//        }

//        int max = Integer.MIN_VALUE;
//        for (int value : data) {
//            if (value > max) {
//                max = value;
//            }
//        }
//        System.out.println("Max value found:" + max);
        
        ForkJoinPool pool = new ForkJoinPool();
        
        ForkJoinRandomArrayAction action = new ForkJoinRandomArrayAction(data, 0, data.length-1, data.length/16);
        pool.invoke(action);
        
        ForkJoinFindMaxTask task = new ForkJoinFindMaxTask(data, 0, data.length-1, data.length/16);
        Integer result = pool.invoke(task);
        System.out.println("Max value found:" + result);
        
    }
}
