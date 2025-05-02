package providerAPI.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public Object getAllBooks() {

        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookID}")
    public Object getBookById(@PathVariable int bookID) {
        return new ResponseEntity<>(bookService.getBookById(bookID), HttpStatus.OK);
    }

    @PostMapping("/add-book")
    public Object addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
        return new ResponseEntity<>("New Book Successfully Created!", HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookID}")
    public Object updateBook(@PathVariable int bookID, @RequestBody Book book) {
        bookService.updateBook(bookID, book);
        return new ResponseEntity<>(bookService.getBookById(bookID), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookID}")
    public Object deleteBook(@PathVariable int bookID) {
        bookService.deleteBookById(bookID);
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }


}
