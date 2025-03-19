package Codelab.Modul3;

public class Hero extends GameChar {
    private Weapon weapon;

        public Hero(String name, int Health, Weapon weapon) {
            super(name, Health);
            this.weapon = weapon;
        }
        //so I use weapon to damage the target
    @Override
    public void Attack(GameChar Target){
        System.out.println(GetName() + " is asttacking " + Target.GetName() + " useing " + weapon.Getname());
        Target.SetHealth(Target.GetHealth()- weapon.GetDamage());
        System.out.println(Target.GetName() + " has Health: "+ Target.GetHealth());
    }
    public void DisplayInfo(){
        System.out.println(GetName() + " has Health: "+ GetHealth());
    }
}