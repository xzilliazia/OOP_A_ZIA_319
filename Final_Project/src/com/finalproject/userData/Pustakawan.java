package com.finalproject.userData;

import com.finalproject.masterClass.*;

public class Pustakawan extends Users {
    private String duty;

    public Pustakawan(int id, String name, String username, String password, AccountType typeAccount, String duty) {
        super(id, name, username, password, typeAccount);
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public void info() {
        System.out.println("Pustakawan: " + getName() + " Tugas: " + duty);
    }
}

