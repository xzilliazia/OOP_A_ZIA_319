package Modul1.Tugas;

import java.util.Scanner;

public class Tugas1 {
    try (Scanner input = new Scanner(System.in)){
            System.out.print("Masukkan Pilihan: ");
            choise = input.nextLine();

            String.inputUsernameAdmin = "Admin";
            String.inputPasswordAdmin = "admin12";
            String.inputUsernameSiswa = "Ziaulhaq";
            String.inputNIMSiswa = "319";


        switch (choise) {
            case 1 :
                System.out.print("Masukkan Username: ");
                username = input.nextLine();
    
                if (input.equals(inputUsernameAdmin) && (input.equals(inputPasswordAdmin))){
                    System.out.println("Login anda berhasil!");
                }
                break;
            case 2 :
                System.out.print("Masukkan Password: ");
                userpassword = input.nextLine();
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
