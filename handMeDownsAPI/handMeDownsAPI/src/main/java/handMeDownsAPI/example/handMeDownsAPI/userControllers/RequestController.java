package handMeDownsAPI.example.handMeDownsAPI.userControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import handMeDownsAPI.example.handMeDownsAPI.userModel.BookRequest;
import handMeDownsAPI.example.handMeDownsAPI.userRepository.BookRequestRepository;

@Controller
public class RequestController {

    @Autowired
    private BookRequestRepository requestRepository;

    @GetMapping("/requests")
    public String viewAllRequests(Model model) {
        List<BookRequest> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
        return "requests"; // This refers to templates/requests.ftlh
    }
}
