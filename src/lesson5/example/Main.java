package lesson5.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        String name = "Akmaljon";
        String[] emails = new String[]{"dilshod@gmail.com",
                "akmaljon@gmail.com",
                "javlonbek@gmail.com"};

        Map<Integer, Cource>  courses = new HashMap<>() {{
            put(1, new Cource("Akmal", new HashSet<>() {{
                add("Kimyo");
                add("Fizika");
                add("Matematika");
                add("Bialogiya");
            }}));

            put(3, new Cource("Dilshod", new HashSet<>(){{

            }}));

            put(4, new Cource("Axror", new HashSet<>()));
        }};
        User user = new User(name, emails, courses);

        AtomicInteger counter = new AtomicInteger();
        counter.compareAndSet(8, 5);
        System.out.println(counter.get());
    }
}
