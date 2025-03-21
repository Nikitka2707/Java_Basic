package Voytovic_Mykyta.lab3.model;

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

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPatronymic() { return patronymic; }
    public Gender getGender() { return gender; }

    @Override
    public String toString() {
        return String.format("%s %s %s (%s)", name, surname, patronymic, gender);
    }
}

