package com.finalproject.userData;
import com.finalproject.masterClass.*;

public class Mahasiswa extends Users {
    private String major;

    public Mahasiswa(int id, String name, String username, String password, AccountType typeAccount, String major) {
        super(id, name, username, password, typeAccount);
        if (major == null || major.trim().isEmpty()) {
            throw new IllegalArgumentException("Jurusan tidak boleh kosong");
        }
        this.setMajor(major);
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