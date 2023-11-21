package child;

import parent.CommercialBook;

public class Comic extends CommercialBook {
    private String bookCode;
    private String title;
    private Mangaka author;
    private Publisher publisher;
    private double price;
    private boolean volumeSeries;
    private double tax;
    private Mangaka mangaka;

    // Default Constructor
    // public Comic() {
    // }

    // Constructor dengan Parameter
    public Comic(String bookCode, String title, Mangaka author, Publisher publisher, double price, boolean volumeSeries, double tax) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.volumeSeries = volumeSeries;
        this.tax = tax;
        
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

    public void setAuthor(Mangaka author) {
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

    public boolean isVolumeSeries() {
        return volumeSeries;
    }

    public void setVolumeSeries(boolean volumeSeries) {
        this.volumeSeries = volumeSeries;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Mangaka getMangaka() {
        return mangaka;
    }

    // Method untuk menghitung harga dan pajak
    public void calculatePrice() {
        double productionCost = publisher.getProductionCost();

        // Berdasarkan Rating Mangaka dan Volume Series
        if ("New Commer".equalsIgnoreCase(author.getRating())) {
            if (volumeSeries) {
                this.price = productionCost * 1.35;
            } else {
                this.price = productionCost * 1.25;
            }
        } else if ("Good".equalsIgnoreCase(author.getRating())) {
            if (volumeSeries) {
                this.price = productionCost * 1.45;
            } else {
                this.price = productionCost * 1.3;
            }
        } else if ("Best Seller".equalsIgnoreCase(author.getRating())) {
            if (volumeSeries) {
                this.price = productionCost * 1.5;
            } else {
                this.price = productionCost * 1.4;
            }
        }

        // Pajak untuk Comic
        this.tax = 0.05 * this.price;
    }

    @Override
    public String toString() {
        return "Comic: " + title + ", Author: " + author.getFullName() +
                ", Publisher: " + publisher.getPublisherName() + ", Price: " + price + ", Volume Series: " + volumeSeries + ", Tax: " + tax;
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
