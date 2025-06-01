package Task.Modul6.com.data;

import Task.Modul6.com.attr.Item;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

import Task.Modul6.com.attr.*;

public class ItemStorage {
    public static ArrayList<Mahasiswa> studentList = new ArrayList<>();
    private static final ObservableList<Item> itemList = FXCollections.observableArrayList();

    static {
        //duata items
        itemList.add(new Item("Kipas", "Warna Merah", "Kantek", "Reported"));
        itemList.add(new Item("Laptop", "Warna Hitam", "Lab Komputer", "Hilang"));
        itemList.add(new Item("Mouse", "Wireless", "Kantek", "Ditemukan"));

        //data siswa
        studentList.add(new Mahasiswa("Zia", "319"));
        studentList.add(new Mahasiswa("Dian", "24"));
    }

    public static void addItem(Item item) {
        itemList.add(item);
    }

    public static ArrayList<Mahasiswa> getStudentList() {
        return studentList;
    }

    public static ObservableList<Item> getItemList() {
        return itemList;
    }
}