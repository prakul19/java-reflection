package com.bridgelabz.intermediatelevel;
import java.lang.reflect.Field;
public class AccessStaticField {
    public static class Configuration {
        private static String API_KEY = "12";
        // Method to display current value
        public static void displayKey() {
            System.out.println("Current API_KEY: " + API_KEY);
        }
    }
    public static void main(String[] args) {
        try {
            Configuration.displayKey();
            Class<?> cls = Configuration.class;
            Field apiKeyField = cls.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            apiKeyField.set(null, "5678");
            Configuration.displayKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

