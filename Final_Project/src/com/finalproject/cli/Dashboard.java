package com.finalproject.cli;
import com.finalproject.dataBooks.Books;
import com.finalproject.dataBooks.Magazine;
import com.finalproject.masterClass.Media;
import com.finalproject.masterClass.Users;
import com.finalproject.services.*;
import com.finalproject.userData.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Dashboard {
    private static final Scanner input = new Scanner(System.in);
    private static final BookManager bookManager = new BookManager();
    private static final MagazineManager magazineManager = new MagazineManager();

    static {
        //load file data
        bookManager.loadFromFile("D:/Coding/Java/Final_Project/src/com/finalproject/books.csv");
        magazineManager.loadFromFile("D:/Coding/Java/Final_Project/src/com/finalproject/magazine.csv");
    }

    public static void showDashboard(Users user){
        boolean running = true;

        while(running){
            System.out.println("\n=== DASHBOARD - " + user.getTypeAccount() + " ===");
            System.out.println("1. Lihat Buku");
            System.out.println("2. Lihat Majalah");
            System.out.println("3. Pinjam Media");
            System.out.println("4. Kembalikan Media");
            if (user instanceof Pustakawan) {
                System.out.println("5. Tambah Buku");
                System.out.println("6. Tambah Majalah");
            }
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1" -> bookManager.displayAllBooks();
                case "2" -> magazineManager.displayAll();
                case "3" -> handleBorrow(user);
                case "4" -> handleReturn(user);
                case "5" -> {
                    if (user instanceof Pustakawan) handleAddBook();
                    else System.out.println("Anda tidak memiliki izin.");
                }
                case "6" -> {
                    if (user instanceof Pustakawan) handleAddMagazine();
                    else System.out.println("Anda tidak memiliki izin.");
                }
                case "0" -> {
                    System.out.println("Logout berhasil.\n");
                    running = false;
                }
                default -> System.out.println("Pilihan tidak tersedia.");
            }
        }
    }

    public static void handleBorrow(Users user){
        System.out.println("--Pinjam Media--");
        System.out.println("Masukkan ID media: ");
        int id = Integer.parseInt(input.nextLine());

        Media media = findMediaById(id);

        if (media == null){
            System.out.println("Media tidak ditemukan");
            return;
        }

        if (media.getStock() <= 0){
            System.out.println("Stok habis");
            return;
        }

        Lending lending = new Lending(1000 + id, user, media, LocalDateTime.now());
        lending.execute();

    }

    private static void handleReturn(Users user) {
        System.out.println("=== KEMBALIKAN MEDIA ===");
        System.out.print("Masukkan ID media: ");
        int id = Integer.parseInt(input.nextLine());

        Media media = findMediaById(id);
        if (media == null) {
            System.out.println("Media tidak ditemukan.");
            return;
        }

        Returner returner = new Returner(2000 + id, user, media, LocalDateTime.now());
        returner.execute();
    }

    private static Media findMediaById(int id) {
        for (Media m : bookManager.getAllBooks()) {
            if (m.getId() == id) return m;
        }
        for (Media m : magazineManager.getAll()) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    private static void handleAddBook() {
        System.out.println("=== TAMBAH BUKU ===");
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(input.nextLine());
            System.out.print("Judul: ");
            String title = input.nextLine();
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Stok: ");
            int stock = Integer.parseInt(input.nextLine());
            System.out.print("Penulis: ");
            String writer = input.nextLine();
            System.out.print("Tipe Konten: ");
            String contentType = input.nextLine();

            Books book = new Books(id, title, genre, stock, writer, contentType);
            bookManager.addBook(book);
            bookManager.saveToFile("D:/Coding/Java/Final_Project/src/com/finalproject/books.csv");

            System.out.println("Buku berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("Gagal menambah buku: " + e.getMessage());
        }
    }

    private static void handleAddMagazine() {
        System.out.println("=== TAMBAH MAJALAH ===");
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(input.nextLine());
            System.out.print("Judul: ");
            String title = input.nextLine();
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Stok: ");
            int stock = Integer.parseInt(input.nextLine());
            System.out.print("Edisi: ");
            String edition = input.nextLine();

            Magazine mag = new Magazine(id, title, genre, stock, edition);
            magazineManager.addMagazine(mag);
            magazineManager.saveToFile("D:/Coding/Java/Final_Project/src/com/finalproject/magazines.csv");

            System.out.println("Majalah berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("Gagal menambah majalah: " + e.getMessage());
        }
    }

}
