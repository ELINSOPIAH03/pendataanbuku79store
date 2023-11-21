package parent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import child.Author;
import child.Comic;
import child.EBook;
import child.Mangaka;
import child.Novel;
import child.Publisher;

public class CommercialBook {
    private String firstName;
    private String lastName;
    private String authorCountry;
    private int authorAge;
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
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Metode untuk mendapatkan negara penulis
    public String getAuthorCountry() {
        return null;
    }

    // Getter untuk authorAge
    public int getAuthorAge() {
        return authorAge;
    }

    
    public String getMangakaRating() {
        // Ambil rating dari objek Mangaka (disesuaikan dengan struktur data)
        return getMangaka().getRating();
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

    public static Map<String, List<CommercialBook>> groupBooksByPublisherCountry(List<CommercialBook> books) {
        Map<String, List<CommercialBook>> groupedBooks = new HashMap<>();

        for (CommercialBook book : books) {
            if (book.getPublisher() != null) {
                Publisher publisher = book.getPublisher();
                String key = publisher.getPublisherName() + " - " + publisher.getCountry();

                groupedBooks.computeIfAbsent(key, k -> new ArrayList<>()).add(book);
            }
        }

        return groupedBooks;
    }

    public static Map<String, List<CommercialBook>> groupBooksByPublisherAndCountry(List<CommercialBook> books) {
        return books.stream()
                .collect(Collectors.groupingBy(book -> {
                    Publisher publisher = book.getPublisher();
                    return publisher.getPublisherName() + " - " + publisher.getCountry();
                }));
    }

    public Mangaka getMangaka() {
        return null;
    }
    public static void displayByMangakaRating(List<CommercialBook> books) {
        // Mengelompokkan Comic berdasarkan rating mangaka
        Map<String, List<CommercialBook>> comicsByRating = books.stream()
                .filter(book -> book instanceof Comic)
                .collect(Collectors.groupingBy(book -> ((Comic) book).getMangakaRating()));
    
        // Menampilkan data Comic berdasarkan rating mangaka
        comicsByRating.forEach((rating, comics) -> {
            System.out.println("Rating: " + rating);
            comics.forEach(comic -> System.out.println("- " + comic.getTitle()));
            System.out.println(); // Untuk memberikan jarak antar rating
        });
    }

    // Metode statis untuk mendapatkan Comic dengan harga paling tinggi dari daftar buku
    public static Optional<CommercialBook> getComicWithHighestPrice(List<CommercialBook> books) {
        return books.stream()
                .filter(book -> book instanceof Comic)
                .max(Comparator.comparingDouble(CommercialBook::getPrice));
    }

     // Metode untuk menampilkan data semua Mangaka
    public static void displayAllMangaka(List<CommercialBook> books) {
        List<Mangaka> allMangaka = Mangaka.getAllMangaka(books);

        if (!allMangaka.isEmpty()) {
            System.out.println("Data semua Mangaka:");
            allMangaka.forEach(mangaka -> {
                System.out.print("\nNama: " + mangaka.getFullName());
                System.out.print("\nCountry: " + mangaka.getCountry());
                System.out.print("\nAge: " + mangaka.getAge());
                System.out.print("\nRating: " + mangaka.getRating() +"\n\n");
            });
        } else {
            System.out.println("Tidak ada data Mangaka yang ditemukan.");
        }
    }
}
