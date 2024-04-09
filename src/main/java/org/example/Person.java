package org.example;

import java.util.Optional;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean hasAge() {
        return this.getAge().isPresent();
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(this.age);
    }

    public String getAddress() {
        return this.hasAddress() ? this.address : "Unknown";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age += 1;
        } else {
            System.out.println("age unknown");
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + ", " + this.age + " y.o, from " + this.address;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.surname.hashCode();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(0);
        child.setAddress(this.address);
        return child;
    }
}


