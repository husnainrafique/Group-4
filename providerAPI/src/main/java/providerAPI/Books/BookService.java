package providerAPI.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import providerAPI.Provider.Provider;

import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int bookID) {
        return bookRepository.findById(bookID).orElse(null);
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }


    public void updateBook(int bookID, Book book) {
        Book existing = getBookById(bookID);
        existing.setBook_name(book.getBook_name());
        existing.setSummary(book.getSummary());
        existing.setPublisher(book.getPublisher());
        existing.setISBN(book.getISBN());
        existing.setPrice(book.getPrice());
        existing.setProvider(book.getProvider());

        bookRepository.save(existing);
    }

    public void deleteBookById(int bookID) {
        bookRepository.deleteById(bookID);
    }

}
