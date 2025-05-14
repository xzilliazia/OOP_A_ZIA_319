package com.finalproject.cli;
import com.finalproject.masterClass.Users;
import com.finalproject.services.UserManager;
import java.util.Scanner;

public class LoginStart {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserManager userManager = new UserManager();

    public static void start() {
        userManager.loadFromFile("D:/Coding/Java/Final_Project/src/com/finalproject/users.csv");

        boolean running = true;
        while (running) {
            printWelcome();
            System.out.print("Pilih menu: ");
            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1" -> handleLogin();
                case "2" -> {
                    System.out.println("Keluar dari sistem. Sampai jumpa!");
                    running = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void printWelcome() {
        // System.out.println("Current working directory: " + System.getProperty("user.dir"));
        System.out.println("===================================");
        System.out.println("   SELAMAT DATANG DI PERPUSTAKAAN  ");
        System.out.println("===================================");
        System.out.println("1. Login");
        System.out.println("2. Keluar");
    }

    private static void handleLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        Users user = userManager.login(username, password);


        if (user != null) {
            System.out.println("Login berhasil! Selamat datang, " + user.getName());
            MenuRouter.redirect(user);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
