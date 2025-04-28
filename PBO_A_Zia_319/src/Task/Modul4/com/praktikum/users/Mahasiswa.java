package Task.Modul4.com.praktikum.users;
import Task.Modul4.com.praktikum.actions.*;
import java.util.Scanner;

public class Mahasiswa extends userClass implements MahasiswaActions{
    private String name;
    private String idStudent;

    public Mahasiswa(String username, String password){
        super(username, password);
    }
    //NOT YET
    @Override
    public void login(){

    }

    @Override
    public void displayAppMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Laporkan Barang Temuan/Hilang\n2. Lihat Daftar Laporan\n0. Logout");
        String choice = input.nextLine().trim();
        if (choice.equals("1")){
            reportItem();
        } else if (choice.equals("2")){
            viewReportItem();
        } else if (choice.equals("0")) {
            System.out.println("Progam Keluar");
        } else {
            System.out.println("Pilhan tidak Valid");
        }
    }

    @Override
    public void reportItem(){
        Scanner input = new Scanner(System.in);

        System.out.print("Nama Barang: "); String nameItem = input.nextLine().trim();
        System.out.print("Deskripsi Barang: "); String deskriptionItem = input.nextLine().trim();
        System.out.print("Lokasi terakhir: "); String lastLocations = input.nextLine().trim();

        System.out.println("\nData barang berhasil disimpan");
        System.out.println("Nama barang: "+ nameItem);
        System.out.println("Deskripsi: "+ deskriptionItem);
        System.out.println("Lokasi Terakhir: "+ lastLocations);

        // input.close();
    }
    @Override
    public void viewReportItem(){
        System.out.println(">>Fitur laporan Belum Tersedia<<");
    }

}
