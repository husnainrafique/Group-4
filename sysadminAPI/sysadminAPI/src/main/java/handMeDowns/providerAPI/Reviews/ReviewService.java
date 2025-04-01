package handMeDowns.providerAPI.Reviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int reviewID) {
        return reviewRepository.findById(reviewID).orElse(null);
    }

    public void addNewReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReviewById(int reviewID) {
        reviewRepository.deleteById(reviewID);
    }

}
