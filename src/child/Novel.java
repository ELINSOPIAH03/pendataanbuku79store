package child;

import parent.CommercialBook;

public class Novel extends CommercialBook{
    private String bookCode;
    private String title;
    private Novelis author;
    private Publisher publisher;
    private double price;
    private String genre;
    private Novelis novelis;

    // Default Constructor
    public Novel() {
    }

    // Constructor dengan Parameter
    public Novel(String bookCode, String title, Novelis author, Publisher publisher, double price, String genre) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
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

    public Novelis getAuthor() {
        return author;
    }

    public void setAuthor(Novelis author) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Novelis getNovelis() {
        return this.novelis;
    }

    // Method untuk menghitung harga
    public void calculatePrice() {
        // Berdasarkan Rating Novelis
        double productionCost = publisher.getProductionCost();
        if ("New Commer".equalsIgnoreCase(author.getRating())) {
            this.price = productionCost * 1.25;
        } else if ("Good".equalsIgnoreCase(author.getRating())) {
            this.price = productionCost * 1.35;
        } else if ("Best Seller".equalsIgnoreCase(author.getRating())) {
            this.price = productionCost * 1.5;
        }
    }

    

    @Override
    public String toString() {
        return "Novel: " + title + ", Author: " + author.getFullName() +
                ", Publisher: " + publisher.getPublisherName() + ", Price: " + price + ", Genre: " + genre;
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
