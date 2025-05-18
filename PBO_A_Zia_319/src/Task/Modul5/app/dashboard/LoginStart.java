package Task.Modul5.app.dashboard;

import Task.Modul5.data.*;
import Task.Modul5.service.*;

import java.util.Scanner;

public class LoginStart {
    private static final Scanner input = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("=== SISTEM PELAPORAN BARANG HILANG ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Pilih: ");

            String choice = input.nextLine();
            switch (choice) {
                case "1" -> handleLogin();
                case "2" -> {
                    System.out.println("terimakasih yyat");
                    running = false;
                }
                default -> {
                    System.out.println("Pilih invalid");
                }
            }
        }
    }

    private static void handleLogin() {
        System.out.print("Masukkan ID/Username: ");
        String inputId = input.nextLine();

        if (inputId.equals("admin")) {
            loginAdmin();
            return;
        }
        try {
                int id = Integer.parseInt(inputId);
                if (!loginMahasiswa(id)){
                    System.out.println("Login gagal!");
                }
        } catch (NumberFormatException e){
            System.out.println("Format id slh");
        }
    }

    private static boolean loginMahasiswa(int id) {
        MahasiswaManager mhsManager = new MahasiswaManager();
        mhsManager.loadFromFile("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/mahasiswa.csv");
        Mahasiswa mhs = mhsManager.findById(id);
        if (mhs != null) {
            System.out.println("Login berhasil sebagai Mahasiswa: " + mhs.getName());
            Dashboard.showDashboard(mhs);
            return true;
        } else {
            return false;
        }
    }

    private static void loginAdmin() {
        AdminManager adminManager = new AdminManager();
        adminManager.loadFromFile("D:/Coding/Java/PBO_A_Zia_319/src/Task/Modul5/admin.csv");

        System.out.print("Username: ");
        String username = input.nextLine().trim();
        System.out.print("Password: ");
        String password = input.nextLine().trim();

        Admin admin = adminManager.login(username, password);
        if (admin != null) {
            System.out.println("Login berhasil sebagai Admin: " + admin.getName());
            Dashboard.showDashboard(admin);
        } else {
            System.out.println("Login gagal.");
        }
    }
}
