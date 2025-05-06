package handMeDownsAPI.example.handMeDownsAPI.ProviderVisitStats;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ProviderVisitStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int storeID;
    private LocalDate visitDate;
    private int visitCount;

    public ProviderVisitStats() {}

    public ProviderVisitStats(int storeID, LocalDate visitDate, int visitCount) {
        this.storeID = storeID;
        this.visitDate = visitDate;
        this.visitCount = visitCount;
    }

    // Getters and setters
    public int getId() { return id; }
    public int getStoreID() { return storeID; }
    public void setStoreID(int storeID) { this.storeID = storeID; }
    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }
    public int getVisitCount() { return visitCount; }
    public void setVisitCount(int visitCount) { this.visitCount = visitCount; }
}
