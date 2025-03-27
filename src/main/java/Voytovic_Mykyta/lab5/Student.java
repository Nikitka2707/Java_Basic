package Voytovic_Mykyta.lab5;

public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String studentCardNumber;

    /**
     * Конструктор класу Student.
     * @param studentId ID студента
     * @param lastName Прізвище
     * @param firstName Ім'я
     * @param middleName По батькові
     * @param birthDate Дата народження (у форматі YYYY-MM-DD)
     * @param studentCardNumber Номер студентського квитка
     */
    public Student(int studentId, String lastName, String firstName, String middleName, String birthDate, String studentCardNumber) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.studentCardNumber = studentCardNumber;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, %s %s %s, Дата народження: %s, № заліковки: %s",
                studentId, lastName, firstName, middleName, birthDate, studentCardNumber);
    }

    /**
     * Отримує місяць народження студента із дати формату YYYY-MM-DD.
     * @return Місяць народження у форматі MM
     */
    public String extractBirthMonth() {
        return birthDate.split("-")[1];
    }
}

