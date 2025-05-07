package handMeDownsAPI.example.handMeDownsAPI.Books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int bookID) {
        System.out.println("Fetching book with ID: " + bookID);
        return bookRepository.findById(bookID).orElse(null);
    }



    public void addNewBook(Book book) {
        System.out.println(book.toString());
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

    public List<Book> getBooksByStoreID(int storeID) {
        return bookRepository.findByProviderStoreID(storeID);
    }

}


