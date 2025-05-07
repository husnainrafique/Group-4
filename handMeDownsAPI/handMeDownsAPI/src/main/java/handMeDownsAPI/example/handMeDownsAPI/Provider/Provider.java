package handMeDownsAPI.example.handMeDownsAPI.Provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import handMeDownsAPI.example.handMeDownsAPI.Books.Book;
import handMeDownsAPI.example.handMeDownsAPI.ProviderReviews.ProviderReview;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeID;

    @NotBlank(message = "Store name is required")
    @Column(nullable = false, length = 50)
    private String storeName;

    @JsonManagedReference
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column
    private List<Book> inventory = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column
    private List<ProviderReview> reviews = new ArrayList<>();

    @NotBlank(message = "First name is required")
    @Column(length = 50)
    private String contactFirstName;

    @NotBlank(message = "Last name is required")
    @Column(length = 50)
    private String contactLastName;

    @Email(message = "Please enter a valid email")
    @NotBlank(message = "Email is required")
    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String city;

    @Column(length = 2)
    private String state;

    @Column(nullable = true)
    private String imageUrl;

    @NotBlank(message = "Password is required")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;

    @Column
    private int totalVisits;

    @Column
    private int booksViewed;

    @Column
    private int reviewsLeft;

    // Constructors
    public Provider() {}

    public Provider(int storeID) {
        this.storeID = storeID;
    }

    public Provider(String storeName, String contactFirstName, String contactLastName, String email, String city, String state, String imageUrl, String password) {
        this.storeName = storeName;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.email = email;
        this.city = city;
        this.state = state;
        this.imageUrl = imageUrl;
        this.password = password;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Book> getInventory() {
        return inventory;
    }

    public void setInventory(List<Book> inventory) {
        this.inventory = inventory;
    }

    public List<ProviderReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProviderReview> reviews) {
        this.reviews = reviews;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getTotalVisits() { return totalVisits; }
    public void setTotalVisits(int totalVisits) { this.totalVisits = totalVisits; }
    public int getBooksViewed() { return booksViewed; }
    public void setBooksViewed(int booksViewed) { this.booksViewed = booksViewed; }
    public int getReviewsLeft() { return reviewsLeft; }
    public void setReviewsLeft(int reviewsLeft) { this.reviewsLeft = reviewsLeft; }
}
