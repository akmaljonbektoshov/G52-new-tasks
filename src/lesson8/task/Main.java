package lesson8.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {{
            add("Akmaljon");
            add("Karl");
            add("Ali");
        }};

        List<String> list2 = new ArrayList<>() {{
            add("Yujee");
            add("Ali");
        }};

        String name = "Akmaljon";
        int age = 23;
        Person person = new Person(name, age);

        Map<String, List<String>> map = new HashMap<>(){{
            put("Emeley", list);
            put("John", list2);
        }};

        ImmutableClass immutableClass = new ImmutableClass(list, person, map);

        System.out.println(immutableClass);
        person.setAge(30);
        person.setName("Karl");
        list.add("Bekzod");
        list2.add("Kolya");
        name = "G'ani";
        age = 22;
        map.put("Alice", list2);
        map.put("Akbar", list2);
        System.out.println(immutableClass);

    }
}
