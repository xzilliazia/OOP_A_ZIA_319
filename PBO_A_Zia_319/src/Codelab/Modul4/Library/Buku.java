package Codelab.Modul4.Library;

public abstract class Buku {
    protected String judul;
    protected String penulis;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul(){
        return judul;
    }

    public abstract void displayInfo();
}

