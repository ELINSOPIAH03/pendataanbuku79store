package child;

import java.util.List;
import java.util.stream.Collectors;

import parent.CommercialBook;

public class Author extends CommercialBook{
    private String firstName;
    private String lastName;
    private String country;
    private int age;

    // Default Constructor
    public Author() {
    }

     // Constructor dengan Parameter
    public Author(String firstName, String lastName, String country, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
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

    // Method untuk mendapatkan nama lengkap
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Author: " + getFullName() + ", Country: " + country + ", Age: " + age;
    }
}
