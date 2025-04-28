package Codelab.Modul4.App;
import Codelab.Modul4.Library.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Ziaulhaq", "A319");
        Anggota anggota2 = new Anggota("Diandra", "A024");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();
        System.out.println();

        anggota1.pinjamBuku(buku1);
        anggota2.pinjamBuku(buku2, 7);
        System.out.println();

        anggota1.kembalikanBuku(buku1);
        anggota2.kembalikanBuku(buku2);
    }
}
