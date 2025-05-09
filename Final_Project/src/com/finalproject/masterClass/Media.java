package com.finalproject.masterClass;

public abstract class Media extends Entity {
    private String title;
    private boolean available;
    private String genre;

    public Media(int id, String title, String genre, boolean available) {
        super(id);
        setTitle(title);
        this.genre = genre;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void displayInfo() {
        System.out.println("ID: " + getId() + ", Title: " + title + ", Available: " + available);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", genre='" + genre + '\'' +
                '}';
    }

    public abstract void info();
}