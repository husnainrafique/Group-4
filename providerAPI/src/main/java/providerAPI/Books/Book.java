package providerAPI.Books;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import providerAPI.Provider.Provider;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    @ManyToOne
    @JoinColumn(name = "providers_id", nullable = true)
    @JsonBackReference
    private Provider provider;

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

//    public Book(Provider provider,int bookID, String book_name, String ISBN){
//        this.provider = provider;
//        this.bookID = bookID;
//        this.book_name = book_name;
//        this.ISBN = ISBN;
//    }
//
//    public Book(Provider provider,int bookID, String book_name, String ISBN, double price){
//        this.provider = provider;
//        this.bookID = bookID;
//        this.book_name = book_name;
//        this.ISBN = ISBN;
//        this.price = price;
//    }
//
//    public Book(Provider provider,int bookID, String book_name, String ISBN, double price, String publisher){
//        this.provider = provider;
//        this.bookID = bookID;
//        this.book_name = book_name;
//        this.ISBN = ISBN;
//        this.price = price;
//        this.publisher = publisher;
//    }
//
    public Book(Provider provider,int bookID, String book_name, String ISBN, double price, String publisher, String summary){
        this.provider = provider;
        this.bookID = bookID;
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.price = price;
        this.publisher = publisher;
        this.summary = summary;
    }

    public int getBookID(){
        return bookID;
    }

    public void setBookID(int bookID){
        this.bookID = bookID;
    }

    public Provider getProvider(){
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", provider=" + provider +
                ", ISBN='" + ISBN + '\'' +
                ", book_name='" + book_name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                '}';
    }
}
