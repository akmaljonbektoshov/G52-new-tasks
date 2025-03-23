package lesson3.task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean ready = false;

    private static int saledProductCount = 0;
    private static int lemitedProductCount = 10;
    private static double productDiscountPrice = 920;
    private static double productPrice = 1200;

    public static void main(String[] args) throws InterruptedException {
        Thread saleThread = new Thread(() -> {
            lock.lock();
            try {
                while (lemitedProductCount != 0) {
                    lemitedProductCount--;
                    saledProductCount++;
                    System.out.println(saledProductCount + " pieces discount product saled ");
                    Thread.sleep(1000);
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                throw  new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread discountMonitoringThread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Start discount");
                while (lemitedProductCount != 0) {
                    condition.await();
                }
                System.out.println("Finished discount");
            } catch (InterruptedException e) {
                throw  new RuntimeException("F " + e);
            } finally {
                lock.unlock();
            }
        });

        discountMonitoringThread.start();
        saleThread.start();

    }
}
