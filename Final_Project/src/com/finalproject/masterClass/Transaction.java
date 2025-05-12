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
    public TransactionType getType() {
        return type;
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