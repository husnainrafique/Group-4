package providerAPI.Provider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import providerAPI.Books.Book;
import providerAPI.Reviews.Review;

@Entity
@Table(name = "providers")
public class Provider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeID;

    @Column(nullable = false, length = 50)
    private String store_name;

    // multiple books for one inventory
    @JsonManagedReference
    private List<Book> inventory = new ArrayList<>();

    @JsonManagedReference
    private List<Review> reviews = new ArrayList<>();

    @JsonManagedReference
    private List<StatLogs> statistics = new ArrayList<>();


    public List<Book> getInventory() {
        return inventory;
    }

    public void setInventory(List<Book> inventory) {
        this.inventory = inventory;
    }

    public Provider() {}

    public Provider(String store_name, Date createdAt, Date updatedAt) {
        this.store_name = store_name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name){
        this.store_name = store_name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<StatLogs> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<StatLogs> statistics) {
        this.statistics = statistics;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
