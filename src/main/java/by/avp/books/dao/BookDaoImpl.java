package by.avp.books.dao;

import by.avp.books.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    public static final Logger LOG = LogManager.getLogger(BookDaoImpl.class);

    private final SessionFactory sessionFactory;

    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        LOG.info("Book successfuly save. Book details: {}", book);
    }

    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        LOG.info("Book successfuly update. Book details: {}", book);
    }

    public void removeBook(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, new Integer(id));
        if (book != null) {
            session.delete(book);
        }
        LOG.info("Book successfuly remove. Book details: {}", book);
    }

    public Book getBookById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, new Integer(id));
        LOG.info("Book successfuly loaded. Book details: {}", book);
        return book;
    }
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();
        for (Book book: bookList) {
            LOG.info("Book from list: {}", book);
        }
        return bookList;
    }
}
