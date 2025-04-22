package providerAPI.Reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public void updateReview(int reviewID, Review review) {
        Review existing = getReviewById(reviewID);
        existing.setAuthorID(review.getAuthorID());
        existing.setContent(review.getContent());
        existing.setRating(review.getRating());
        existing.setStatus(review.getStatus());
        existing.setUpdatedAt(new Date());

        reviewRepository.save(existing);
    }

    public void deleteReview(int reviewID) {

        reviewRepository.deleteById(reviewID);
    }

}
