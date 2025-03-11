package Codelab.Modul2;

public class MainAnimal {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~");
        Animal animal2 = new Animal("Dof", "Mammal", "Woof~Woof~!!");
        animal1.displayInfo();
        animal2.displayInfo();
    }
}
