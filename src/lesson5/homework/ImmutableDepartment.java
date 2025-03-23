package lesson5.homework;

import java.util.List;
import java.util.Map;

public class ImmutableDepartment {
    private final String departmentName;
    private final Map<String, List<String>> employeeProjects;

    public ImmutableDepartment(String departmentName, Map<String, List<String>> employeeProjects) {
        this.departmentName = departmentName;

        this.employeeProjects = Map.copyOf(employeeProjects);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Map<String, List<String>> getEmployeeProjects() {
        return employeeProjects;
    }

    @Override
    public String toString() {
        return "ImmutableDepartment{" +
                "\ndepartmentName='" + departmentName + '\'' +
                "\nemployeeProjects=" + employeeProjects.toString() +
                '}';
    }
}
