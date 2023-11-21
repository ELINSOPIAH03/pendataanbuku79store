import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;

import child.Author;
import child.Comic;
import child.EBook;
import child.Mangaka;
import child.Novel;
import child.Novelis;
import child.Publisher;
import parent.CommercialBook;

public class RepositoryBook {
    private List<CommercialBook> allBooks;

    // Default Constructor
    public RepositoryBook() {
        this.allBooks = new ArrayList<>();
        initializeDummyData();
    }

    // public void displayComicByMangakaRating() {
    //     CommercialBook.displayComicByMangakaRating(allBooks);
    // }

    // Method untuk mendapatkan semua buku
    public List<CommercialBook> getAllBook() {
        return allBooks;
    }

    public List<CommercialBook> getCheapestBooks() {
        List<CommercialBook> cheapestBooks = new ArrayList<>();

        // Inisialisasi harga terendah untuk setiap jenis buku
        double cheapestNovelPrice = Double.MAX_VALUE;
        double cheapestComicPrice = Double.MAX_VALUE;
        double cheapestEBookPrice = Double.MAX_VALUE;

        for (CommercialBook book : allBooks) {
            if (book instanceof Novel) {
                if (book.getPrice() < cheapestNovelPrice) {
                    cheapestNovelPrice = book.getPrice();
                    cheapestBooks.add(book);
                }
            } else if (book instanceof Comic) {
                if (book.getPrice() < cheapestComicPrice) {
                    cheapestComicPrice = book.getPrice();
                    cheapestBooks.add(book);
                }
            } else if (book instanceof EBook) {
                if (book.getPrice() < cheapestEBookPrice) {
                    cheapestEBookPrice = book.getPrice();
                    cheapestBooks.add(book);
                }
            }
        }

        return cheapestBooks;
    }

    // Metode untuk mengelompokkan buku berdasarkan penulis dan negara
    public Map<String, Map<String, List<CommercialBook>>> groupBooksByAuthorAndCountry() {
        return allBooks.stream()
                .collect(Collectors.groupingBy(
                        CommercialBook::getAuthorName,
                        Collectors.groupingBy(
                                CommercialBook::getAuthorCountry,
                                Collectors.toList()
                        )
                ));
    }


    // Inisialisasi data dummy
    private void initializeDummyData() {
        // Data Author
        Author author1 = new Author("Haidar", "Musyafa", "Indonesia", 30);
        Author author2 = new Author("Bert", "Bates", "United States", 50);
        Author author3 = new Author("Barry", "Burd", "United States", 52);
        Author author4 = new Author("Mark", "Manson", "United States", 38);
        Author author5 = new Author("Andi", "Susanto", "Indonesia", 32);
        Author author6 = new Author("Adi", "Sutanto", "Indonesia", 27);

        // Data Novelis
        Novelis novelis1 = new Novelis("J.K", "Rowling", "England", 57, true, "Best Seller");
        Novelis novelis2 = new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller");
        Novelis novelis3 = new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good");
        Novelis novelis4 = new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Commer");
        Novelis novelis5 = new Novelis("Julia", "Golding", "England", 41, false, "Best Seller");

        // Data Mangaka
        Mangaka mangaka1 = new Mangaka("Masashi", "Kisimoto", "Japan", 48, "Best Seller");
        Mangaka mangaka2 = new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good");
        Mangaka mangaka3 = new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller");
        Mangaka mangaka4 = new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Commer");
        Mangaka mangaka5 = new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Commer");

        // Data Publisher
        Publisher publisher1 = new Publisher("Bloomsbury", "United Kingdom", 30.0);
        Publisher publisher2 = new Publisher("Gramedia", "Indonesia", 50.0);
        Publisher publisher3 = new Publisher("Mizan", "Indonesia", 25.0);
        Publisher publisher4 = new Publisher("Shueisha", "Japan", 25.0);
        Publisher publisher5 = new Publisher("Elex Media Komputindo", "Indonesia", 12.0);
        Publisher publisher6 = new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0);
        Publisher publisher7 = new Publisher("Lion Hudson", "England", 15.0);
        Publisher publisher8 = new Publisher("O Reilly Media", "United States", 30.0);
        Publisher publisher9 = new Publisher("Harper One", "United States", 25.0);

        // Data E-Book
        EBook eBook1 = new EBook("Book-001", "Memahami Hamka", author1, publisher3, 30.0);
        EBook eBook2 = new EBook("Book-002", "Head First Java: Your Brain on Java - A Learner's Guide", author2, publisher8, 36.0);
        EBook eBook3 = new EBook("Book-003", "Java For Dummies", author3, publisher8, 36.0);
        EBook eBook4 = new EBook("Book-004", "Flutter For Dummies", author3, publisher8, 36.0);
        EBook eBook5 = new EBook("Book-005", "The Subtle Art of Not Giving", author4, publisher9, 30.0);
        EBook eBook6 = new EBook("Book-006", "Will", author4, publisher9, 30.0);
        EBook eBook7 = new EBook("Book-007", "Sejarah Indonesia", author5, publisher6, 18.0);
        EBook eBook8 = new EBook("Book-008", "Teknologi Baru", author6, publisher5, 14.5);

        // Data Novel
        Novel novel1 = new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", novelis1, publisher1, 45.0, "Fantasy");
        Novel novel2 = new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", novelis1, publisher1, 45.0, "Fantasy");
        Novel novel3 = new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", novelis1, publisher1, 45.0, "Fantasy");
        Novel novel4 = new Novel("Novel-004", "Ayah Aku Berbeda", novelis2, publisher2, 75.0, "Drama");
        Novel novel5 = new Novel("Novel-005", "Madre", novelis3, publisher2, 67.5, "Drama");
        Novel novel6 = new Novel("Novel-006", "Lagu untuk Renjana", novelis4, publisher3, 31.5, "Drama");
        Novel novel7 = new Novel("Novel-007", "Semoga Lekas Lega", novelis4, publisher3, 31.5, "Drama");
        Novel novel8 = new Novel("Novel-008", "The Abbey Mystery", novelis5, publisher7, 22.5, "Fiction");

        // Data Comic
        Comic comic1 = new Comic("Comic-001", "Uzumaki Naruto", mangaka1, publisher4, 33.75, true, 0.0);
        Comic comic2 = new Comic("Comic-002", "The Worst Client", mangaka1, publisher4, 33.75, true, 0.0);
        Comic comic3 = new Comic("Comic-003", "For the Sake of Dreams...!!", mangaka1, publisher4, 33.75, true, 0.0);
        Comic comic4 = new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", mangaka2, publisher4, 36.25, true, 0.0);
        Comic comic5 = new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", mangaka2, publisher4, 36.25, true, 0.0);
        Comic comic6 = new Comic("Comic-006", "One Piece", mangaka3, publisher2, 75.00, true, 0.0);
        Comic comic7 = new Comic("Comic-007", "Petualangan di Indonesia", mangaka4, publisher6, 18.75, false, 0.0);
        Comic comic8 = new Comic("Comic-008", "Petualangan di Jakarta", mangaka5, publisher5, 15.00, false, 0.0);

        // Menambahkan buku ke daftar
        allBooks.add(eBook1);
        allBooks.add(eBook2);
        allBooks.add(eBook3);
        allBooks.add(eBook4);
        allBooks.add(eBook5);
        allBooks.add(eBook6);
        allBooks.add(eBook7);
        allBooks.add(eBook8);
        allBooks.add(novel1);
        allBooks.add(novel2);
        allBooks.add(novel3);
        allBooks.add(novel4);
        allBooks.add(novel5);
        allBooks.add(novel6);
        allBooks.add(novel7);
        allBooks.add(novel8);
        allBooks.add(comic1);
        allBooks.add(comic2);
        allBooks.add(comic3);
        allBooks.add(comic4);
        allBooks.add(comic5);
        allBooks.add(comic6);
        allBooks.add(comic7);
        allBooks.add(comic8);
    }
}
