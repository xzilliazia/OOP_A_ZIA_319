package Codelab.Modul3;

class GameChar {
    private String name;
    private int Health;

    GameChar (String name, int Health ){
        this.name = name;
        this.Health = Health;
    }
    //getter
    public String GetName(){
        return this.name;
    }
    public int GetHealth(){
        return this.Health;
    }
    //setter
    public void SetName(String name){
        this.name = name;
    }
    // public void SetHealth(int Health){
    //     this.Health = Health;
    // }

    public void Attack(GameChar Target){
        System.out.println(name + " Menyerang "+ Target.GetName());
    }
    public void DisplayInfo(){
        System.out.println(GetName() + " has Health: "+ GetHealth());
    }
}