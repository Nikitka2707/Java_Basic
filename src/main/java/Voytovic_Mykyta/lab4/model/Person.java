package Voytovic_Mykyta.lab4.model;

import java.util.Objects;

// Абстрактний клас особи
public abstract class Person {
    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;

    public enum Gender { MALE, FEMALE }

    public Person(String name, String surname, String patronymic, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Person() {}

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPatronymic() { return patronymic; }
    public Gender getGender() { return gender; }

    // Сетери для JSON-десеріалізації
    public void assignName(String name) { this.name = name; }
    public void assignSurname(String surname) { this.surname = surname; }
    public void assignPatronymic(String patronymic) { this.patronymic = patronymic; }
    public void assignGender(Gender gender) { this.gender = gender; }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(patronymic, person.patronymic) &&
                gender == person.gender;
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, gender);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s (%s)", name, surname, patronymic, gender);
    }
}

