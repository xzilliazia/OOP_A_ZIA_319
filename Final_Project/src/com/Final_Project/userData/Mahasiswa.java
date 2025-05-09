package com.Final_Project.userData;
import com.Final_Project.masterClass.*;

public class Mahasiswa extends Users{
    private String major;

    public Mahasiswa(int id, String name, String username, String password, AccountType typeAccount, String major){
        super(id, name, username, password, typeAccount);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public void info() {
        System.out.println("Mahasiswa: " + getName() + " Jurusan: " + major);
    }
}