package handMeDownsAPI.example.handMeDownsAPI.userControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import handMeDownsAPI.example.handMeDownsAPI.userModel.userBook;
import handMeDownsAPI.example.handMeDownsAPI.userService.userBookService;

@Controller
@RequestMapping("/userBooks")
public class userBookController {

    @Autowired
    private userBookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new userBook());
        return "book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute userBook book) {
        bookService.saveBook(book);
        return "redirect:/books/" + book.getCategory();  // dynamic redirect after submission
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "book-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        userBook book = bookService.getBookById(id);
        String redirectCategory = (book != null && book.getCategory() != null) ? book.getCategory() : "books";
        bookService.deleteBook(id);
        return "redirect:/books/" + redirectCategory;
    }

    @GetMapping("/sell")
public String showSellBooks(Model model) {
    List<userBook> sellBooks = bookService.getBooksByCategory("sell");
    model.addAttribute("books", sellBooks);
    return "sell"; // This should match your sell.ftlh
}

@GetMapping("/donate")
public String showDonateBooks(Model model) {
    List<userBook> donateBooks = bookService.getBooksByCategory("donate");
    model.addAttribute("books", donateBooks);
    return "donate"; // This should match your donate.ftlh
}

    @GetMapping("/trade")
    public String showTradeBooks(Model model) {
    List<userBook> tradeBooks = bookService.getBooksByCategory("trade");
    model.addAttribute("books", tradeBooks);
    return "trade";}

}
