package com.finalproject.services;
import java.time.LocalDateTime;
import com.finalproject.masterClass.*;

public class Lending extends Transaction {
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
            System.out.println("Media tidak tersedia.");
            return;
        }

        System.out.printf("Transaksi #%d - Peminjaman oleh %s pada %s\n",
                getId(), getUser().getName(), getDateTransaction());

        getMedia().decreaseStock();
        markAsExecuted();
    }
}
