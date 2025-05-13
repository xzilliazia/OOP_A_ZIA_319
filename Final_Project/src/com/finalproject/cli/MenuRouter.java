package com.finalproject.cli;

import com.finalproject.masterClass.Users;
import com.finalproject.masterClass.AccountType;

public class MenuRouter {
    public static void redirect(Users user) {
        switch (user.getTypeAccount()) {
            case MAHASISWA -> Dashboard.mahasiswaDashboard(user);
            case DOSEN -> Dashboard.dosenDashboard(user);
            case LIBRARIAN -> Dashboard.pustakawanDashboard(user);
        }
    }
}