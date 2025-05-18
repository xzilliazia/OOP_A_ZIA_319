package Codelab.Modul5.main;
import Codelab.Modul5.stuff.*;
import Codelab.Modul5.exception.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        daftarBarang.add(new Barang("Buku", 10));
        daftarBarang.add(new Barang("Pensil", 20));
        daftarBarang.add(new Barang("Penghapus", 15));

        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = -1;
            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input menu harus berupa angka!");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = input.nextLine();
                    try {
                        System.out.print("Masukkan stok awal: ");
                        int stok = input.nextInt();
                        input.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        input.nextLine();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\nDaftar Barang:");
                        // Iterator<Barang> iterator =  daftarBarang.iterator();
                        // while (iterator.hasNext()) {    
                        //     System.out.println("Nama: "+ iterator.next());
                        // }
                        for (Barang b : daftarBarang) {
                            System.out.println("- " + b.getNama() + " | Stok: " + b.getStok());
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang dalam stok.");
                        break;
                    }

                    System.out.println("\nDaftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        System.out.println(i + ". " + daftarBarang.get(i).getNama() + " | Stok: " + daftarBarang.get(i).getStok());
                    }
                    try {
                        System.out.print("Masukkan indeks barang yang dikurangi stoknya: "); int indeks = input.nextInt();

                        Barang barang = daftarBarang.get(indeks);

                        System.out.print("Masukkan jumlah stok yang ingin dikurangi: ");
                        int jumlah = input.nextInt(); input.nextLine();

                        if (jumlah > barang.getStok()) {
                            throw new StokTidakCukup("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!"); input.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid!");
                    } catch (StokTidakCukup e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        }
        input.close();
    }
}
