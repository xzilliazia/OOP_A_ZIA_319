package Codelab.Modul2;

public class Codelab2 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("319","Zia", 2000d);
        BankAccount account2 = new BankAccount("024","ia", 4000d);
        //akun 1
        account1.displayInfo();
        account2.displayInfo();
        account1.depositMoney(70000d);
        account1.withDrawMoney(78000d);

        //akun 2
        account2.depositMoney(80000d);
        account2.withDrawMoney(85000d);
    }
}