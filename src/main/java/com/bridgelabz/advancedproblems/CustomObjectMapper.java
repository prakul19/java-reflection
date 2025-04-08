package com.bridgelabz.advancedproblems;
import java.lang.reflect.Field;
import java.util.Map;
public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                String fieldName = field.getName();
                if (properties.containsKey(fieldName)) {
                    field.setAccessible(true); // allow access to private fields
                    field.set(obj, properties.get(fieldName)); // set field value
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object: " + e.getMessage(), e);
        }
    }
    public static class User {
        private String name;
        private int age;

        public void display() {
            System.out.println("User name: " + name);
            System.out.println("User age: " + age);
        }
    }
    public static void main(String[] args) {
        Map<String, Object> userData = Map.of(
                "name", "Prakul",
                "age", 22
        );
        User user = toObject(User.class, userData);
        user.display();
    }
}

