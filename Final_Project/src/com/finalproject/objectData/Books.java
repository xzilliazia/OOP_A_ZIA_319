package com.finalproject.objectData;

import com.finalproject.masterClass.*;

public class Books extends Media {
    private String writer;
    private String contenType;

    public static final String[] VALID_CONTEN_TYPES = {"Fiksi", "Non-Fiksi", "Komik", "Sastra", "Ensiklopedia"};

    public Books(int id, String title, String genre, boolean available, String writer, String contenType) {
        super(id, title, genre, available);
        this.writer = writer;
        if (contenType == null || !isValidContenType(contenType)) {
            throw new IllegalArgumentException("Tipe konten ivalid.");
        }
        this.contenType = contenType;
    }

    public boolean isValidContenType(String contentype) {
        for (String validtype : VALID_CONTEN_TYPES) {
            if (validtype.equalsIgnoreCase(contentype)) {
                return true;
            }
        }
        return false;
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