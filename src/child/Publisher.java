package child;

import parent.CommercialBook;

public class Publisher extends CommercialBook{
    private String publisherName;
    private String country;
    private double productionCost;

    // Default Constructor
    public Publisher() {
    }

    // Constructor dengan Parameter
    public Publisher(String publisherName, String country, double productionCost) {
        this.publisherName = publisherName;
        this.country = country;
        this.productionCost = productionCost;
    }

    // Getter & Setter (sesuaikan dengan kebutuhan)
    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    @Override
    public String toString() {
        return "Publisher: " + publisherName + ", Country: " + country + ", Production Cost: " + productionCost;
    }
}
