package com.workintech.librarySystem;

import com.workintech.librarySystem.People.Author;
import com.workintech.librarySystem.People.MemberRecord;
import com.workintech.librarySystem.People.Reader;

import java.util.*;

public class Library implements Searchable {
    private Map<String, Book> books;
    private Map<String, Reader> readers;
    private Map<String, Author> authors;
    private Map<String,String> bookLendings;

    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
        this.authors = new HashMap<>();
        this.bookLendings = new HashMap<>();
    }

    public void registerReader(Reader reader){
        if(!readers.containsKey(reader.getId())){
            MemberRecord memberRecord=new MemberRecord(reader.getId(),reader.getName(),new Date(),0,"Address","111111111111");
            reader.setMemberRecord(memberRecord);
            readers.put(reader.getId(), reader);
            System.out.println("Registered reader: "+reader.getName()+" with memberId: "+reader.getId());
        }else{
            System.out.println("Reader "+reader.getName()+"("+reader.getId()+") already exists.");
        }
    }
    String generateID() {
        return UUID.randomUUID().toString();
    }
    public Author addAuthor(String authorName){
        if(!authors.containsKey(authorName)){
            Author newAuthor=new Author(generateID(),authorName);
            authors.put(authorName,newAuthor);
            System.out.println("Author does not exist.New Author " + authorName);
        }else{
            System.out.println("Author "+authorName+" already exists.");
        }
        return authors.get(authorName);
    }

    public void newBook(String bookId,String bookName, String authorName,BookTypes bookType){
        Author author=addAuthor(authorName);
        Book book=new Book(bookId,bookType,bookName,author);
        books.put(book.getBookID(),book);
        System.out.println("Book " + book.getBookName() + " added successfully.");
    }

    @Override
    public Book searchByBookId(String id) {
        for(Book book: books.values()) {
            if (book.getBookID().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> searchByBookName(String bookName) {
        List<Book> foundBooks=new ArrayList<>();
        for(Book book: books.values()){
            if(book.getBookName().equalsIgnoreCase(bookName)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> searchByAuthor(String authorName) {
        List<Book> foundBooks=new ArrayList<>();
        for(Book book: books.values()){
            if(book.getAuthor().getName().equalsIgnoreCase(authorName)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> searchByBookTypes(BookTypes bookType) {
        List<Book> foundBooks=new ArrayList<>();
        for(Book book: books.values()){
            if(book.getBookType()==bookType){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


    public void updateBook(Book bookToUpdate, String newBookName, String newAuthorName, String newBookType){
        bookToUpdate.setBookName(newBookName.isEmpty()?bookToUpdate.getBookName():newBookName);
        if(!newAuthorName.isEmpty()){
            bookToUpdate.setAuthor(addAuthor(newAuthorName));
        }
        bookToUpdate.setBookType(newBookType.isEmpty()?bookToUpdate.getBookType():BookTypes.valueOf(newBookType));
        System.out.println("Book updated succesfully. Book: " + bookToUpdate);
    }
    public void deleteBook(String bookId){
        books.remove(bookId);
        System.out.println("Book "+bookId+" is deleted succesfully");
    }

    public void showBooks(){
        for(Book book:books.values()){
            System.out.println(book.getBookName()+"("+book.getAuthor().getName()+")");
        }
    }
    public void lendBook(String bookID,String readerID){
        if(books.containsKey(bookID)&&!bookLendings.containsKey(bookID)){
            Reader reader=readers.get(readerID);
            if(reader!=null&&reader.getMemberRecord().canBarrowBook()){
                bookLendings.put(bookID,readerID);
                reader.getMemberRecord().incBookIssued();
                reader.getMemberRecord().payBill();
                System.out.println("Book "+bookID+" has been lent to reader");
            }else{
                System.out.println("Book is not available or already rent");
            }
        }
    }
    public void takeBackBook(String bookID){
        if(bookLendings.containsKey(bookID)){
            String readerID=bookLendings.remove(bookID);
            Reader reader=readers.get(readerID);
            reader.getMemberRecord().decBookIssued();
            reader.getMemberRecord().refundForReturning();
            System.out.println("Book "+bookID+" has been returned to library.");
        }else{
            System.out.println("This book is not currently lent out");
        }
    }
    public void printLibrary(){
        System.out.println("Books:");
        for (Book book : books.values()) {
            System.out.println(book.getBookName() + " by " + book.getAuthor().getName());
        }

        System.out.println("Authors:");
        for (Author author : authors.values()) {
            author.whoYouAre();
            author.showBooks();
        }

        System.out.println("Readers:");
        for (Reader reader : readers.values()) {
            reader.whoYouAre();
            reader.showBooks();
        }
    }


}
