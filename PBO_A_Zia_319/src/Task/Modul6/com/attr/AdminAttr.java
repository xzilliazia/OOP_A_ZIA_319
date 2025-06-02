package Task.Modul6.com.attr;

import Task.Modul6.com.actions.AdminAc;
import Task.Modul6.com.data.ItemStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminAttr extends User implements AdminAc {
    public AdminAttr(String userName, String userPass) {
        super(userName, userPass);
    }

    @Override
    public ObservableList<Item> manageItems() {
        return ItemStorage.getItemList();
    }
    @Override
    public  ObservableList<Mahasiswa> manageUsers() {
        return FXCollections.observableArrayList(ItemStorage.getStudentList());
    }
}