package Task.Modul6.com.service;

import Task.Modul6.com.attr.AdminAttr;
import Task.Modul6.com.attr.Mahasiswa;
import Task.Modul6.com.data.Admin;
import Task.Modul6.com.data.ItemStorage;

public class Login {
    public static AdminAttr loginAdmin(String username, String password) {
        Admin admin = new Admin();
        if (admin.isValidAdmin(username, password)) {
            return new AdminAttr(username, password);
        }
        return null;
    }
    public static Mahasiswa loginMahasiswa(String name, String nim) {
        return ItemStorage.getStudentList().stream()
                .filter(m -> m.getNama().equalsIgnoreCase(name) && m.getNIM().equals(nim))
                .findFirst().orElse(null);
    }
}