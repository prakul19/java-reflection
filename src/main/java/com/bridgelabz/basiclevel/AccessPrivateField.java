package com.bridgelabz.basiclevel;
import java.lang.reflect.Field;
class Person {
    private int age = 25;
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}
public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            Class<?> cls = person.getClass();
            // Get the age
            Field ageField = cls.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(person, 40);
            int updatedAge = (int) ageField.get(person);
            System.out.println("Updated Age using Reflection: " + updatedAge);
            person.displayAge();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
