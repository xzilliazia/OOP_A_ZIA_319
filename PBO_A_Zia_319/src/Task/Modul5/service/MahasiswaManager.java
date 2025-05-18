package Task.Modul5.service;

import Task.Modul5.data.Mahasiswa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaManager {
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();

    public void loadFromFile(String filePath) {
        mahasiswaList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                mahasiswaList.add(new Mahasiswa(id, name));
            }
        } catch (IOException e) {
            System.err.println("Gagal membaca file Mahasiswa: " + e.getMessage());
        }
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("id,name\n");
            for (Mahasiswa m : mahasiswaList) {
                writer.write(m.getId() + "," + m.getName() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Gagal menyimpan file Mahasiswa: " + e.getMessage());
        }
    }

    public void addMahasiswa(Mahasiswa m) {
        mahasiswaList.add(m);
    }

    public Mahasiswa findById(int id) {
        for (Mahasiswa m : mahasiswaList) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaList;
    }

}
