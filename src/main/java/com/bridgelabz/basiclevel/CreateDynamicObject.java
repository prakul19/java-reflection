package com.bridgelabz.basiclevel;
public class CreateDynamicObject {
    static class Student {
        private String name;
        private int id;
        public Student() {
            this.name = "prakul";
            this.id = 1;
        }
        // Method to display student info
        public void displayInfo() {
            System.out.println("Student Name: " + name);
            System.out.println("Student ID: " + id);
        }
    }
    public static void main(String[] args) {
        try {
            // Get Class object for Student
            Class<?> cls = Class.forName("com.bridgelabz.basiclevel.CreateDynamicObject$Student");
            // Create an instance using reflection
            Object obj = cls.getDeclaredConstructor().newInstance();
            Student student = (Student) obj;
            student.displayInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

