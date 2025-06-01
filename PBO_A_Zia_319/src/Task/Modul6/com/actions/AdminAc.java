package Task.Modul6.com.actions;

import Task.Modul6.com.attr.Item;
import Task.Modul6.com.attr.Mahasiswa;
import javafx.collections.ObservableList;

public interface AdminAc {
    ObservableList<Item> manageItems();
    ObservableList<Mahasiswa> manageUsers();
}
