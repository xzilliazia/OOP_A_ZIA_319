package com.finalproject.services;

import com.finalproject.dataBooks.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineManager {
    private final List<Magazine> magazineList = new ArrayList<>();

    public void loadFromFile(String filePath) {
        magazineList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                Magazine magazine = parseLine(line);
                if (magazine != null) {
                    magazineList.add(magazine);
                }
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("id,title,genre,stock,edition\n");
            for (Magazine mag : magazineList) {
                writer.write(toLine(mag) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Gagal menulis file: " + e.getMessage());
        }
    }

    private Magazine parseLine(String line) {
        try {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String genre = parts[2];
            int stock = Integer.parseInt(parts[3]);
            String edition = parts[4];

            return new Magazine(id, title, genre, stock, edition);
        } catch (Exception e) {
            System.err.println("Format salah: " + line);
            return null;
        }
    }

    private String toLine(Magazine mag) {
        return mag.getId() + "," +
               mag.getTitle() + "," +
               mag.getGenre() + "," +
               mag.getStock() + "," +
               mag.getEdition();
    }

    public void addMagazine(Magazine mag) {
        magazineList.add(mag);
    }

    public void displayAll() {
        if (magazineList.isEmpty()) {
            System.out.println("Tidak ada majalah.");
            return;
        }
        for (Magazine m : magazineList) {
            m.info();
            System.out.println("---------------");
        }
    }

    public List<Magazine> getAll() {
        return magazineList;
    }
}
