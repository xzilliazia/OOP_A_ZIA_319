package com.finalproject.masterClass;
import java.time.LocalDateTime;

public abstract class Transaction extends Entity {
    private Users user;
    private Media media;
    private LocalDateTime dateTransaction;

    public Transaction(int id, Users user, Media media, LocalDateTime dateTransaction) {
        super(id);
        if (user == null || media == null) {
            throw new IllegalArgumentException("User  and Media cannot be null");
        }
        this.media = media;
        this.dateTransaction = dateTransaction;
    }

    public Users getUser() {
        return user;
    }

    public Media getMedia() {
        return media;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public abstract void execute();
}

//other class
class Lending extends Transaction {
    public Lending(int id, Users user, Media media, LocalDateTime dateTransaction) {
        super(id, user, media, dateTransaction);
    }

    @Override
    public void execute() {
        System.out.println("Peminjaman oleh " + getUser().getName() + " pada tanggal " + getDateTransaction());
        getMedia().setAvailable(false);
    }
}

class Returner extends Transaction {
    public Returner(int id, Users user, Media media, LocalDateTime dateTransaction) {
        super(id, user, media, dateTransaction);
    }

    @Override
    public void execute() {
        System.out.println("Pengembalian oleh " + getUser().getName() + " pada tanggal " + getDateTransaction());
        getMedia().setAvailable(false);
    }
}