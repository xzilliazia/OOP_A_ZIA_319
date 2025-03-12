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
            System.out.println("Pilih jenis Login:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan (1/2/3): ");
            int choise = input.nextInt();
            input.nextLine();
        
            String inputUser, inputPassword;

        switch (choise) {
            case 1 :
                System.out.print("Masukkan Username: ");
                inputUser = input.nextLine();
                System.out.print("Masukkan Password: ");
                inputPassword = input.nextLine();
                
                if (admin.getLogin(inputUser, inputPassword)){
                    System.out.println("Login Berhasil!!");
                    
                } else {
                    System.out.println("Login Admin Gagal! Username atau Password salah.");
                }
                break;
            case 2 :
                System.out.print("Masukkan Nama Mahsiswa: ");
                inputUser = input.nextLine();
                System.out.print("Masukkan NIM: ");
                inputPassword = input.nextLine();
                
                if (student.getLogin(inputUser, inputPassword)){
                    System.out.println("Berhasil Login");
                    student.displayInfo();
                } else {
                    System.out.println("Login Gagal! Username atau Password salah.");
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                break;
        }
        }
        } catch (Exception e){
            System.out.println("Terjadi Eror: "+ e.getMessage());
        } 
    }
}