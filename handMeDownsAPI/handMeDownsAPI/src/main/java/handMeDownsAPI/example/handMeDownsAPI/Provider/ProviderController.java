package handMeDownsAPI.example.handMeDownsAPI.Provider;

import handMeDownsAPI.example.handMeDownsAPI.userModel.User;
import handMeDownsAPI.example.handMeDownsAPI.userReview.userReview;
import handMeDownsAPI.example.handMeDownsAPI.userReview.userReviewService;
import handMeDownsAPI.example.handMeDownsAPI.Books.BookService;
import handMeDownsAPI.example.handMeDownsAPI.ProviderVisitStats.ProviderVisitStatsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    //need this in order to instantiate the inventory books
    @Autowired
    private BookService bookService;

    // need this in order to instantiate the statistics service
    @Autowired
    private ProviderVisitStatsService statsService;

    @GetMapping("/all")
    public Object getAllProviders(Model model) {
        model.addAttribute("providerList", providerService.getAllProviders());
        model.addAttribute("title", "All Providers");
        return "provider-all-stores";
    }

    @GetMapping("/{storeID}")
    public Object getStoreById(@PathVariable int storeID, Model model) {
        model.addAttribute("provider", providerService.getProviderById(storeID));
        model.addAttribute("title", "Store #: " + storeID);

        providerService.incrementVisits(storeID);
        statsService.recordVisit(storeID);
        return "provider-details";
    }

    @GetMapping("/profile/{storeID}")
    public String showProfile(@PathVariable int storeID, Model model, HttpServletRequest request) {

        // Retrieve the provider details by storeID
        Provider provider = providerService.getProviderById(storeID);

        // If the provider is not found, redirect to the login page
        if (provider == null) {
            return "redirect:/providers/login";
        }

        model.addAttribute("userIsProvider", true); // Flag to control the reply form
        model.addAttribute("provider", provider);

        return "provider-profile"; // Return the profile view
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "provider-login";
    }

    @PostMapping("/login")
    public String loginProvider(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model) {
        Provider provider = providerService.authenticateProvider(email, password);

        if (provider != null) {
            return "redirect:/providers/profile/" + provider.getStoreID();
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "provider-login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/providers/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        Provider provider = new Provider();
        provider.setState("");
        model.addAttribute("provider", provider);
        model.addAttribute("title", "Create New Provider");
        List<String> states = Arrays.asList("AL", "AK", "AZ", "CA", "IL", "NY", "TX");
        model.addAttribute("states", states);
        return "provider-register";
    }

    @PostMapping("/register")
    public String addNewProvider(@Valid Provider provider,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("states", List.of("AL", "AK", "AZ", "CA", "IL", "NY", "TX"));
            return "provider-register";
        }

        providerService.addNewProvider(provider);
        return "redirect:/providers/all";
    }

    @GetMapping("/edit/{storeID}")
    public String showUpdateForm(@PathVariable int storeID, Model model) {
        model.addAttribute("provider", providerService.getProviderById(storeID));
        model.addAttribute("title", "Edit Provider Profile");

        List<String> states = Arrays.asList("AL", "AK", "AZ", "CA", "IL", "NY", "TX");
        model.addAttribute("states", states);

        return "provider-edit";
    }

    @PostMapping("/edit/{storeID}")
    public Object updateProvider(@PathVariable int storeID, Provider provider) {
        providerService.updateNewProvider(storeID, provider);
        return "redirect:/providers/profile/" + storeID;
    }

    @GetMapping("/delete/{storeID}")
    public Object deleteProviderById(@PathVariable int storeID) {
        providerService.deleteProviderById(storeID);
        return "redirect:/providers/all";
    }


}
