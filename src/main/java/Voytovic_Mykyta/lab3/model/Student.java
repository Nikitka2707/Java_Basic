package Voytovic_Mykyta.lab3.model;

// Клас студента
public class Student extends Person {
    public Student(String name, String surname, String patronymic, Gender gender) {
        super(name, surname, patronymic, gender);
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }
}