package Modul1.Tugas;

import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        System.out.println("PIlih Login:\n1. Admin\n2. Mahasiswa");
        try (Scanner input = new Scanner(System.in)) {   
            System.out.print("Masukkan Pilihan: ");
            int choise = input.nextInt();
            input.nextLine();

                //Data Login
                String inputUsernameAdmin = "Admin";
                String inputPasswordAdmin = "admin12";
                String inputUsernameSiswa = "Ziaulhaq";
                String inputNIMSiswa = "319";

        switch (choise) {
            case 1 -> {
                System.out.print("Masukkan Username: ");
                String username = input.nextLine();
                System.out.print("Masukkan Password: ");
                String password = input.nextLine();

                if (username.equals(inputUsernameAdmin) && (password.equals(inputPasswordAdmin))) {
                    System.out.println("Login anda berhasil!");
                } else {
                    System.out.println("Gagal Login. Username / Password salah.");
                }
                }
            case 2 -> {
                System.out.print("Masukkan Nama: ");
                String usermh = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String nimpassword = input.nextLine();

                if (usermh.equals(inputUsernameSiswa) && (nimpassword.equals(inputNIMSiswa))){
                    System.out.println("Login berhasil!");
                } else {
                    System.out.println("Gagal Login. Nama / NIM salah.");
                }
                }
            default -> {
                System.out.println("Pilihan Invalid");
                }
        }   
        }
    }
}