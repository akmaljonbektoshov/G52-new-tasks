package lesson1;

class Main {
    public static void main(String[] args) throws InterruptedException {
        /*MyThreadWithRunnuble runnuble = new MyThreadWithRunnuble();
        Thread myThread1 = new Thread(runnuble);
        myThread1.start();

        MyThreadWith myThread2 = new MyThreadWith();
        myThread2.start();*/


        // 3.1 - variant
        Runnable runnable = () -> {
            System.out.println("Lamda thread ishga tushdi runnable orqali");
        };
        Thread threadRunnable = new Thread(runnable);
        threadRunnable.start();

        // 3.2
        Thread threadWithLamda = new Thread(() -> {
            System.out.println("Lamda thread ishga tushdi");
        });
        threadWithLamda.start();

        // isAlive()
        Thread.sleep(500);
        threadRunnable.interrupt();
        System.out.println("Thread isAlive: " + threadWithLamda.isAlive());

        Thread.sleep(1000);
        System.out.println("Thread isAlive: " + threadWithLamda.isAlive());
    }
}

// 1-variant bu usul tafsiya etilmaydi chunke
// class 1 ta class ni extends qilaoladi va
// shu usha imkoniyatni Thread ni extends qilishga sarflanayapdi
class MyThreadWith extends Thread {
    static void increment() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Thread ishga tushdi: " + i);
        }
    }

    @Override
    public void run() {
        // thread bajarishi kerak bo'lgan
        // barcha logika shu method ga yoziladi
        increment();
    }
}

// 2-variant runnable interface orqali
class MyThreadWithRunnuble implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread() + " ishga tushdi: " + i);
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted");
            }*/
        }
    }
}