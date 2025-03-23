package lesson7.lesson;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int size = 500_000;
        double[] arr = new double[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Math.random();
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr,0, size);
        Integer invoke = forkJoinPool.invoke(customRecursiveTask);
        System.out.println(invoke);

        // arr[i] > 0.4
    }
}
