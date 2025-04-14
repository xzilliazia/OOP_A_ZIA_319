package Task.Modul2;
import java.util.Scanner;

public class MainLogin {
    public static void main(String[] args) {
        //data object
        AdminLogin admin = new AdminLogin("Zia", "240");
        StudentLogin student = new StudentLogin("Iza", "319");

        //trywithresource
        try (Scanner input = new Scanner(System.in)){
        while (true) {
            System.out.println("\nPilih jenis Login:\n1. Admin\n2. Student\n3. Keluar");
            System.out.print("Masukkan pilihan (1/2/3): ");
            if (!input.hasNextInt()){
                // System.out.print("Masukkan pilihan (1/2/3): ");
                input.nextLine();
                continue;
            }
            int choise = input.nextInt();
            input.nextLine();
            
            String inputUser, inputPassword;

        switch (choise) {
            case 1 :
                System.out.print("Masukkan Username: ");
                inputUser = input.nextLine();
                System.out.print("Masukkan Password: ");
                inputPassword = input.nextLine();
                //validasi
                if (admin.Login(inputUser, inputPassword)){
                    System.out.println("Login Berhasil!!");
                } else {
                    System.out.println("Login Admin Gagal! Username atau Password salah.");
                    continue;
                }
                return;
            case 2 :
                System.out.print("Masukkan Nama Mahsiswa: ");
                inputUser = input.nextLine();
                System.out.print("Masukkan NIM: ");
                inputPassword = input.nextLine();
                //validasi
                if (student.Login(inputUser, inputPassword)){
                    System.out.println("Berhasil Login");
                    student.displayInfo();
                } else {
                    System.out.println("Login Gagal! Username atau Password salah.");
                    continue;
                }
                return;
            case 3:
                return;
            default:
                System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                break;
                }
            }
        }
    }
}