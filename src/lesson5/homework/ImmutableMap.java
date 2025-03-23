package lesson5.homework;

import java.util.Map;

public class ImmutableMap {
    private final Map<String, String> map;

    public ImmutableMap(Map<String, String> map) {
        this.map = Map.copyOf(map);
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "ImmutableMap{" +
                "map=" + map +
                '}';
    }
}
