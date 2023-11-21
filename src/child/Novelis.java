package child;

import parent.CommercialBook;

public class Novelis extends CommercialBook{
    private String firstName;
    private String lastName;
    private String country;
    private int age;
    private boolean serial;
    private String rating;

    // Default Constructor
    public Novelis() {
    }

    // Constructor dengan Parameter
    public Novelis(String firstName, String lastName, String country, int age, boolean serial, String rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
        this.serial = serial;
        this.rating = rating;
    }

    // Getter & Setter (sesuaikan dengan kebutuhan)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSerial() {
        return serial;
    }

    public void setSerial(boolean serial) {
        this.serial = serial;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    // Method untuk mendapatkan nama lengkap
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Novelis: " + getFullName() + ", Country: " + country + ", Age: " + age +
                ", Serial: " + serial + ", Rating: " + rating;
    }
}
