package Voytovic_Mykyta.lab4.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

// Клас факультету
public class Faculty extends OrganizationUnit {
    private List<Department> departments;

    public Faculty(String title, Person director, List<Department> departments) {
        super(title, director);
        this.departments = departments;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Faculty() {}

    // Отримання списку кафедр
    public List<Department> obtainDepartments() { return departments; }

    // Сетер для JSON-десеріалізації
    public void assignDepartments(List<Department> departments) {
        this.departments = departments;
    }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Faculty faculty = (Faculty) obj;
        return Objects.equals(title, faculty.title) &&
                Objects.equals(director, faculty.director) &&
                Objects.equals(departments, faculty.departments);
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(title, director, departments);
    }

    @Override
    public String toString() {
        String departmentList = departments.isEmpty() ? "No departments" : departments.stream()
                .map(Department::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Faculty{name='%s', Head=%s, Departments=[\n  %s\n]}", title, director, departmentList);
    }
}
