package com.finalproject.cli;
import com.finalproject.masterClass.Users;

public class Dashboard {

    public static void mahasiswaDashboard(Users user) {
        System.out.println("===== DASHBOARD MAHASISWA =====");
        System.out.println("Selamat datang, " + user.getName());
        System.out.println("1. Lihat Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Logout");
    }

    public static void dosenDashboard(Users user) {
        System.out.println("===== DASHBOARD DOSEN =====");
        System.out.println("Selamat datang, " + user.getName());
        System.out.println("1. Lihat Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Logout");
    }

    public static void pustakawanDashboard(Users user) {
        System.out.println("===== DASHBOARD PUSTAKAWAN =====");
        System.out.println("Selamat datang, " + user.getName());
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat User");
        System.out.println("3. Logout");
    }
}
