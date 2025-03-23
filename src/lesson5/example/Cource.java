package lesson5.example;

import java.util.Set;

public class Cource {
    private String name;
    private Set<String> modules;

    public Cource(String name, Set<String> modules) {
        this.name = name;
        this.modules = Set.copyOf(modules);
    }

    public Cource() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getModules() {
        return modules;
    }

    public void setModules(Set<String> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "\nCource {" +
                "\nname = '" + name + '\'' +
                "\nmodules = " + modules +
                "\n" + '}';
    }
}
