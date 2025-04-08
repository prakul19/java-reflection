package com.bridgelabz.advancedproblems;
import java.lang.reflect.Method;
class Task {
    public void fastTask() {
        System.out.println("Fast task running");
    }
    public void slowTask() {
        try {
            Thread.sleep(500); // Simulate work
            System.out.println("Slow task running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class MethodTiming {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Task.class;
            Object obj = clazz.getDeclaredConstructor().newInstance();
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getParameterCount() == 0) {
                    System.out.println("Running: " + method.getName());
                    long start = System.nanoTime();
                    method.invoke(obj);
                    long end = System.nanoTime();
                    System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

