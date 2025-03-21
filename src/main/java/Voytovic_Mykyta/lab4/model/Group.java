package Voytovic_Mykyta.lab4.model;

import java.util.List;
import java.util.Objects;

// Клас групи
public class Group extends OrganizationUnit {
    private List<Student> students;

    public Group(String title, Person director, List<Student> students) {
        super(title, director);
        this.students = students;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Group() {}

    // Отримання списку студентів у групі
    public List<Student> obtainStudents() {
        return students;
    }

    // Сетер для JSON-десеріалізації
    public void assignStudents(List<Student> students) {
        this.students = students;
    }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Group group = (Group) obj;
        return Objects.equals(title, group.title) &&
                Objects.equals(director, group.director) &&
                Objects.equals(students, group.students);
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(title, director, students);
    }

    @Override
    public String toString() {
        return String.format("Group{name='%s', Head=%s, Students=%s}", title, director, students);
    }
}
