package Task.Modul5.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Task.Modul5.data.Item;

public class ItemManager {
    private static final List<Item> itemList = new ArrayList<>();

    private Item parseItem(String line) {
        try {
            String[] parts = line.split(",");
            String username = parts[0];
            String itemName = parts[1];
            String itemDescription = parts[2];
            String itemLocation = parts[3];
            String itemStatus = parts[4];

            return new Item(username,itemName, itemDescription, itemLocation, itemStatus);
        } catch (Exception e){
            System.err.println("Error parsing line: " + line);
            return null;
        }
    }

    public String toLine(Item item) {
        return  item.getUsername() + "," +
                item.getItemName() + "," +
                item.getDeskriptionItem()+ "," +
                item.getItemlocation()+ "," +
                item.getItemStatus();
    }

    public void manageItem(String filePath) {
        loadFromFile(filePath);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU MANAJEMEN ITEM ===");
            System.out.println("1. Lihat semua item");
            System.out.println("2. Tambah item");
            System.out.println("0. Kembali");
            System.out.print("Pilih opsi: ");
            try {
                String pilihan = input.readLine();
                switch (pilihan) {
                    case "1" -> displayAllItems();
                    case "2" -> {
                        System.out.print("Username: ");
                        String username = input.readLine();
                        System.out.print("Nama item: ");
                        String nama = input.readLine();
                        System.out.print("Deskripsi item: ");
                        String deskripsi = input.readLine();
                        System.out.print("Lokasi item: ");
                        String lokasi = input.readLine();
                        System.out.print("Status item (Hilang/Ditemukan): ");
                        String status = input.readLine();

                        Item item = new Item(username, nama, deskripsi, lokasi, status);
                        addItem(item);
                        saveToFile(filePath);
                        System.out.println("Item berhasil ditambahkan.");
                    }
                    case "0" -> {
                        System.out.println("Kembali ke menu sebelumnya.");
                        running = false;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (IOException e) {
                System.err.println("Input error: " + e.getMessage());
            }
        }
    }

    public void loadFromFile(String filePath) {
        itemList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                Item item = parseItem(line);
                if (item != null){
                    itemList.add(item);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("username,itemName,itemDescription,itemLocation,itemStatus\n");
            for (Item item : itemList) {
                writer.write(toLine(item) + "\n");
            }
        } catch (IOException e){
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public void displayAllItems() {
        if (itemList.isEmpty()){
            System.out.println("No items found");
            return;
        }
        for (Item item : itemList){
            item.info();
            System.out.println("-----------------");
        }
    }

    public Item findItemByUsername(String username) {
        for (Item item : itemList){
            if (item.getUsername().equals(username)){
                return item;
            }
        }
        return null;
    }

    public void addItem (Item item) {
        itemList.add(item);
    }

}