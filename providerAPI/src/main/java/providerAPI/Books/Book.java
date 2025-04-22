package providerAPI.Books;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    //multiple books for a single owner
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    @Column(nullable = false, length = 30)
    private String ISBN;

    @Column(nullable = false, length = 50)
    private String book_name;

    @Column(nullable = false, length = 255)
    private String publisher;

    @Column(nullable = false, length = 255)
    private String summary;

    @Column(nullable = true)
    private double price;

    //getters and setters
    public Book(){
    }

    public Book(int bookID){
        this.bookID = bookID;
    }

    public Book(int bookID, String book_name, String ISBN){
        this.bookID = bookID;
        this.book_name = book_name;
        this.ISBN = ISBN;
    }

    public int getBookID(){
        return bookID;
    }

    public void setBookID(int bookID){
        this.bookID = bookID;
    }

    public void setBook_name(String book_name){
        this.book_name = book_name;
    }

    public String getBook_name(){
        return book_name;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary(){
        return summary;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher(){
        return publisher;
    }


}
