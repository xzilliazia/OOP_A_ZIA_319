package Task.Modul5.app.dashboard;

import Task.Modul5.data.*;
import Task.Modul5.models.Entity;
import Task.Modul5.service.*;

import java.util.Scanner;

public class Dashboard {

    private static final Scanner input = new Scanner(System.in);
    private static final ItemManager itemManager = new ItemManager();
    private static final MahasiswaManager mahasiswaManager = new MahasiswaManager();
    private static final AdminManager adminManager = new AdminManager();

    static {
        mahasiswaManager.loadFromFile("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/mahasiswa.csv");
        adminManager.loadFromFile("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/admin.csv");
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
                System.out.println("4. Kelola User");
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
                case "4" -> {
                    if (user instanceof Admin) {
                        manageUser();
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

    private static void manageUser() {
        System.out.println("\n=== Kelola User ===");
        System.out.println("1. Lihat Mahasiswa");
        System.out.println("2. Lihat Admin");
        System.out.println("3. Tambah Mahasiswa");
        System.out.print("Pilih: ");
        String pilihan = input.nextLine();

        switch (pilihan) {
            case "1" -> mahasiswaManager.displayAll();
            case "2" -> adminManager.displayAll();
            case "3" -> addMahasiswa();
            default -> System.out.println("Pilihan tidak valid.");
        }
    }

    private static void addMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Mahasiswa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan Nama Mahasiswa: ");
        String name = scanner.nextLine();

        Mahasiswa mahasiswaBaru = new Mahasiswa(id, name);
        mahasiswaManager.addMahasiswa(mahasiswaBaru);
        System.out.println("Mahasiswa berhasil ditambahkan.");
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