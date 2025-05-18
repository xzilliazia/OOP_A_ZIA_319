package Task.Modul5.service;

import Task.Modul5.data.Admin;
import Task.Modul5.data.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminManager {
    private static List<Admin> adminList = new ArrayList<>();

    public void loadFromFile(String filePath) {
        adminList.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(filePath))){
            rd.readLine();
            String line;
            while ((line = rd.readLine()) != null){
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String password = data[2];

                adminList.add(new Admin(id, name, password));
            }
        } catch (IOException e){
            System.err.println("Error reading file" + e.getMessage());
        }
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("id,name,password\n");
            for (Admin d : adminList) {
                writer.write(d.getId() + "," + d.getName() + "," + d.getPassword() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Gagal menyimpan file Dosen: " + e.getMessage());
        }
    }

    public void addAdmin(Admin admin) {
        adminList.add(admin);
    }

    public Admin findByIdandPass(int id, String password) {
        for (Admin admin : adminList) {
            if (admin.getId() == id && admin.getPassword().equals(password)) {
                return admin;
            }
        } return null;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public Admin login(String name, String password) {
        for (Admin admin : adminList) {
            if (admin.getName().equalsIgnoreCase(name) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }
}
