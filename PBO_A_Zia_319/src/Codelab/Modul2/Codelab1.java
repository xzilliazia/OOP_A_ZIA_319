package Codelab.Modul2;

class Animal1 {
    private String uname;
    private String type;
    private String sound;

    Animal1(String name, String type, String sound){
        this.uname = name;
        this.type = type;
        this.sound = sound;
    }
    void displayInfo(){
        System.out.println("Name\t: " + this.uname);
        System.out.println("Type\t: " + this.type);
        System.out.println("Sound\t: " + this.sound + "\n");
    }
}
public class Codelab1 {
    public static void main(String[] args) {
        Animal1 animal1 = new Animal1("Cat", "Mammal", "Nyann~~");
        Animal1 animal2 = new Animal1("Dof", "Mammal", "Woof~Woof~!!");
        animal1.displayInfo();
        animal2.displayInfo();
    }
}