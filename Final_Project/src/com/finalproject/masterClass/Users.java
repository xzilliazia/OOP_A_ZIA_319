package com.finalproject.masterClass;
import java.util.Objects;

import com.finalproject.actions.*;

public abstract class Users extends Entity implements Authen {
/**
    * Abstract class representing a user with authentication functionality.
    * Base class for Mahasiswa, Dosen, and Librarian.
*/

    private String name;
    private final String username;
    private final String password;
    private AccountType typeAccount;

    public Users(int id, String name, String username, String password, AccountType typeAccount) {
        super(id);
        this.name = name;
        this.username = username;
        this.password = password;
        this.typeAccount = typeAccount;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public AccountType getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(AccountType typeAccount) {
        this.typeAccount = typeAccount;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.name = name;
    }

    private boolean loggedIn = false;
    @Override
    public boolean login(String username, String password) {
        if (Objects.equals(this.username, username) && (Objects.equals(this.password, password))){
            loggedIn = true;
        }
        return true;

    }
    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public void logout() {
        System.out.println(name + " Logout");
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nama: %s, Tipe Akun: %s",
                            getId(), name, typeAccount.getLabel());
    }
    public abstract void info();
}