package com.bridgelabz.basiclevel;
import java.lang.reflect.Method;
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}
public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            // Get the class object
            Class<?> cls = calculator.getClass();
            Method multiplyMethod = cls.getDeclaredMethod("multiply", int.class, int.class);
            // Make the private method accessible
            multiplyMethod.setAccessible(true);
            int result = (int) multiplyMethod.invoke(calculator, 6, 7);
            System.out.println("Result of multiply(6, 7): " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

