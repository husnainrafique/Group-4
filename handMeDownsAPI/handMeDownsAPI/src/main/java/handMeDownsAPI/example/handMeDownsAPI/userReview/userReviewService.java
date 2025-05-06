package handMeDownsAPI.example.handMeDownsAPI.userReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userReviewService {
    @Autowired
    private userReviewRepository reviewRepository;

    public userReview saveReview(userReview review) {
        return reviewRepository.save(review);
    }

    public userReview getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }


}
