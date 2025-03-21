package Voytovic_Mykyta.lab4.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Клас кафедри
public class Department extends OrganizationUnit {
    private List<Group> groups;

    public Department(String title, Person director, List<Group> groups) {
        super(title, director);
        this.groups = groups;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Department() {}

    // Отримання списку груп
    public List<Group> obtainGroups() { return groups; }

    // Сетер для JSON-десеріалізації
    public void assignGroups(List<Group> groups) {
        this.groups = groups;
    }

    // Перевизначений equals() для порівняння об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department department = (Department) obj;
        return Objects.equals(title, department.title) &&
                Objects.equals(director, department.director) &&
                Objects.equals(groups, department.groups);
    }

    // Перевизначений hashCode() для коректної роботи у HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(title, director, groups);
    }

    @Override
    public String toString() {
        String groupList = groups.isEmpty() ? "No groups" : groups.stream()
                .map(Group::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Department{name='%s', Head=%s, Groups=[\n  %s\n]}", title, director, groupList);
    }
}