package lesson5.homework;

import java.util.List;

public class ImmutablePerson {
    private final String name;
    private final List<String> list;

    public ImmutablePerson(String name, List<String> list) {
        this.name = name;
        this.list = List.of(list.toString());
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
