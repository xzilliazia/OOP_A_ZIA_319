package com.finalproject.actions;

public interface Authen {
    boolean login(String username, String password);
    void logout();
    boolean isLoggedIn();
}