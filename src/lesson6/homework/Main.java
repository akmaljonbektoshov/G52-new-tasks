package lesson6.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        /// task1
        /*
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int n = random.nextInt(10);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Running calculation.....");
            Thread.sleep(1000);
            return calculate(n);
        };

        Future<Integer> future = executor.submit(task);
        try {
            System.out.println("Submit result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();*/

        /// task 2
        /*ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable task = () -> {
            System.out.println("Done task1");
        };

        Runnable task2 = () -> {
            System.out.println("Done task2");
        };

        Runnable task3 = () -> {
            System.out.println("Done task3");
        };

        Runnable task4 = () -> {
            System.out.println("Done task4");
        };

        Runnable task5 = () -> {
            System.out.println("Done task5");
        };

        executor.execute(task);
        executor.execute(task2);
        executor.execute(task3);
//        executor.shutdownNow();
        executor.execute(task4);
        executor.execute(task5);
        executor.shutdown();*/

        /// task3
        /*ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task = () -> {
            System.out.println("Task1 running .........");
            Thread.sleep(1000);
            return "Task1 finished";
        };

        Callable<String> task2 = () -> {
            System.out.println("Task2 running .........");
            Thread.sleep(1000);
            return "Task2 finished";
        };

        Callable<String> task3 = () -> {
            System.out.println("Task3 running .........");
            Thread.sleep(1000);
            return "Task3 finished";
        };

        try {
            List<Future<String>> futures = executor.invokeAll(List.of(task, task2, task3));
            executor.shutdown();
            for (Future<String> s: futures) {
                System.out.println(s.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }*/

        /// 4
//        ExecutorService executor = Executors.newScheduledThreadPool();
    }

    public static int calculate(int n) {
        return n*n;
    }
}
