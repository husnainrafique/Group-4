package handMeDownsAPI.example.handMeDownsAPI.userControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import handMeDownsAPI.example.handMeDownsAPI.userModel.BookRequest;
import handMeDownsAPI.example.handMeDownsAPI.userRepository.BookRequestRepository;

@RestController
@RequestMapping("/requests")
public class BookRequestController {

    @Autowired
    private BookRequestRepository repository;

    @PostMapping
    public String submitRequest(@RequestBody BookRequest request) {
        repository.save(request);
        return "Request submitted successfully!";
    }
}

