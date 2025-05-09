package com.Final_Project.masterClass;
import com.Final_Project.actions.*;
public abstract class Users extends Entity implements Authen {
    private String name;
    private String username;
    private String password;
    private AccountType typeAccount;

    public Users(int id, String name, String username, String password, AccountType typeAccount){
        super(id);
        this.name = name;
        this.username = username;
        this.password = password;
        this.typeAccount = typeAccount;
    }
    //getters
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public AccountType getTypeAccount() {
        return typeAccount;
    }

    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
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
    @Override
    public boolean login(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }
    @Override
    public void logout(){
        System.out.println(name + " Logout");
    }
    @Override
    public String toString() {
        return "ID: " + getId() + ", Nama: " + name + ", Tipe Akun: " + typeAccount;
    }
    public abstract void info();
}