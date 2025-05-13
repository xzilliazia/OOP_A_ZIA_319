package com.finalproject.cli;

import com.finalproject.masterClass.Users;

public class MenuRouter {
    public static void redirect(Users user) {
        Dashboard.showDashboard(user);
    }
}