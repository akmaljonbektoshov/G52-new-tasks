package lesson5.example;

import java.util.Arrays;

public final class ImmuttableClass {
    private final String name;
    private final int age;
    int[] arr;

    public ImmuttableClass(String name, int age,  int[] arr) {
        this.name = name;
        this.age = age;
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getArr() {
        return arr;
    }

    @Override
    public String toString() {
        return "ImmuttableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
