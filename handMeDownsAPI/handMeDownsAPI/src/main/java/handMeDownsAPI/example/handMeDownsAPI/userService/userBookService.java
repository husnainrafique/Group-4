package handMeDownsAPI.example.handMeDownsAPI.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handMeDownsAPI.example.handMeDownsAPI.userModel.userBook;
import handMeDownsAPI.example.handMeDownsAPI.userRepository.userBookRepository;

@Service
public class userBookService {

    @Autowired
    private userBookRepository repository;

    public List<userBook> getAllBooks() {
        return repository.findAll();
    }

    public userBook getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public userBook saveBook(userBook book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
    public List<userBook> getBooksByCategory(String category) {
        return repository.findByCategory(category);
    }
    
}
