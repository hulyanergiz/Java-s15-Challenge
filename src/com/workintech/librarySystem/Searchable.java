package com.workintech.librarySystem;

import java.util.List;

public interface Searchable {
    List<Book> searchByBookName(String bookName);
    List<Book> searchByAuthor(String authorName);
    List<Book> searchByBookTypes(BookTypes bookType);
    Book searchByBookId(String id);
}
