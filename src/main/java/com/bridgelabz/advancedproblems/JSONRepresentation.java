package com.bridgelabz.advancedproblems;
import java.lang.reflect.Field;
public class JSONRepresentation {
    public static String toJson(Object obj) {
        if (obj == null) return "null";
        StringBuilder json = new StringBuilder();
        Class<?> cls = obj.getClass();
        json.append("{");
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // make private fields accessible
            try {
                String name = field.getName();
                Object value = field.get(obj);
                json.append("\"").append(name).append("\":");
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                if (i != fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json.append("}");
        return json.toString();
    }
    public static class Person {
        private String name;
        private int age;
        private boolean student;
        public Person(String name, int age, boolean student) {
            this.name = name;
            this.age = age;
            this.student = student;
        }
    }
    public static void main(String[] args) {
        Person person = new Person("Prakul", 22, true);
        String json = toJson(person);
        System.out.println("JSON Representation: " + json);
    }
}

