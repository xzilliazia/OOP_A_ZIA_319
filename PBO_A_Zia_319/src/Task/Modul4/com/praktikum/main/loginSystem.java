package Task.Modul4.com.praktikum.main;
import Task.Modul4.com.praktikum.actions.*;
import Task.Modul4.com.praktikum.users.*;
import java.util.Scanner;

public class loginSystem {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("Ziaulhaq", "319");
        Admin admin1 = new Admin("Bakri", "bakri01");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih Jenis Login (1. Admin/2. Mahsiswa): ");
        int inputLoginPage = input.nextInt();
        input.nextLine();
        
        switch (inputLoginPage) {
            case 1:
                admin1.login();
                admin1.displayAppMenu();
                break;
            case 2:
                mhs1.login();
                mhs1.displayAppMenu();
                break;
            default:
                break;
        }
    }
}
