package Task.Modul3;

public class Weapon {
    private int Damage;
    private String nameWeapon;
    
    public Weapon(String nameWeapon, int Damage){
        this.nameWeapon = nameWeapon;
        this.Damage = Damage;
    }
    public String Getname(){
        return nameWeapon;
    }
    public int GetDamage(){
        return Damage;
    }
}