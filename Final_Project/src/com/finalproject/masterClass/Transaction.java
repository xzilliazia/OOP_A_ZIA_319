package com.finalproject.masterClass;
import java.time.LocalDateTime;
import com.finalproject.actions.Executable;

public abstract class Transaction extends Entity implements Executable{
    private final Users user;
    private final Media media;
    private final LocalDateTime dateTransaction;
    private final TransactionType type;

    public Transaction(int id, Users user, Media media, LocalDateTime dateTransaction, TransactionType type) {
        super(id);
        if (user == null) throw new IllegalArgumentException("User tidak boleh null");
        if (media == null) throw new IllegalArgumentException("Media tidak boleh null");
        if (type == null) throw new IllegalArgumentException("Tipe transaksi tidak boleh null");
        this.user = user;
        this.media = media;
        this.dateTransaction = (dateTransaction != null) ? dateTransaction : LocalDateTime.now();
        this.type = type;
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

    private boolean executed = false;
    public boolean isExecuted() {
        return executed;
    }

    protected void markAsExecuted() {
        this.executed = true;
    }

}

//other class
//for lending and return the book
class Lending extends Transaction {
    public Lending(int id, Users user, Media media, LocalDateTime dateTransaction) {
        super(id, user, media, dateTransaction, TransactionType.LENDING);
    }

    @Override
    public void execute() {
    if (isExecuted()) {
        System.out.println("Transaksi sudah dilakukan sebelumnya.");
        return;
    }
    if (!getMedia().isAvailable()) {
        System.out.println("Media sudah dipinjam dan tidak tersedia.");
        return;
    }
    System.out.printf("Transaksi #%d - Peminjaman oleh %s pada %s\n",
        getId(), getUser().getName(), getDateTransaction());

    getMedia().setAvailable(false);
    markAsExecuted();
}

}

class Returner extends Transaction {
    public Returner(int id, Users user, Media media, LocalDateTime dateTransaction) {
        super(id, user, media, dateTransaction, TransactionType.RETURNING);
    }
    @Override
    public void execute() {
        if (isExecuted()) {
            System.out.println("Transaksi sudah dilakukan sebelumnya.");
            return;
        }

        if (getMedia().isAvailable()) {
            System.out.println("Media ini belum dipinjam — tidak bisa dikembalikan.");
            return;
        }

    System.out.printf("Transaksi #%d - Pengembalian oleh %s pada %s\n",
            getId(), getUser().getName(), getDateTransaction());

    getMedia().setAvailable(true);
    markAsExecuted();
}

}