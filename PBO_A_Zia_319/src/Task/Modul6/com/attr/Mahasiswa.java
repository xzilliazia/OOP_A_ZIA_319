package Task.Modul6.com.attr;

import Task.Modul6.com.actions.MahasiswaAc;
import Task.Modul6.com.data.ItemStorage;
import javafx.collections.ObservableList;

public class Mahasiswa implements MahasiswaAc {
    private String nama;
    private String NIM;

    public Mahasiswa(String nama, String NIM) {
        this.nama = nama;
        this.NIM = NIM;
    }
    public String getNama() {
        return nama;
    }
    public String getNIM() {
        return NIM;
    }

    @Override
    public void reportItem(String nama, String deskripsi, String lokasi) {
            Item item = new Item(nama, deskripsi, lokasi, "Reported");
            ItemStorage.addItem(item);
    }
    @Override
    public ObservableList<Item> viewReportedItems() {
        return ItemStorage.getItemList(); // bisa difilter jika ingin hanya laporan miliknya
    }
}