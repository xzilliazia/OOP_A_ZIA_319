package Codelab.Modul1;
import java.time.LocalDate;
import java.util.Scanner;

public class Codelab1 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Nama: ");
            String nama = input.nextLine();
        String gender = "";
        while(true){
            System.out.print("Masukkan Jenis Kelamin (L/P): ");
            gender = input.next();
            if (gender.equalsIgnoreCase("l")){
                gender = "Laki-laki";
                break;
            }
            else if(gender.equalsIgnoreCase("p")){
                gender = "Perempuan";
                break;
            } 
            else {
                System.out.println("Pilihann Tidak valid");
            }
        }

            System.out.print("Tahun Lahir : ");
            int timeuser = input.nextInt();
            int timenow = LocalDate.now().getYear();
            int ages = timenow - timeuser;
            
            System.out.println("\n===DATA ANDA===");
            System.out.println("Nama anda\t: " + nama);
            System.out.println("Jenis Kelamin\t: " + gender);
            System.out.println("Umur\t\t: " + ages + " tahun");
        }
    }
}
