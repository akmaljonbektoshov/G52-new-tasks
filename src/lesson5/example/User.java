package lesson5.example;

import java.util.Arrays;
import java.util.Map;

public final class User {
    private final String fullName;
    private final String[] emails;
    private final Map<Integer, Cource>  courses;

    public User(String fullName, String[] emails, Map<Integer, Cource> courses) {
        this.fullName = fullName;
        this.emails = Arrays.copyOf(emails, emails.length);
        this.courses = Map.copyOf(courses);
    }

    public String getFullName() {
        return fullName;
    }

    public String[] getEmails() {
        return emails;
    }

    public Map<Integer, Cource> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "\nUser {" +
                "\nfullName = '" + fullName + '\'' +
                "\nemails = " + Arrays.toString(emails) +
                "\ncourses = " + courses +
                "\n" + '}';
    }
}
