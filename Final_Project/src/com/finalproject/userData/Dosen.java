package com.finalproject.userData;
import com.finalproject.masterClass.*;

public class Dosen extends Users {
    private String department;

    public Dosen(int id, String name, String username, String password, AccountType typeAccount, String department) {
        super(id, name, username, password, typeAccount);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void info() {
        System.out.println("Dosen: " + getName() + " Departemen: " + department);
    }
}
