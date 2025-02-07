package com.springboot.restcrud.entity;
//Java POJO CLASS
//A plain old Java object (POJO) is a class definition that is not tied to
// any Java framework so any Java program can use itA plain old Java object (POJO) is
// a class definition that is not tied to any Java framework so any Java program can use it
public class Student {
    private String firstName;
    private String lastName;

    Student()
    {

    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
