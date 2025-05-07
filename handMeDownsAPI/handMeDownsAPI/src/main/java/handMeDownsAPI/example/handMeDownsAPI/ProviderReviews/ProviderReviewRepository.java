package handMeDownsAPI.example.handMeDownsAPI.ProviderReviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderReviewRepository extends JpaRepository<ProviderReview, Integer> {
    List<ProviderReview> findByProvider_StoreID(int storeId);

}
