package com.workintech.librarySystem.People;

import com.workintech.librarySystem.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class Reader extends Person implements BookDisplayable {
    private List<Book> books;
    private MemberRecord memberRecord;

    public Reader(String id, String name) {
        super(id, name);
        this.books=new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    public void setMemberRecord(MemberRecord memberRecord) {
        this.memberRecord = memberRecord;
    }

    @Override
    public void showBooks() {
        for(Book book:books){
            System.out.println(book.getBookName()+" by "+book.getAuthor().getName());
        }
    }
}
