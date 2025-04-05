package G4.demo.review;

import G4.demo.user.User;

import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
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
