package com.finalproject.services;
import com.finalproject.masterClass.*;
import com.finalproject.userData.*;
import java.io.*;
import java.util.*;

public class UserManager {
    private final List<Users> userList = new ArrayList<>();

    public void addUser(Users user) {
        userList.add(user);
    }

    public Users login(String username, String password) {
        for (Users user : userList) {
            if (user.login(username, password)) {
                return user;
            }
        }
        return null;
    }

    public void loadFromFile(String filePath) {
        userList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // skip header
            String line;
            while ((line = reader.readLine()) != null) {
                Users user = parseLine(line);
                if (user != null) userList.add(user);
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca users.csv: " + e.getMessage());
        }
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("id,name,username,password,type,special\n");
            for (Users user : userList) {
                writer.write(toLine(user) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Gagal menulis users.csv: " + e.getMessage());
        }
    }

    private Users parseLine(String line) {
        try {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String username = parts[2];
            String password = parts[3];
            AccountType type = AccountType.valueOf(parts[4]);
            String special = parts[5];

            return switch (type) {
                case MAHASISWA -> new Mahasiswa(id, name, username, password, type, special);
                case DOSEN -> new Dosen(id, name, username, password, type, special);
                case LIBRARIAN -> new Pustakawan(id, name, username, password, type, special);
            };
        } catch (Exception e) {
            System.err.println("Format salah: " + line);
            return null;
        }
    }

    private String toLine(Users user) {
        String special = switch (user.getTypeAccount()) {
            case MAHASISWA -> ((Mahasiswa) user).getMajor();
            case DOSEN -> ((Dosen) user).getDepartment();
            case LIBRARIAN -> ((Pustakawan) user).getDuty();
        };
        return user.getId() + "," +
                user.getName() + "," +
                user.getUsername() + "," +
                "[PROTECTED]" + "," +
                user.getTypeAccount() + "," +
                special;
    }

    public List<Users> getAllUsers() {
        return userList;
    }
}
