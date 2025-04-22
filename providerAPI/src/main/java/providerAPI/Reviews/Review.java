package providerAPI.Reviews;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int reviewID;

    @Column(nullable = false, length = 255)
    private String rating;

    @Column(nullable = true, length = 255)
    private String content;

    @Column(nullable = false, length = 255)
    private int authorID;

    @Column(nullable = false, length = 255)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;


//rating, content, authorID, status

    public Review(){
    }

    public Review(int reviewID){
        this.reviewID = reviewID;
    }

    public Review(String rating, int authorID, String content, String status, Date createdAt, Date updatedAt) {
        this.rating = rating;
        this.authorID = authorID;
        this.content = content;
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public int getReviewID(){
        return reviewID;
    }

    public void setReviewID(int reviewID){
        this.reviewID = reviewID;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getAuthorID(){
        return authorID;
    }

    public void setAuthorID(int authorID){
        this.authorID = authorID;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
