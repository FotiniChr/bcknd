package com.example.demobcknd.model;

public class person{
    String id;
    String first_name;
    int age;

    public person() {
    }

    public person(String id, String first_name, int age) {
        this.id = id;
        this.first_name = first_name;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public person id(String id) {
        this.id = id;
        return this;
    }

    public person first_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public person age(int age) {
        this.age = age;
        return this;
    }

   

}