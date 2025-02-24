package Modul1.Tugas;

import java.awt.GridBagLayout;
import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {   
            System.out.print("Masukkan Pilihan: ");
            int choise = input.nextLine();
            input.nextLine();

            //Data Login
            String inputUsernameAdmin = "Admin";
            String inputPasswordAdmin = "admin12";
            String inputUsernameSiswa = "Ziaulhaq";
            String inputNIMSiswa = "319";

        switch (choise) {
            case 1 :
                System.out.print("Masukkan Username: ");
                String username = input.nextLine();
                System.out.print("Masukkan Password: ");
                String password = input.nextLine();

                if (username.equals(inputUsernameAdmin) && (password.equals(inputPasswordAdmin))) {
                    System.out.println("Login anda berhasil!");
                } else {
                    System.out.println("Gagal Login.");
                }
                break;
            case 2 :
                System.out.print("Masukkan Nama: ");
                String usermh = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String nimpassword = input.nextLine();

                if (usermh.equals(inputUsernameSiswa) && (nimpassword.equals(inputNIMSiswa))){
                    System.out.println("Login berhasil!");
                } else {
                    System.out.println("Gagal Login.");
                }
                break;
            default:
                throw new AssertionError();
        }
            else if (input == 2){

            } else {
                System.out.println("Pilihan tiidak valid.");
            }
            
        }
    }
}