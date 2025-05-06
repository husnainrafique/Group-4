package handMeDownsAPI.example.handMeDownsAPI.ProviderVisitStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProviderVisitStatsService {

    @Autowired
    private ProviderVisitStatsRepository statsRepo;

    public void recordVisit(int storeID) {
        LocalDate today = LocalDate.now();
        ProviderVisitStats stats = statsRepo.findByStoreIDAndVisitDate(storeID, today)
                .orElse(new ProviderVisitStats(storeID, today, 0));

        stats.setVisitCount(stats.getVisitCount() + 1);
        statsRepo.save(stats);
    }

    public List<ProviderVisitStats> getStatsForStore(int storeID) {
        return statsRepo.findByStoreIDOrderByVisitDateAsc(storeID);
    }
}
