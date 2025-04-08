package com.bridgelabz.advancedproblems;
import java.lang.annotation.*;
import java.lang.reflect.*;
// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

//  class to be injected
class Printer {
    public void printMessage() {
        System.out.println("Hello!");
    }
}
// Class depending on Printer
class HelloWorld {
    @Inject
    private Printer printer;
    public void sayHello() {
        printer.printMessage();
    }
}
// Basic DI container
public class DependencyInjection {
    public static void main(String[] args) {
        try {
            HelloWorld helloWorld = new HelloWorld();
            for (Field field : HelloWorld.class.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    field.set(helloWorld, new Printer());
                }
            }
            helloWorld.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

