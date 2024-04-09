package org.example;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("invalid age");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("please, ensure that name and surname had been set");
        }

        Person p;
        if (this.age == null) {
            p = new Person(this.name, this.surname);
        } else {
            p = new Person(this.name, this.surname, this.age);
        }
        if (this.address != null) {
            p.setAddress(this.address);
        }
        return p;
    }
}
