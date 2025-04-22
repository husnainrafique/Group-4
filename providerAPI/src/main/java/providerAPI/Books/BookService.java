package providerAPI.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteBookById(int bookID) {
        bookRepository.deleteById(bookID);
    }

}
