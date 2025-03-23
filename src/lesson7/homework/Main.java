package lesson7.homework;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // fork join
        /*
        // 1-usul
        ForkJoinPool pool = new ForkJoinPool();
        // 2-usul
        ForkJoinPool pool2 = ForkJoinPool.commonPool();
        pool.invoke();*/

        /*int size = 500_000_000;
        double[] arr = new double[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Math.random();
        }*/
        // arr[i] > 0.4

       /* long start = System.currentTimeMillis();
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr, 0, size);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer invoke = forkJoinPool.invoke(customRecursiveTask);
        int invoke = 0;
        for( int i = 0; i < size; i++ ) {
            if (arr[i] > 0.5) {
                invoke++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(invoke + " --- " + (end - start) + " ms");*/


        // Asychronous
        /*for( int i = 1; i <= 100; i++ ) {
            System.out.println("Welcome to PDP ");
        }
        if (true) {
            System.out.println("if ishladi");
        }
        System.out.println("end of main");*/

        // competableFuture
        /*CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Hello");
        System.out.println(completableFuture.get());*/

        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync is running .............");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "response from supplyAsync";
        });
//        Thread.sleep(500);
        System.out.println("Main thread");
        System.out.println(future.get());*/

        // runAsync()
/*        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("runnable is running..........");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("runnable is finished...");
        });
        System.out.println(future.get());*/

        /// thenApply()
        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello Javokhir")
                .thenApply(s -> s + " World");
        System.out.println(future.get());*/

        /// thenAccept()
        /*CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(s -> System.out.println("Hello World"));
        System.out.println(future.get());*/

        /// thenRun()
       /* CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello guys")
                .thenRun(() -> System.out.println("task done successfully"));
        System.out.println(future.get());*/

        /// execeptionally()
        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(()  -> {
            if (true) {
                throw new RuntimeException();
            }
            return "Hello World!";
        }).exceptionally(throwable -> {
            System.out.println("Exception caught");
            return "Error";
        });
        System.out.println(future.get());*/

        /// handle()
        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(()  -> {
            if (false) throw new RuntimeException();
            System.out.println("Farkhod come");
            return "Bekhzod go home";
        }).handle((s, throwable) -> {
            if (throwable != null) System.out.println("error is running");
            if (s != null) return s + " be error";
            return -1;
        });
        System.out.println(future.get());*/

        /*CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "hello")
                .thenApply(s -> s + "Bobur")
                .thenApply(s -> s + "Nodir")
                .thenAccept(s -> System.out.println(s)).
                thenRun(() -> System.out.println("task done"));
        System.out.println(future.get() );*/

       /* ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "Ali ::  " + Thread.currentThread(), executor)
                .thenAccept(s -> System.out.println(s));
        System.out.println(future.get());

        CompletableFuture<Void> future2 = CompletableFuture
                .supplyAsync(() -> "Ali ::  " + Thread.currentThread())
                .thenAccept(s -> System.out.println(s));
        System.out.println(future.get());
        executor.shutdown();*/


        /*CompletableFuture<Void> cf = CompletableFuture.supplyAsync(()  -> "java : " + Thread.currentThread())
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "Babur : " + Thread.currentThread()))
                .thenApply(s -> s + "School")
                .thenAccept(s -> System.out.println(s + "university"));
        System.out.println(cf.get());*/

        /// allOf()
        /*CompletableFuture<String> cf = CompletableFuture.supplyAsync(()  -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "python";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()  -> "C++");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(cf, cf2)
                .thenRun(() -> System.out.println("All tasks are done"));
        System.out.println(cf.get());*/

        /// anyOf()

        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                    System.out.println("1.Thread: " + Thread.currentThread());
                    return "Ali ";
                }, executor)
                .thenApplyAsync(s -> {
                    System.out.println("2. Thread: " + Thread.currentThread() + " " + s);
                    return s + "Aliyev";
                }, executor)
                .thenApplyAsync(s -> {
                    System.out.println("3. Thread: " + Thread.currentThread() + " " + s);
                    return s + "Ganiyev";
                }, executor)
                .thenAccept(s -> System.out.println(s));
        System.out.println(future.get());
        executor.shutdown();


    }

    public static void m1() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String> future = executor.submit(() -> {
            System.out.println("Runnable is running.....");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "response from callable";
        });
        executor.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
