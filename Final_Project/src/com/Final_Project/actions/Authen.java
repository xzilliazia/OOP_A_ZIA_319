package com.Final_Project.actions;

public interface Authen {
    boolean login(String username, String password);
    void logout();
}