package lesson5.homework;

import java.util.Set;

public class ImmutableSet {
    private final Set<Integer> set;

    public ImmutableSet(Set<Integer> set) {
        this.set = Set.copyOf(set);
    }

    public Set<Integer> getSet() {
        return set;
    }

    @Override
    public String toString() {
        return "ImmutableSet{" +
                "set=" + set +
                '}';
    }
}
