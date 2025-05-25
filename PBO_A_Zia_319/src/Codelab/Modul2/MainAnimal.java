package Codelab.Modul2;

public class MainAnimal {
    public static void main(String[] args) {
        Animal1 animal1 = new Animal1("Cat", "Mammal", "Nyann~~");
        Animal1 animal2 = new Animal1("Dof", "Mammal", "Woof~Woof~!!");
        
        animal1.displayInfo();
        animal2.displayInfo();
    }
}