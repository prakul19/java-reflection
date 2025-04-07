package com.bridgelabz.intermediatelevel;
import java.lang.reflect.Method;
import java.util.Scanner;
public class DynamicMethodCall {
    public static class MathOperations {
        public int add(int a, int b) {
            return a + b;
        }
        public int subtract(int a, int b) {
            return a - b;
        }
        public int multiply(int a, int b) {
            return a * b;
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter operation (add / subtract / multiply): ");
            String methodName = scanner.nextLine();
            // parameters
            System.out.print("Enter first number: ");
            int a = scanner.nextInt();
            System.out.print("Enter second number: ");
            int b = scanner.nextInt();
            // Get Class object
            Class<?> cls = MathOperations.class;
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method method = cls.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(obj, a, b);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found. Please enter a valid operation.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

