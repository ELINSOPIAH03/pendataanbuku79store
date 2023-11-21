package child;

import parent.CommercialBook;

public class EBook extends CommercialBook{
    private String bookCode;
    private String title;
    private Author author;
    private Publisher publisher;
    private double price;

    // Default Constructor
    public EBook() {
    }

    // Constructor dengan Parameter
    public EBook(String bookCode, String title, Author author, Publisher publisher, double price) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    // Getter & Setter (sesuaikan dengan kebutuhan)
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method untuk menghitung harga
    public void calculatePrice() {
        // Production Cost * 120%
        double productionCost = publisher.getProductionCost();
        this.price = productionCost * 1.2;
    }

    @Override
    public String toString() {
        return "EBook: " + title + ", Author: " + author.getFullName() +
                ", Publisher: " + publisher.getPublisherName() + ", Price: " + price;
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getAuthorName() {
        return author.getFullName();
    }

    @Override
    public String getAuthorCountry() {
        return author.getCountry();
    }

    
}
