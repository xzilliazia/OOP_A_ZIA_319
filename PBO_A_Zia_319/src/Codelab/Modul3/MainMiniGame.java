package Codelab.Modul3;

public class MainMiniGame {
    public static void main(String[] args) {
        GameChar GeneralCharacter = new GameChar("General Character", 100);
        //Weapon
        Weapon weapon1 = new Weapon("Sword", 20);
        Weapon weapon2 = new Weapon("Magic", 40);
        //Heero
        Hero hero1 = new Hero("Brimstone", 150, weapon1);
        //Enemy
        Enemy enemy1 = new Enemy("Viper", 120, weapon2);

        //Pertempuran
        GeneralCharacter.DisplayInfo();
        hero1.DisplayInfo();
        enemy1.DisplayInfo();

        enemy1.Attack(hero1);
        hero1.Attack(enemy1);
        
    }
}
