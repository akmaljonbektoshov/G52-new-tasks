package lesson5.homework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // task1
        /*List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ImmutableList iList = new ImmutableList(list);
        System.out.println(iList);
        list.add("d");
        System.out.println(iList);*/

        // task7
        /*List<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Python");
        books.add("C++");
        books.add("C");

        Set<String> members = new HashSet<>();
        members.add("jj");
        members.add("kk");
        members.add("uu");
        members.add("oo");
        ImmutableLibrary library = new ImmutableLibrary(books, members);
        System.out.println(library);
        books.add("cotlen");
        members.add("doston");
        System.out.println(library);*/

        // task8
        List<String> books = new ArrayList<>();
        books.add("Java");

        List<String> members = new ArrayList<>();
        members.add("member1");

        List<String> departments = new ArrayList<>();
        departments.add("department1");
        departments.add("department5");

        Map<String, List<String>>  employeeProjects = new HashMap<>();

        employeeProjects.put("Developer", books);
        employeeProjects.put("Manager", members);
        employeeProjects.put("Admin", departments);

        var department = new ImmutableDepartment("dilshod", employeeProjects);

        System.out.println(department);

        books.add("aaaa");
        members.add("bbbb");
        departments.add("dilshod");

        List<String> projects = new ArrayList<>();
        projects.add("project1");

        employeeProjects.put("coder", projects);

        System.out.println(department);
        System.out.println(department.getEmployeeProjects().size());
        System.out.println(employeeProjects.size());

    }
}
