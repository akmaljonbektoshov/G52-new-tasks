package lesson8.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static int counter = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static Lock lock = new ReentrantLock();
    static Object lock1 = new Object();


    public static void main(String[] args) throws InterruptedException {
        /*Runnable task = () -> {
            lock.lock();
            for(int i = 0; i < 10000; i++) {
                counter++;
            }
            lock.unlock();
        };

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                increment2();
            }
        };

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                atomicIncrement();
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        Thread thread2 = new Thread(task);
        thread2.start();

        thread2.join();
        thread.join();

        System.out.println(atomicInteger.get());*/

        /// volatile
        /*MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        System.out.println("Thread1 started");
        thread2.start();
        System.out.println("Thread2 started");

        Thread.sleep(3000);
        runnable.stop();*/
    }

    static class MyRunnable implements Runnable {
        private volatile boolean active;

        @Override
        public void run() {
            active = true;
            while (active) {

            }
            System.out.println("----------Thread the end----------");
        }

        public void stop() {
            active = false;
        }
    }

    public static void atomicIncrement() {
        atomicInteger.incrementAndGet();
    }

    public static void increment() {
        synchronized (lock1) {
            counter++;
        }
    }

    public synchronized static void increment2() {
        counter++;
    }
}
