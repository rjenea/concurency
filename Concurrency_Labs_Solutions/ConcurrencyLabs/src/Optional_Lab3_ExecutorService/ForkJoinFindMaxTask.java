package Optional_Lab3_ExecutorService;

import java.util.concurrent.RecursiveTask;

public class ForkJoinFindMaxTask extends RecursiveTask<Integer> {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public ForkJoinFindMaxTask(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if (end - start < threshold) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                int n = myArray[i];
                if (n > max) {
                    max = n;
                }
            }
            return max;
        } else {
            int midway = (end - start) / 2 + start;
            ForkJoinFindMaxTask a1 = new ForkJoinFindMaxTask(myArray, start, midway, threshold);
            a1.fork();
            ForkJoinFindMaxTask a2 = new ForkJoinFindMaxTask(myArray, midway + 1, end, threshold);           
            return Math.max(a2.compute(), a1.join());
        }
    }
}