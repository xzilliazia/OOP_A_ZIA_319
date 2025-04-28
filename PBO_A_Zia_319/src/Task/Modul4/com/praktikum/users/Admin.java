package Task.Modul4.com.praktikum.users;
import Task.Modul4.com.praktikum.actions.*;

public class Admin extends userClass implements AdminActions{

    public Admin (String username, String password){
        super(username, password);
    }

    @Override
    public void login(){
        
    }
    @Override
    public void manageItem(){
        System.out.println("Fitur kelola barang belum tersedia");
    }

    @Override
    public void manageUser(){
        System.out.println("Fitur kelola mahasiswa belum tersedia");
    }
}
