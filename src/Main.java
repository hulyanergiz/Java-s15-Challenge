import com.workintech.librarySystem.Book;
import com.workintech.librarySystem.BookTypes;
import com.workintech.librarySystem.Library;
import com.workintech.librarySystem.People.FacultyMember;
import com.workintech.librarySystem.People.Reader;
import com.workintech.librarySystem.People.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        Scanner scanner=new Scanner(System.in);
        int option;
        do {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book");
            System.out.println("3. Update a book's information");
            System.out.println("4. Delete Book");
            System.out.println("5. List All Books From a Book type");
            System.out.println("6. List All Books From an Author");
            System.out.println("7. Lend Book");
            System.out.println("8. Take Back Book");
            System.out.println("9. Add Register to Library");
            System.out.println("10. Print Library");
            System.out.println("11. Add Sample Data");
            System.out.println("0. Exit");
            System.out.print("Please enter an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("ADD A NEW BOOK");
                    System.out.print("Enter book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter book type (only JOURNAL, STUDYBOOK, MAGAZINE): ");
                    String bookType = scanner.nextLine();

                    library.newBook(bookID, bookName, authorName, BookTypes.valueOf(bookType));
                    break;
                case 2:
                    System.out.println("SEARCH FOR A BOOK");
                    System.out.print("Enter search key (only name, isbn, author, booktype): ");
                    String key = scanner.nextLine();
                    List<Book> books = new ArrayList<>();
                    switch (key) {
                        case "name":
                            System.out.print("Enter Book Name: ");
                            String bookName1 = scanner.nextLine();
                            books.addAll(library.searchByBookName(bookName1));
                            break;
                        case "isbn":
                            System.out.print("Enter Book ISBN: ");
                            String bookId = scanner.nextLine();
                            books.add(library.searchByBookId(bookId));
                            break;
                        case "author":
                            System.out.print("Enter Book Author Name: ");
                            String authorName2 = scanner.nextLine();
                            books.addAll(library.searchByAuthor(authorName2));
                            break;
                        case "booktype":
                            System.out.print("Enter Book Type (only JOURNAL, STUDYBOOK, MAGAZINE): ");
                            String bookType2 = scanner.nextLine();
                            books.addAll(library.searchByBookTypes(BookTypes.valueOf(bookType2)));
                            break;
                    }

                    System.out.println("Search results: " + books.size());
                    for (Book book : books) {
                        System.out.println(book.getBookName());
                    }
                    break;
                case 3:
                    System.out.println("UPDATE A BOOK'S INFORMATION");
                    System.out.print("Enter the book ID to update: ");
                    String bookID2 = scanner.nextLine();

                    Book bookToUpdate = library.searchByBookId(bookID2);
                    if (bookToUpdate != null) {
                        System.out.print("Enter new book name (current: " + bookToUpdate.getBookName() + "): ");
                        String newBookName = scanner.nextLine();
                        System.out.print("Enter new author name (current: " + bookToUpdate.getAuthor().getName() + "): ");
                        String newAuthorName = scanner.nextLine();
                        System.out.print("Enter new book type (only JOURNAL, STUDYBOOK, MAGAZINE) (current: " + bookToUpdate.getBookType() + "): ");
                        String newBookType = scanner.nextLine();

                        library.updateBook(bookToUpdate, newBookName, newAuthorName, newBookType);
                    } else {
                        System.out.println("No book found with ID: " + bookID2);
                    }
                    break;
                case 4:
                    System.out.println("DELETE BOOK");
                    System.out.print("Enter book ID: ");
                    String bookID3 = scanner.nextLine();
                    library.deleteBook(bookID3);
                    break;
                case 5:
                    System.out.println("LIST ALL BOOKS FROM A BOOK TYPE");
                    System.out.print("Enter Book Type(only JOURNAL,STUDYBOOK,MAGAZINE: ");
                    String bookType2 = scanner.nextLine();
                    List<Book> books2 = library.searchByBookTypes(BookTypes.valueOf(bookType2));
                    System.out.println("Results: " + books2.size());
                    for (Book book : books2) {
                        System.out.println(book.getBookName());
                    }
                    break;
                case 6:
                    System.out.println("LIST ALL BOOKS FROM AN AUTHOR");
                    System.out.print("Enter Author Name: ");
                    String authorName3 = scanner.nextLine();
                    List<Book> books3 = library.searchByAuthor(authorName3);
                    System.out.println("Results: " + books3.size());
                    for (Book book : books3) {
                        System.out.println(book.getBookName());
                    }
                    break;
                case 7:
                    System.out.println("REGISTER A READER TO LIBRARY");
                    System.out.print("Enter reader ID: ");
                    String readerID2 = scanner.nextLine();
                    System.out.print("Enter reader name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter reader type (student or faculty): ");
                    String type = scanner.nextLine();
                    library.registerReader(type.equals("student") ? new Student(readerID2, name) : new FacultyMember(readerID2, name));
                    break;
                case 8:
                    System.out.println("LEND BOOK");
                    System.out.print("Enter the book ID to lend: ");
                    String bookID4 = scanner.nextLine();
                    System.out.print("Enter the reader ID: ");
                    String readerID = scanner.nextLine();
                    library.lendBook(bookID4, readerID);
                    break;
                case 9:
                    System.out.println("TAKE BACK BOOK");
                    System.out.print("Enter the book ID to take back: ");
                    String bookID5 = scanner.nextLine();

                    library.takeBackBook(bookID5);
                    break;
                case 10:
                    System.out.println("PRINT LIBRARY");
                    library.printLibrary();
                    break;
                case 11:
                    library.newBook("1","Harry Potter and the Sorcerer's Stone", "J.K. Rowling",BookTypes.JOURNAL);
                    library.newBook("2","1984", "George Orwell", BookTypes.JOURNAL);
                    library.newBook("3","Murder on the Orient Express", "Agatha Christie", BookTypes.JOURNAL);
                    Reader reader1 = new Student("R001", "Alice");
                    Reader reader2 = new Student("R002", "Bob");
                    Reader reader3 = new Student("R003", "Charlie");
                    Reader reader4 = new FacultyMember("R004", "Dave");
                    Reader reader5 = new FacultyMember("R005", "Eve");
                    Reader reader6 = new FacultyMember("R006", "Frank");

                    library.registerReader(reader1);
                    library.registerReader(reader2);
                    library.registerReader(reader3);
                    library.registerReader(reader4);
                    library.registerReader(reader5);
                    library.registerReader(reader6);
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}