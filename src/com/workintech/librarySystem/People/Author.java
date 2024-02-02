package com.workintech.librarySystem.People;

import com.workintech.librarySystem.Book;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person implements BookDisplayable{
   private Set<Book> books;

   public Author(String id, String name) {
      super(id, name);
      this.books = new HashSet<>();
   }

   public Set<Book> getBooks() {
      return books;
   }

   public void addBook(Book book){
      books.add(book);
   }
   @Override
   public void whoYouAre() {
      System.out.println("Author name: "+super.getName());
   }

   @Override
   public void showBooks() {
      System.out.println("Author "+super.getName()+"'s books:");
      for(Book book:books){
         System.out.println(book.getBookName());
      }
   }
}
