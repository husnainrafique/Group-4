package handMeDownsAPI.example.handMeDownsAPI.ProviderVisitStats;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProviderVisitStatsRepository extends JpaRepository<ProviderVisitStats, Integer> {
    Optional<ProviderVisitStats> findByStoreIDAndVisitDate(int storeID, LocalDate visitDate);
    List<ProviderVisitStats> findByStoreIDOrderByVisitDateAsc(int storeID);
}
