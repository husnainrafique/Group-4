package providerAPI.Reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{reviewID}")
    public Object getReviewById(@PathVariable int reviewID) {
        return new ResponseEntity<>(reviewService.getReviewById(reviewID), HttpStatus.OK);
    }

    @PostMapping("/add-review")
    public Object addNewReview(@RequestBody Review review) {
        reviewService.addNewReview(review);
        return new ResponseEntity<>("New Review Successfully Created!", HttpStatus.CREATED);
    }

    @PutMapping("/update/{reviewID}")
    public Object updateReview(@PathVariable int reviewID, @RequestBody Review review) {
        reviewService.addNewReview(review);
        return new ResponseEntity<>(reviewService.getReviewById(reviewID), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reviewID}")
    public Object deleteReview(int reviewID) {
        reviewService.deleteReviewById(reviewID);
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

}

