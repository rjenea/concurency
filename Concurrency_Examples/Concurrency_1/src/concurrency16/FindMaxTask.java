package concurrency16;

import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public FindMaxTask(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        //System.out.println("Entering compute");
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
            //System.out.println("not there yet still work to do.....");
            int midway = (end - start) / 2 + start;
            FindMaxTask a1 = new FindMaxTask(myArray, start, midway, threshold);
            //System.out.println("About to fork....");
            a1.fork();
            FindMaxTask a2 = new FindMaxTask(myArray, midway + 1, end, threshold);
            //System.out.println("about to return..");
            return Math.max(a2.compute(), a1.join());
        }
    }
}