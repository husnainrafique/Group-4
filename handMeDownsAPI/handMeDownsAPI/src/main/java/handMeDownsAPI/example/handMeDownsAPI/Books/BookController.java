package handMeDownsAPI.example.handMeDownsAPI.Books;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ProviderService providerService;

    // Display all books for a specific provider (optional standalone view)
    @GetMapping("/provider/{storeID}")
    public String getBooksByProvider(@PathVariable int storeID, Model model) {
        Provider provider = providerService.getProviderById(storeID);
        if (provider == null) {
            return "redirect:/providers/all";
        }

        model.addAttribute("provider", provider);
        model.addAttribute("books", bookService.getBooksByStoreID(storeID));
        return "provider-books";
    }

    // Show form to add a new book
    @GetMapping("/add/{storeID}")
    public String showAddBookForm(@PathVariable int storeID, Model model) {
        Provider provider = providerService.getProviderById(storeID);
        if (provider == null) {
            return "redirect:/providers/all";
        }

        model.addAttribute("provider", provider);
        model.addAttribute("book", new Book());
        return "book-add";
    }

    // Handle form submission to add a new book
    @PostMapping("/add/{storeID}")
    public String addNewBook(@PathVariable int storeID, @ModelAttribute Book book) {
        Provider provider = providerService.getProviderById(storeID);
        if (provider == null) {
            return "redirect:/providers/all";
        }

        book.setProvider(provider);
        bookService.addNewBook(book);
        return "redirect:/providers/profile/" + storeID;
    }

    @GetMapping("/view/{bookID}")
    public String viewBook(@PathVariable int bookID, Model model) {
        Book book = bookService.getBookById(bookID);

        int storeID = book.getStoreID();
        System.out.println("Book found. Store ID: " + storeID);

        Provider provider = providerService.getProviderById(storeID);
        if (provider == null) {
            System.out.println("Provider not found for Store ID: " + storeID);
            return "error";
        }
        //increment count
        if (book != null) {
            providerService.incrementBooksViewed(storeID);
            model.addAttribute("book", book);
        }

        model.addAttribute("book", book);
        model.addAttribute("provider", provider);

        return "book-details";
    }

    // Show form to edit an existing book
    @GetMapping("/edit/{bookID}")
    public String showEditBookForm(@PathVariable int bookID, Model model) {
        Book book = bookService.getBookById(bookID);
        if (book == null) {
            return "redirect:/providers/all";
        }

        model.addAttribute("book", book);
        return "book-edit";
    }

    // Handle form submission to update an existing book
    @PostMapping("/edit/{bookID}")
    public String updateBook(@PathVariable int bookID, @ModelAttribute Book book) {
        int storeID = book.getProvider().getStoreID();
        bookService.updateBook(bookID, book);
        return "redirect:/providers/profile/" + storeID; // Updated redirect
    }

    // Handle the deletion of a book
    @GetMapping("/delete/{bookID}")
    public String deleteBook(@PathVariable int bookID) {
        Book book = bookService.getBookById(bookID);
        if (book != null) {
            int storeID = book.getProvider().getStoreID();
            bookService.deleteBookById(bookID);
            return "redirect:/providers/profile/" + storeID; // Updated redirect
        }
        return "redirect:/providers/all";
    }
}
