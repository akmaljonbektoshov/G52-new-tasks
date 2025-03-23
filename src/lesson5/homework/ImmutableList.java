package lesson5.homework;

import java.util.List;

public class ImmutableList {
    private final List<String> list;

    public ImmutableList(List<String> list) {
        this.list = List.of(list.toString());
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ImmutableList{" +
                "list=" + list +
                '}';
    }
}
