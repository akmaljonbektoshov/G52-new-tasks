package lesson8.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ImmutableClass {
    private final List<String> list;
    private final Person person;
    private final Map<String, List<String>> map;

    public ImmutableClass(List<String> list,
                          Person person,
                          Map<String, List<String>> map) {

        this.list = List.copyOf(list);
        try {
            this.person = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Map<String, List<String>> map2 = new HashMap<>();
        /*for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            map2.put(entry.getKey(), List.copyOf(entry.getValue()));
        }*/
        map.forEach((key, value) -> {
            map2.put(key, List.copyOf(value));
        });
        this.map = map2;
    }

    public List<String> getList() {
        return list;
    }

    public Person getPerson() {
        return person;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "list=" + list +
                ", person=" + person +
                ", map=" + map +
                '}';
    }
}
