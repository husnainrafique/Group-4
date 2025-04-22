package providerAPI.Provider;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import providerAPI.Books.Book;
import providerAPI.Reviews.Review;
//import sysadminAPI.statLogs.StatLogs;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "providers")
public class Provider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeID;

    @Column(nullable = false, length = 50)
    private String store_name;

    // multiple books for one provider
    //@JsonManagedReference
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> inventory;

    //@JsonManagedReference
    @OneToMany
    private List<Review> reviews;

    //@JsonManagedReference
    //@OneToMany
    //private List<StatLogs> statistics;


    public List<Book> getInventory() {
        return inventory;
    }

    public void setInventory(List<Book> inventory) {
        this.inventory = inventory;
    }

    public Provider() {
    }

    public Provider(String store_name, List<Book> inventory, List<Review> reviews, Date createdAt, Date updatedAt) {
        this.store_name = store_name;
        this.inventory = inventory;
        this.reviews = reviews;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Provider(String store_name, List<Review> reviews, Date createdAt, Date updatedAt) {
        this.store_name = store_name;
        this.reviews = reviews;
        this.createdAt = new Date();
        this.updatedAt = new Date();
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

    public void setStore_name(String store_name) {
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

    /*
    public List<StatLogs> getStatistics() {

        return statistics;
    }

    public void setStatistics(List<StatLogs> statistics) {
        this.statistics = statistics;
    }
    */


    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
