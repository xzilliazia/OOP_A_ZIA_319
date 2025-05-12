package com.finalproject.dataBooks;
import java.util.Set;
import com.finalproject.masterClass.*;

public class Books extends Media {
    private String writer;
    private String contenType;

    public static final Set<String> VALID_CONTEN_TYPES = Set.of("Fiksi", "Non-Fiksi", "Komik", "Sastra", "Ensiklopedia");

    public Books(int id, String title, String genre, boolean available, String writer, String contenType) {
        super(id, title, genre, available);
        
        if (writer == null || writer.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        if (contenType == null || !isValidContenType(contenType)) {
            throw new IllegalArgumentException("Tipe konten tidak valid.");
        }
        
        this.writer = writer;
        this.contenType = contenType;
    }

    public boolean isValidContenType(String contentype) {
        return VALID_CONTEN_TYPES.stream().anyMatch(valid -> valid.equalsIgnoreCase(contentype));
    }
    public String getContenType() {
        return contenType;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        if (writer == null || writer.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        this.writer = writer;
    }

    public void setContenType(String contenType) {
        if (contenType == null || !isValidContenType(contenType)) {
            throw new IllegalArgumentException("Tipe konten tidak valid.");
        }
        this.contenType = contenType;
    }

    @Override
    public void info() {
        System.out.println("Buku: " + getTitle() + "\nPenulis: " + writer + "\nTipe: " + contenType);
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", available=" + isAvailable() +
                ", writer='" + writer + '\'' +
                ", contenType='" + contenType + '\'' +
                '}';
    }
}