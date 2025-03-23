package lesson6.lesson6;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        };
    };

    public static void main(String[] args) {
        /*Runnable runnable = new Runnable() -> {
            System.out.println("Hello World");
        }

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();*/

        // 1
        /*ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> {
            System.out.println("Thread started");
        });
        executor.shutdown();*/

        // 2
        /*ExecutorService executor2 = Executors.newCachedThreadPool();
        for (int i = 1; i <= 1000; i++) {
            executor2.execute(() -> {
                System.out.println("Start " + Thread.currentThread().getName());
                System.out.println("Active thread: " + Thread.currentThread().activeCount());
            });
        }*/

        // 3
        /*ExecutorService executor3 = Executors.newSingleThreadExecutor();
        executor3.execute(() -> {
            System.out.println("Starting: " + Thread.currentThread().getName());
        });*/

        // 4
        //ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(5);
       /* Runnable task = () -> {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };*/

        /*for (int i = 0; i < 100; i++) {
            executor4.schedule(task, 2, TimeUnit.SECONDS);
        }*/

        // executor4.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);
//        executor4.scheduleWithFixedDelay(task, 1, 2, TimeUnit.SECONDS);
        /*try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(executor4.awaitTermination(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor4.shutdownNow();*/

        // Callable example
        /*int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Core Count: " + coreCount);

        ExecutorService executor = Executors.newFixedThreadPool(coreCount);

        Callable<Boolean> callable1 = () -> {
            System.out.println("Checking sender ........");
            Thread.sleep(1000);
            return true;
        };

        Callable<Boolean> callable2 = () -> {
            System.out.println("Checking receiver ........");
            Thread.sleep(1000);
            return true;
        };

        Future<Boolean> response1 = executor.submit(callable1);
        Future<Boolean> response2 = executor.submit(callable2);

        executor.shutdown();
        try {
            Thread.sleep(2000);

            System.out.println(response1.get());
            System.out.println(response2.get());
        } catch (InterruptedException  | ExecutionException e) {
            throw new RuntimeException(e);
        }*/

        // Callable 2
        /*int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(coreCount);

        Callable<String> callable = () -> {
            System.out.println("Callable started");
            Thread.sleep(2000);
            return "";
        };

        Future<String> future = executor.submit(callable);

        try {
//            System.out.println(future.get(1, TimeUnit.SECONDS));
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException *//*| TimeoutException*//* e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(1000);

            if (future.isDone()) {
                System.out.println("It is okay, Callable succeeded.");
            }  else {
                System.out.println("Callable is cancelling .........");
                future.cancel(true);
            }
            System.out.println(future.isCancelled());
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdownNow();*/

        // invokeAll/invokeAny
        /*int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(coreCount);

        Callable<String> callable = () -> {
            System.out.println("Running callable ........1");
            Thread.sleep(1000);
            return "Callable1 ";
        };

        Callable<String> callable2 = () -> {
            System.out.println("Running callable ........2");
            Thread.sleep(1000);
            return "Callable2 ";
        };

        Callable<String> callable3 = () -> {
            System.out.println("Running callable ........3");
            Thread.sleep(1000);
            return "Callable3 ";
        };

        *//*Future<String> submit = executor.submit(callable);
        Future<String> submit1 = executor.submit(callable2);
        Future<String> submit3 = executor.submit(callable3);*/

        /*try {
            List<Future<String>> futures = executor.invokeAll(List.of(callable3, callable3, callable));

            for (Future<String> f : futures) {
                System.out.println(f.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            String s = executor.invokeAny(List.of(callable, callable2, callable3));
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }*/

        // simple date format with
        /*int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(coreCount);

        Runnable task = () -> {
            getDateWith(new Date());
        };

        for (int i = 0; i < 1000; i++) {
            executor.execute(task);
        }
        executor.shutdown();*/

        // simple date format without
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        Runnable runnable = () -> {
            getDateWithout(new Date());
        };

        for (int i = 0; i < 1000; i++) {
            executorService.execute(runnable);
        }

        executorService.shutdown();


        // thread local random
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomInt = random.nextInt(10);
        double randomDouble = random.nextDouble();
    }

    private static void getDateWith(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

    }

    private static void getDateWithout(Date date) {
        SimpleDateFormat sdf = threadLocal.get();
        String format = sdf.format(date);
        System.out.println(format);

    }
}
