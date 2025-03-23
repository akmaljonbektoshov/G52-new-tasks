package lesson3.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static Scanner sc = new Scanner(System.in);
    private static Scanner strSc = new Scanner(System.in);

    private static Queue<Product> products = new LinkedList<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                while (products.size() < 6) {
                    System.out.print("Please enter the product name: ");
                    String name = strSc.nextLine();
                    System.out.print("Please enter the product price: ");
                    double price = sc.nextDouble();
                    Product product = new Product(name, price);
                    products.add(product);
                    Thread.sleep(100);
                    System.out.println("Added product successfully!");
                }
                condition.await();
            } catch (InterruptedException e) {
                throw  new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                while (products.size() < 5) {
                    if (products.poll()  == null) {
                        System.out.println("Product not found!");
                    }
                    System.out.println();
                    Thread.sleep(2000);
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                throw  new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();


    }
}

