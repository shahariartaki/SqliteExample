package com.example.taki.sqliteexample;

public class student  {

    private String id;
    private String name;
    private String dept;
    private String number;

    public student() {

    }

    public student(String id, String name, String dept, String number) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getNumber() {
        return number;
    }
}
