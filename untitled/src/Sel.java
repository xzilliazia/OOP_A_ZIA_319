

class Player{
    String name; //default, dia bisa dibaca dan tulis
    public int exp; // Public, bisa baca tulis.
    private int health; //hanya kan bisa dibaca,tulis didalam class saja.

    //construktor
    Player(String name, int exp, int health){
        this.name = name;
        this.exp = exp;
        this.health = health;
    }

    //default modifer access, bisa dibaca diluar
    //membaca didalam class
    void display(){
        System.out.println("\nName\t: " + this.name);
        System.out.println("Exp\t: " + this.exp);
        System.out.println("Health\t: " + this.health);
    }
}

public class Sel {
    public static void main(String[] args) {

        Player player1 = new Player("Satu", 0, 100);

        //default
        System.out.println(player1.name);//membaca
        player1.name = "berbeda";//menulis
        System.out.println(player1.name);//membaca

        //public
        System.out.println(player1.exp);
        player1.exp = 100;
        System.out.println(player1.exp);

        // //Private
        // System.out.println(player1.health);
        // player1.health = 100;
        // System.out.println(player1.health);

        //methods

        //default

        player1.display();

    }
}
