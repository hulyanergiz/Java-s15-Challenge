package com.workintech.librarySystem.People;

public class FacultyMember extends Reader {
    public FacultyMember(String id, String name) {
        super(id, name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Faculty Member: "+super.getName());
    }
}
