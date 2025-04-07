package com.bridgelabz.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Prakul Agarwal")
class Book {
}

public class AnnotationRetriever {
    public static void main(String[] args) {
        try {
            // Get Class object for Book
            Class<?> cls = Book.class;

            // Check if the annotation is present
            if (cls.isAnnotationPresent(Author.class)) {
                // Get the annotation
                Author author = cls.getAnnotation(Author.class);
                // Display annotation value
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No @Author annotation found on the class.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

