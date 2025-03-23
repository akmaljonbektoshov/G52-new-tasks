package lesson5.homework;

import java.util.Map;

public class ImmutableStudentGrades {
    private final String studentName;
    private final Map<String, Double> grades;

    public ImmutableStudentGrades(String studentName, Map<String, Double> grades) {
        this.studentName = studentName;
        this.grades = Map.copyOf(grades);
    }

    public String getStudentName() {
        return studentName;
    }

    public Map<String, Double> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "ImmutableStudentGrades{" +
                "studentName='" + studentName + '\'' +
                ", grades=" + grades +
                '}';
    }
}
