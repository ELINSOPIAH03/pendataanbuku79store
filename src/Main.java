import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import child.Comic;
import child.Mangaka;
import child.EBook;
import child.Novel;
import parent.CommercialBook;


public class Main {
    private static void bookMenu(Scanner scanner, RepositoryBook repositoryBook) {
        while (true) {
            System.out.println("\nBook Menu Searching");
            System.out.println("1. Cari data book yang memiliki price paling Murah");
            System.out.println("2. Cari data book yang memiliki price paling Mahal");
            System.out.println("3. Cari data book berdasarkan range Price");
            System.out.println("4. Cari Comic Berdasarkan Rating mangaka");
            System.out.println("5. Cari Book berdasarkan Country dari Publishernya");
            System.out.println("6. Cari Book berdasarkan Country dari Authornya");
            System.out.println("7. Cari data Comic yang memiliki price paling Mahal");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose option: ");

            int bookChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<CommercialBook> allBooks = repositoryBook.getAllBook();
            switch (bookChoice) {
                case 1:
                    // TODO: Implement searching for the cheapest book
                    CommercialBook.getCheapestBooks(allBooks);
                    break;
                case 2:
                    // TODO: Implement searching for the most expensive book
                    CommercialBook.getHighestPricedBooks(allBooks);
                    break;
                case 3:
                    // Mendapatkan semua buku dari repository dan mengurutkannya berdasarkan rentang harga
                    double minPrice = 14.5;
                    double maxPrice = 50.0;

                    List<CommercialBook> booksInPriceRange = CommercialBook.getAllBooksSortedByPriceRange(allBooks, minPrice, maxPrice);

                    System.out.println("Semua buku dalam rentang harga " + minPrice + " - " + maxPrice + ", diurutkan berdasarkan harga:\n" );
                    for (CommercialBook book : booksInPriceRange) {
                        System.out.println(book);
                    }
                    break;
                case 4:
                    // TODO: Implement searching for comics based on Mangaka rating
                    break;
                case 5:
                    // TODO: Implement searching for books based on Publisher country
                    // Grup buku berdasarkan publisherName dan country
                    Map<String, List<CommercialBook>> groupedBooks = CommercialBook.groupBooksByPublisherAndCountry(allBooks);

                    // Menampilkan hasil
                    groupedBooks.forEach((key, value) -> {
                        System.out.println("Penerbit dan Negara: " + key); // Menambahkan nama penerbit dan negara
                        value.forEach(book -> System.out.println("- " + book));
                        System.out.println(); // Baris kosong antar kelompok
                    });
                    break;
                case 6:
                    // TODO: Implement searching for books based on Author country
                    
                    Map<String, Map<String, List<CommercialBook>>> groupedBooks2 = repositoryBook.groupBooksByAuthorAndCountry();

                    // Lakukan sesuatu dengan hasil pengelompokan, misalnya tampilkan
                    groupedBooks2.forEach((author, countryMap) -> {
                        System.out.println("\nAuthor: " + author);
                        countryMap.forEach((country, books) -> {
                            System.out.println("Country: " + country);
                            books.forEach(book -> System.out.println("   - " + book.getTitle()));
                        });
                    });
                    break;
                case 7:
                    // TODO: Implement searching for the most expensive comic
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void authorMenu(Scanner scanner, RepositoryBook repositoryBook) {
        while (true) {
            System.out.println("\nAuthor Menu Searching");
            System.out.println("1. Cari Data semua Mangaka");
            System.out.println("2. Cari Data semua Author");
            System.out.println("3. Cari Data semua Novelis");
            System.out.println("4. Cari author berdasarkan Range umur");
            System.out.println("5. Cari author berdasarkan Country");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose option: ");

            int authorChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (authorChoice) {
                case 1:
                    // TODO: Implement searching for all Mangaka
                    break;
                case 2:
                    // TODO: Implement searching for all Authors
                    break;
                case 3:
                    // TODO: Implement searching for all Novelis
                    break;
                case 4:
                    // TODO: Implement searching for authors based on age range
                    break;
                case 5:
                    // TODO: Implement searching for authors based on country
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void publisherMenu(Scanner scanner, RepositoryBook repositoryBook) {
        while (true) {
            System.out.println("\nPublisher Menu Searching");
            System.out.println("1. Cari Publisher dengan productionCost paling Mahal");
            System.out.println("2. Cari Publisher dengan productionCost paling Murah");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose option: ");

            int publisherChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (publisherChoice) {
                case 1:
                    // TODO: Implement searching for the most expensive publisher
                    break;
                case 2:
                    // TODO: Implement searching for the cheapest publisher
                    break;
                case 0:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static String getNovelCode(RepositoryBook repositoryBook) {
        // Mendapatkan semua buku dari repositori
        var allBooks = repositoryBook.getAllBook();

        // Mencari novel pertama dalam daftar
        for (CommercialBook book : allBooks) {
            if (book instanceof Novel) {
                // Jika buku merupakan novel, dapatkan kode buku dan kembalikan nilainya
                return ((Novel) book).getBookCode();
            }
        }

        // Mengembalikan string kosong jika tidak ada novel dalam daftar
        return "";
    }


    public static void main(String[] args) throws Exception {
        //code
        Scanner scanner = new Scanner(System.in);
        RepositoryBook repositoryBook = new RepositoryBook();

        String novelCode = getNovelCode(repositoryBook);
        System.out.println("Book Code of the first novel: " + novelCode);
        
        System.out.println("=============================");

        List<CommercialBook> allBooks = repositoryBook.getAllBook();
        //CommercialBook.displayBooksByCountryAndPublisher(allBooks, "United Kingdom", "Bloomsbury");
        // CommercialBook.displayBooksByCountryAndPublisher(allBooks, "Indonesia", "Mizan");

        // CommercialBook.displayComicByMangakaRating(allBooks);
        // repositoryBook.displayComicByMangakaRating();


        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Book");
            System.out.println("2. Author");
            System.out.println("3. Publisher");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    bookMenu(scanner, repositoryBook);
                    break;
                case 2:
                    authorMenu(scanner, repositoryBook);
                    break;
                case 3:
                    publisherMenu(scanner, repositoryBook);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
