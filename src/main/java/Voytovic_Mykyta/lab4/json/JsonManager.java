package Voytovic_Mykyta.lab4.json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import Voytovic_Mykyta.lab4.model.Person;
import Voytovic_Mykyta.lab4.model.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonManager {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Person.class, new HumanConverter()) // Користувацький конвертер
            .setPrettyPrinting()
            .create();

    // Метод для перетворення об'єкта у JSON-рядок
    public static String convertToJson(Object entity) {
        return gson.toJson(entity);
    }

    // Метод для перетворення JSON-рядка у об'єкт
    public static <T> T convertFromJson(String jsonContent, Class<T> targetClass) {
        return gson.fromJson(jsonContent, targetClass);
    }

    // Метод для збереження об'єкта у JSON-файл
    public static void writeToJson(Object entity, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(entity, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Метод для завантаження об'єкта з JSON-файлу
    public static <T> T readFromJson(String fileName, Class<T> targetClass) {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, targetClass);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

// Користувацький конвертер для Human
class HumanConverter implements JsonSerializer<Person>, JsonDeserializer<Person> {
    @Override
    public JsonElement serialize(Person src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject();
        jsonObject.addProperty("category", src.getClass().getSimpleName()); // Додаємо категорію
        return jsonObject;
    }

    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String category = jsonObject.get("category").getAsString(); // Отримуємо категорію

        if ("Student".equals(category)) {
            return context.deserialize(jsonObject, Student.class);
        } else {
            throw new JsonParseException("Unknown type: " + category);
        }
    }
}