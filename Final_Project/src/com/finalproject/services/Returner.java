package com.finalproject.services;
import com.finalproject.masterClass.*;
import java.time.LocalDateTime;

public class Returner extends Transaction {
    public Returner(int id, Users user, Media media, LocalDateTime dateTransaction) {
        super(id, user, media, dateTransaction, TransactionType.RETURNING);
    }

    @Override
    public void execute() {
        if (isExecuted()) {
            System.out.println("Transaksi sudah dilakukan sebelumnya.");
            return;
        }

        System.out.printf("Transaksi #%d - Pengembalian oleh %s pada %s\n",
                getId(), getUser().getName(), getDateTransaction());

        getMedia().increaseStock();
        markAsExecuted();
    }
}
