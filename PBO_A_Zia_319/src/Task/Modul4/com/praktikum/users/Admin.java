package Task.Modul4.com.praktikum.users;
import java.util.Scanner;

import Task.Modul4.com.praktikum.actions.*;

public class Admin extends userClass implements AdminActions{

    public Admin (String username, String password){
        super(username, password);
    }

    @Override
    public boolean login(){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Username: ");
        String inputUsername = input.nextLine();

        System.out.print("Masukkan Password: ");
        String inputPassword = input.nextLine();

        if (inputUsername.equals(this.username) && inputPassword.equals(this.password)){
            System.out.println("Login BErhasil!");
            return true;
        } else {
            System.out.println("Login Gagal!");
            return false;
        }
    }

    @Override
    public void manageItem(){
        System.out.println("Fitur kelola barang belum tersedia");
    }

    @Override
    public void manageUser(){
        System.out.println("Fitur kelola mahasiswa belum tersedia");
    }

    @Override
    public void displayAppMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Kelola Laporan Barang\n2. Kelola daftar Mahasiswa\n0. Logout");
        System.out.print("Masukkan Pilihan: ");
        String choice = input.nextLine().trim();
        if (choice.equals("1")){
            manageItem();
        } else if (choice.equals("2")){
            manageUser();
        } else if (choice.equals("0")) {
            System.out.println("Progam Keluar");
        } else {
            System.out.println("Pilhan tidak Valid");
        }
        input.close();
    }
}
