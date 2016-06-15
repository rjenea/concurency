package Optional_Lab3_ExecutorService;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinRandomArrayAction extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public ForkJoinRandomArrayAction(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (end - start < threshold) {
            for (int i = start; i <= end; i++) {
                myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {
            int midway = (end - start) / 2 + start;
            ForkJoinRandomArrayAction r1 = new ForkJoinRandomArrayAction(myArray, start, midway, threshold);
            ForkJoinRandomArrayAction r2 = new ForkJoinRandomArrayAction(myArray, midway + 1, end, threshold);           
            invokeAll(r1, r2);
        }
    }
}