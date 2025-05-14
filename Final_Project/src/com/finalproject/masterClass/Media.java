package com.finalproject.masterClass;

public abstract class Media extends Entity {
    private String title;
    private int stock;

    public Media(int id, String title, int stock) {
        super(id);
        setTitle(title);
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    //for stok
    public void decreaseStock() {
        if (stock <= 0) throw new IllegalStateException("Stok habis");
        stock--;
    }

    public void increaseStock() {
        stock++;
    }
    
    public abstract void info();

    @Override
    public String toString() {
        return "Media{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", stock='" + stock + '\'' +
                '}';
    }

}