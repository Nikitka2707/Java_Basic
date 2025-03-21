package Voytovic_Mykyta.lab3.element;

import java.util.List;
import java.util.stream.Collectors;

// Клас кафедри
public class Department extends OrganizationUnit {
    private List<Group> groups;

    public Department(String title, Person director, List<Group> groups) {
        super(title, director);
        this.groups = groups;
    }

    // Отримання списку груп
    public List<Group> obtainGroups() { return groups; }

    @Override
    public String toString() {
        String groupList = groups.isEmpty() ? "No groups" : groups.stream()
                .map(Group::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Department{name='%s', Head=%s, Groups=[\n  %s\n]}", title, director, groupList);
    }
}