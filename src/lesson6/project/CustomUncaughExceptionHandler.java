package lesson6.project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomUncaughExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println("Uncaught Exception is occured in " + t.getName() + ". Error: " + e.getMessage());
        writeError(t, e);
    }

    private void writeError(Thread t, Throwable e) {
        try {
            // file yaratib beradi
            FileWriter fw = new FileWriter("my_errors/error.log",  true);

            // filega yozish imkonini beradi
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Thread: " + t.getName());
            pw.println("Error: " + e.getMessage());
            e.printStackTrace(pw);
            pw.close();

            System.out.println("--------------------------------------------------------");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
