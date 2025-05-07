package handMeDownsAPI.example.handMeDownsAPI.userReview;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderService;
import handMeDownsAPI.example.handMeDownsAPI.userModel.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userReviews")
public class userReviewController {
    @Autowired
    private userReviewService reviewService;

    @Autowired
    private ProviderService providerService;

    @PostMapping
    public ResponseEntity<userReview> createReview(@RequestBody userReview review) {
        userReview savedReview = reviewService.saveReview(review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<userReview> getReviewById(@PathVariable Long id) {
        userReview review = reviewService.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }


}
