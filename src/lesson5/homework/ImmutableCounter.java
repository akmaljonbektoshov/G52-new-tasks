package lesson5.homework;

import java.util.Set;

public class ImmutableCounter {
    private final String name;
    private final Set<String> cities;

    public ImmutableCounter(String name, Set<String> cities) {
        this.name = name;
        this.cities = Set.copyOf(cities);
    }

    public String getName() {
        return name;
    }

    public Set<String> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "ImmutableCounter{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
