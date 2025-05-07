package handMeDownsAPI.example.handMeDownsAPI.ProviderReviews;

import com.fasterxml.jackson.annotation.JsonBackReference;
import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "provider_reviews")
public class ProviderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "providers_id", referencedColumnName = "storeID", nullable = false)
    @JsonBackReference
    private Provider provider;

    @Column(nullable = false, length = 255)
    private int rating;

    @Column(length = 1000)
    private String content;

    @Column(nullable = false)
    private int authorID;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(length = 1000)
    private String reply; // Provider's reply to the review

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;

    // Constructors
    public ProviderReview() {}

    public ProviderReview(Provider provider, int rating, int authorID, String content, String status) {
        this.provider = provider;
        this.rating = rating;
        this.authorID = authorID;
        this.content = content;
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Getters and Setters
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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
}
