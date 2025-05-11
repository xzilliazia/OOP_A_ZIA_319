package com.finalproject.masterClass;

public enum AccountType {
    MAHASISWA("Mahasiswa"), DOSEN("Dosen"), LIBRARIAN("Pustakawan");

    private final String label;
    AccountType (String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}