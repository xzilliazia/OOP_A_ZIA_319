package Codelab.Modul5.stuff;

public class Barang {
    private String nama;
    private int stok;

    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    @Override
    public String toString() {
        return nama + " (Stok: " + stok + ")";
    }
}
