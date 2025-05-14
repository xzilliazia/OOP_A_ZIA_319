package com.finalproject.dataBooks;
import com.finalproject.masterClass.*;
import java.util.Set;


public class Magazine extends Media {
    private String edition;

    public static final Set<String> VALID_CONTEN_TYPES = Set.of("Fiksi", "Non-Fiksi", "Komik", "Sastra", "Ensiklopedia");

    public Magazine(int id, String title, int stock, String edition) {
        super(id, title, stock);
        
        if (edition == null || edition.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        this.edition = edition;
    }

    public boolean isValidContenType(String contentype) {
        return VALID_CONTEN_TYPES.stream().anyMatch(valid -> valid.equalsIgnoreCase(contentype));
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        if (edition == null || edition.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        this.edition = edition;
    }

    @Override
    public void info() {
        System.out.println("Majalah: " + getEdition() + "\nEdisi: " + edition + "\nStock: " + getStock());
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", title='" + getEdition() + '\'' +
                ", stock=" + getStock() +
                ", edition='" + edition + '\'' +
               '}';
    }
}