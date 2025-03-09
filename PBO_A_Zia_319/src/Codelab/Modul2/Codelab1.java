package Codelab.Modul2;

class Animal{
    private String name;
    private String type;
    private String sound;

    Animal (String name, String type, String sound){
        this.name = name;
        this.type = type;
        this.sound = sound;
    }
    void displayInfo(){
        System.out.println("Name\t: " + this.name);
        System.out.println("Type\t: " + this.type);
        System.out.println("Sound\t: " + this.sound + "\n");
    }
}

public class Codelab1 {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~");
        Animal animal2 = new Animal("Dof", "Mammal", "Woof~Woof~!!");
        animal1.displayInfo();
        animal2.displayInfo();
    }
}
