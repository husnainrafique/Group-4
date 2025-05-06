package handMeDownsAPI.example.handMeDownsAPI.ProviderReviews;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderReviewService {

    @Autowired
    private ProviderReviewRepository reviewRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public static void saveReview(ProviderReview review) {
    }


    public List<ProviderReview> getReviewsByProviderId(int storeID) {
        return reviewRepository.findByProvider_StoreID(storeID);
    }

    public void addReviewToProvider(int storeID, ProviderReview review) {
        Provider provider = providerRepository.findById(storeID).orElse(null);
        if (provider != null) {
            review.setProvider(provider);
            reviewRepository.save(review);
        }
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public ProviderReview getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public void updateReview(int reviewId, ProviderReview updatedReview) {
        ProviderReview existing = reviewRepository.findById(reviewId).orElse(null);
        if (existing != null) {
            existing.setContent(updatedReview.getContent());
            existing.setRating(updatedReview.getRating());
            existing.setStatus(updatedReview.getStatus());
            existing.setReply(updatedReview.getReply());
            reviewRepository.save(existing);
        }
    }
}
