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