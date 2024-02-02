package com.workintech.librarySystem.People;

public class Student extends Reader {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Student: "+super.getName());
    }
}
