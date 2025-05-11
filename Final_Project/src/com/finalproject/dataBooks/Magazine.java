package com.finalproject.dataBooks;

import com.finalproject.masterClass.*;

public class Magazine extends Media {
    private String edition;

    public Magazine(int id, String title, String genre, boolean available, String edition) {
        super(id, title, genre, available);
        if (edition == null || edition.trim().isEmpty()) {
            throw new IllegalArgumentException("Edisi tidak boleh kosong");
        }
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", available=" + isAvailable() +
                ", edisi='" + edition + '\'' +
                '}';
    }

    @Override
    public void info() {
        System.out.println("Majalah: " + getTitle() + "\nedisi: " + edition);
    }
}
