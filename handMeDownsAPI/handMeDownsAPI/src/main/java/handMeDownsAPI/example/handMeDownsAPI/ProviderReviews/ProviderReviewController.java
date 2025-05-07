package handMeDownsAPI.example.handMeDownsAPI.ProviderReviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderService;

@Controller
@RequestMapping("/provider-reviews")
public class ProviderReviewController {

    @Autowired
    private ProviderReviewService reviewService;

    @Autowired
    private ProviderService providerService;

    // Show reviews for a specific provider
    @GetMapping("/provider/{storeID}")
    public String getReviewsByProvider(@PathVariable int storeID, Model model) {
        Provider provider = providerService.getProviderById(storeID);
        model.addAttribute("provider", provider);
        model.addAttribute("reviews", reviewService.getReviewsByProviderId(storeID));
        return "provider-reviews";
    }

    @PostMapping("/reply/{reviewID}")
    public String replyToReview(@PathVariable int reviewID,
            @RequestParam("reply") String reply) {
        ProviderReview review = reviewService.getReviewById(reviewID);
        if (review == null) {
            // Handle not found gracefully (e.g., redirect or show error)
            return "redirect:/error";
        }
        int storeID = review.getProvider().getStoreID();
        review.setReply(reply);
        reviewService.updateReview(reviewID, review);
        return "redirect:/providers/profile/" + storeID;
    }

    @PostMapping("/add")
    public String addReview(@ModelAttribute ProviderReview review) {

        int storeID = review.getProvider().getStoreID();
        reviewService.addReviewToProvider(storeID, review);

        // increment # of reviews for store
        providerService.incrementReviewsLeft(storeID);
        return "redirect:/provider-reviews/provider/" + storeID;
    }

    @PostMapping("/submit")
    public String submitReview(@RequestParam int providerID, @RequestParam int authorID,
            @RequestParam int rating, @RequestParam String content,
            @RequestParam String status) {
        Provider provider = providerService.getProviderById(providerID); // Find provider
        ProviderReview review = new ProviderReview(provider, rating, authorID, content, status);
        ProviderReviewService.saveReview(review);

        return "redirect:/providers/view/" + providerID; // Redirect after review submission
    }

    @GetMapping("/delete/{reviewID}")
    public String deleteReview(@PathVariable int reviewID) {
        ProviderReview review = reviewService.getReviewById(reviewID);
        if (review != null) {
            int storeID = review.getProvider().getStoreID();
            reviewService.deleteReview(reviewID);
            return "redirect:/admins/manageReviews";
        }
        return "redirect:/error";
    }

}
