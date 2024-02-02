package com.workintech.librarySystem;

import com.workintech.librarySystem.People.Author;
import com.workintech.librarySystem.People.Person;

import java.util.Date;

public class Book {
    private String bookID;
    private BookTypes bookType;
    private String bookName;
    private Author author;
    private double price;
    private String status;
    private Date dateOfPurchase;


    public Book(String bookID, BookTypes bookType, String bookName, Author author, double price, String status, Date dateOfPurchase) {
        this.bookID = bookID;
        this.bookType = bookType;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Book(String bookID, BookTypes bookType, String bookName, Author author) {
        this.bookID = bookID;
        this.bookType = bookType;
        this.bookName = bookName;
        this.author = author;
        this.author.addBook(this);
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public BookTypes getBookType() {
        return bookType;
    }

    public void setBookType(BookTypes bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", bookType=" + bookType +
                ", bookName='" + bookName + '\'' +
                ", author=" + author.getName() +
                '}';
    }
}
