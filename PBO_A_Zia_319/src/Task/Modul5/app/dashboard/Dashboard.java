package Task.Modul5.app.dashboard;

import Task.Modul5.data.*;
import Task.Modul5.models.Entity;
import Task.Modul5.service.*;

import java.util.Scanner;

public class Dashboard {

    private static final Scanner input = new Scanner(System.in);
    private static final ItemManager itemManager = new ItemManager();

    static {
        itemManager.loadFromFile("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/items.csv");
    }

    public static void showDashboard(Entity user) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== DASHBOARD - " + user.getClass().getSimpleName() + " ===");
            System.out.println("1. Lapor Barang");
            System.out.println("2. Lihat Daftar Laporan");

            if (user instanceof Admin) {
                System.out.println("3. Kelola Laporan");
            }

            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> laporBarang(user);
                case "2" -> itemManager.displayAllItems();
                case "3" -> {
                    if (user instanceof Admin) {
                        itemManager.manageItem("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/items.csv");
                    } else {
                        System.out.println("Akses ditolak.");
                    }
                }
                case "0" -> {
                    System.out.println("Logout...");
                    running = false;
                }
                default -> System.out.println("Menu tidak dikenali.");
            }
        }
    }

    private static void laporBarang(Entity user) {
        System.out.print("Nama Barang: ");
        String name = input.nextLine();
        System.out.print("Deskripsi: ");
        String desc = input.nextLine();
        System.out.print("Lokasi: ");
        String location = input.nextLine();
        System.out.print("Status (hilang/ditemukan): ");
        String status = input.nextLine();

        Item item = new Item(user.getName(), name, desc, location, status);
        itemManager.addItem(item);
        itemManager.saveToFile("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/items.csv");
        System.out.println("Laporan berhasil ditambahkan.");
    }

}
