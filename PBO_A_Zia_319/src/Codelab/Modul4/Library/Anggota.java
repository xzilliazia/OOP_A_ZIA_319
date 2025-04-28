package Codelab.Modul4.Library;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    public void tampilkanInfo() {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }

    @Override
    public void pinjamBuku(Buku book) {
        System.out.println(nama + " meminjam buku berjudul: " + book.getJudul());
    }
    //over;oadinng
    public void pinjamBuku(Buku book, int durasi) {
        System.out.println(nama + " meminjam buku \"" + book.getJudul() + "\" selama " + durasi + " hari.");
    }

    @Override
    public void kembalikanBuku(Buku book) {
        System.out.println(nama + " mengembalikan buku berjudul: " + book.getJudul());
    }
}

