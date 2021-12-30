package by.avp.books.service;

import by.avp.books.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(Integer id);

    Book getBookById(Integer id);

    List<Book> listBooks();
}
