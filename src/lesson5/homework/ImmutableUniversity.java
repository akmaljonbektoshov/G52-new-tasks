package lesson5.homework;

import java.util.List;

public class ImmutableUniversity {
    private final String name;
    private final List<ImmutableDepartment> departments;

    public ImmutableUniversity(String name, List<ImmutableDepartment> departments) {
        this.name = name;
        this.departments = List.copyOf(departments);
    }

    public String getName() {
        return name;
    }

    public List<ImmutableDepartment> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "ImmutableUniversity{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}
