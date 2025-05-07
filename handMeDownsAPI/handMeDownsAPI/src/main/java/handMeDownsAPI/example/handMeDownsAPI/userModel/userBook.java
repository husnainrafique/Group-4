package handMeDownsAPI.example.handMeDownsAPI.userModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userBooks")
public class userBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int bookID;

    private String title;
    private String author;
    private String isbn;
    private String category;
    private String imageUrl;  // Optional field for book cover image URL
    private Double price=0.0;  // Optional field for book price
    private String description;  // Optional field for book description

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "providers_id", referencedColumnName = "storeID", nullable = true)
        @JsonBackReference
        private Provider provider;



    // Default constructor
    public userBook() {}

    // Full constructor
    public userBook(String title, String author, String isbn, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description;}

    public Provider getProvider(){
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    
}
