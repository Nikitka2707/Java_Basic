package Voytovic_Mykyta.lab5;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    /**
     * Отримує список всіх студентів із бази даних.
     * @return Список об'єктів Student
     */
    public List<Student> fetchAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM students";

        try (Connection databaseConnection = DatabaseConnector.establishConnection();
             PreparedStatement preparedStatement = databaseConnection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("student_card_number")
                ));
            }
        } catch (Exception databaseError) {
            databaseError.printStackTrace();
        }
        return studentList;
    }

    /**
     * Отримує список студентів, народжених у вказаному місяці.
     * @param birthMonth Місяць народження у форматі MM
     * @return Список студентів, народжених у цьому місяці
     */
    public List<Student> fetchStudentsByBirthMonth(String birthMonth) {
        List<Student> studentList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM students WHERE MONTH(birth_date) = ?";

        if (DatabaseConnector.establishConnection() == null) {
            throw new IllegalStateException("❌ База даних не підключена!");
        }

        try (Connection databaseConnection = DatabaseConnector.establishConnection();
             PreparedStatement preparedStatement = databaseConnection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, Integer.parseInt(birthMonth));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("birth_date"),
                        resultSet.getString("record_book_number")
                ));
            }
        } catch (Exception databaseError) {
            databaseError.printStackTrace();
        }
        return studentList;
    }
}

