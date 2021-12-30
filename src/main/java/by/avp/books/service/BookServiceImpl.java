package by.avp.books.service;

import by.avp.books.dao.BookDao;
import by.avp.books.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Transactional
    public void removeBook(Integer id) {
        this.bookDao.removeBook(id);
    }

    @Transactional(readOnly = true)
    public Book getBookById(Integer id) {
        return this.bookDao.getBookById(id);
    }

    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }
}
