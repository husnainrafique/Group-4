package handMeDownsAPI.example.handMeDownsAPI.userReview;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.userModel.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userReviews")
public class userReview {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Integer rating;

    @ManyToOne
    private User user;

    // Getters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
