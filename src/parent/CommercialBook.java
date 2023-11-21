package parent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import child.Comic;
import child.EBook;
import child.Mangaka;
import child.Novel;
import child.Publisher;

public class CommercialBook {
    public double getPrice() {
        return 0;
    }

    public void displayInfo() {

    }

    public Publisher getPublisher() {
        return null;  // Anda dapat mengembalikan objek Publisher yang sesuai jika diperlukan
    }
    
    public String getTitle() {
        return null;  // Anda dapat mengembalikan objek Publisher yang sesuai jika diperlukan
    }
    
    // Metode abstrak untuk mendapatkan nama penulis
    public String getAuthorName() {
        return "Unknown Author";
    }

    // Metode untuk mendapatkan negara penulis
    public String getAuthorCountry() {
        return "Unknown Country";
    }

    // Metode statis untuk mendapatkan buku komersial dengan harga tertinggi
    public static void getHighestPricedBooks(List<CommercialBook> books) {
        // Menggunakan stream untuk mendapatkan novel, ebook, dan comic
        List<CommercialBook> novels = books.stream()
                .filter(book -> book instanceof Novel)
                .collect(Collectors.toList());

        List<CommercialBook> ebooks = books.stream()
                .filter(book -> book instanceof EBook)
                .collect(Collectors.toList());

        List<CommercialBook> comics = books.stream()
                .filter(book -> book instanceof Comic)
                .collect(Collectors.toList());

        // Menggunakan Comparator untuk membandingkan harga buku
        Comparator<CommercialBook> priceComparator = Comparator.comparing(CommercialBook::getPrice);

        // Mendapatkan novel dengan harga tertinggi
        Optional<CommercialBook> highestPricedNovel = novels.stream()
                .max(priceComparator);

        highestPricedNovel.ifPresent(book -> System.out.println("Novel dengan harga tertinggi: " + book));

        // Mendapatkan ebook dengan harga tertinggi
        Optional<CommercialBook> highestPricedEBook = ebooks.stream()
                .max(priceComparator);

        highestPricedEBook.ifPresent(book -> System.out.println("EBook dengan harga tertinggi: " + book));

        // Mendapatkan comic dengan harga tertinggi
        Optional<CommercialBook> highestPricedComic = comics.stream()
                .max(priceComparator);

        highestPricedComic.ifPresent(book -> System.out.println("Comic dengan harga tertinggi: " + book));
    }

    // Metode statis untuk mendapatkan buku komersial dengan harga termurah
    public static void getCheapestBooks(List<CommercialBook> books) {
        // Menggunakan stream untuk mendapatkan novel, ebook, dan comic
        List<CommercialBook> novels = books.stream()
                .filter(book -> book instanceof Novel)
                .collect(Collectors.toList());

        List<CommercialBook> ebooks = books.stream()
                .filter(book -> book instanceof EBook)
                .collect(Collectors.toList());

        List<CommercialBook> comics = books.stream()
                .filter(book -> book instanceof Comic)
                .collect(Collectors.toList());

        // Menggunakan Comparator untuk membandingkan harga buku
        Comparator<CommercialBook> priceComparator = Comparator.comparing(CommercialBook::getPrice);

        // Mendapatkan novel dengan harga termurah
        Optional<CommercialBook> cheapestNovel = novels.stream()
                .min(priceComparator);

        cheapestNovel.ifPresent(book -> System.out.println("Novel dengan harga termurah: " + book));

        // Mendapatkan ebook dengan harga termurah
        Optional<CommercialBook> cheapestEBook = ebooks.stream()
                .min(priceComparator);

        cheapestEBook.ifPresent(book -> System.out.println("EBook dengan harga termurah: " + book));

        // Mendapatkan comic dengan harga termurah
        Optional<CommercialBook> cheapestComic = comics.stream()
                .min(priceComparator);

        cheapestComic.ifPresent(book -> System.out.println("Comic dengan harga termurah: " + book));
    }

    public static List<CommercialBook> getAllBooksSortedByPriceRange(List<CommercialBook> books, double minPrice, double maxPrice) {
        return books.stream()
                .filter(book -> book.getPrice() >= minPrice && book.getPrice() <= maxPrice)
                .sorted(Comparator.comparing(CommercialBook::getPrice))
                .collect(Collectors.toList());
    }

    public static void displayBooksByCountryAndPublisher(List<CommercialBook> books, String country, String publisherName) {
        // Filter buku berdasarkan negara dan nama penerbit
        List<CommercialBook> filteredBooks = books.stream()
                .filter(book -> book.getPublisher() != null &&
                                book.getPublisher().getCountry().equalsIgnoreCase(country) &&
                                book.getPublisher().getPublisherName().equalsIgnoreCase(publisherName))
                .collect(Collectors.toList());
    
        // Tampilkan hasil
        if (filteredBooks.isEmpty()) {
            System.out.println("Tidak ada buku yang sesuai dengan kriteria.");
        } else {
            System.out.println("Daftar buku berdasarkan negara dan nama penerbit:");
            System.out.println("Bloomsbury - United Kingdom");
            for (CommercialBook book : filteredBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    public static Map<String, List<CommercialBook>> groupBooksByPublisherAndCountry(List<CommercialBook> books) {
        return books.stream()
                .collect(Collectors.groupingBy(book -> {
                    Publisher publisher = book.getPublisher();
                    return publisher.getPublisherName() + " - " + publisher.getCountry();
                }));
    }

    
}
