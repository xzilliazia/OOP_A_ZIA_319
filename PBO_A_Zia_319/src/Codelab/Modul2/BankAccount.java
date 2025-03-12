package Codelab.Modul2;

class BankAccount{
    private String accountNumber;
    private String ownerName;
    private Double balance;

    BankAccount(String accountNumber, String ownerName, Double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public void withDrawMoney(Double amount){
        if (amount > balance){
            System.out.println(this.ownerName + " Menarik Rp."+amount+". (Gagal saldo tidak cukup) Saldo saat ini Rp. "+ balance +"\n");
            return;
        }
        balance -= amount;
        System.out.println(this.ownerName + " Menarik Rp."+ amount + ". (Berhasil) Saldo sekarang Rp."+balance + "\n");
    }
    public void depositMoney(Double amount){
        balance += amount;
        System.out.println(this.ownerName + " menyetor Rp."+ amount + ". Saldo saat ini: Rp."+ balance);
        return;
    }
    void displayInfo(){
        System.out.println("Nomor Rekening\t: "+ this.accountNumber);
        System.out.println("Nama Rekening\t: "+ this.ownerName);
        System.out.println("Saldo\t\t: "+ this.balance+"\n");
    }
}
