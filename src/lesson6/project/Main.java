package lesson6.project;

public class Main {
    public static void main(String[] args) {
        var handler = new CustomUncaughExceptionHandler();

        Thread.setDefaultUncaughtExceptionHandler(handler);
        throw new RuntimeException("Error");
    }
}
