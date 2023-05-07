package org.example;

import lombok.Getter;

@Getter
public class Person {

    private int id;
    private String name;
    private int age;

    public Person(Integer id, String name, int age) {
        if (id == null || id < 1) {
            throw new MyException("No Null ID allowed and ID must be a positive over 0!");
        }
        if (name == null) {
            throw new MyException("No null String name allowed");
        }
        if (age < 0 || age > 120) {
            throw new MyException("Given age is negative! Age must be between 1 and 120");
        }

        this.id = id;
        name = name.replaceAll("[^a-zA-Z]", "");
        if (name == "") {
            throw new MyException("Name value can not be blank!");
        }
        this.name = name;
        this.age = age;
    }
}
