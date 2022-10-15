package Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.BadCharacter.SuperBadBoy;
import Less_1_OOP_GameImitation.BattleField.Character.Combattant;
import Less_1_OOP_GameImitation.BattleField.Character.Mortal;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.Killable;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForHero;

public abstract class SuperHero implements Combattant, Mortal{

    public String name;

    private int health = 100;
    private int experience;
    private Killable weapon;

    public SuperHero(String name, WeaponForHero weaponForHero, int experience) {
        this.name = name;
        this.weapon = weaponForHero;
        this.experience = experience;
    }

    public abstract void usedWeapon(WeaponForHero weapon);

    public void attackEnemy(Combattant enemy) {
        System.out.println(getName() + " применил в бою " +
                ((WeaponForHero)getWeapon()).getDescription() + " против " +
                ((SuperBadBoy)enemy).getName());
        int enemyDamage = getWeapon().getDamage() + this.getExperience();
        ((SuperBadBoy)enemy).takeDamage(enemyDamage);
        System.out.println(((SuperBadBoy)enemy).getName() + " получил урон " +
                enemyDamage +
                " его текущее здоровье " + ((SuperBadBoy)enemy).getHealth());
        if(!((SuperBadBoy)enemy).isAlive()){
            System.out.println("Плохиш помер!");
        }
    }

    @Override
    public boolean isAlive() {
        if(health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void takeDamage(int damage){
        if(health > damage){
        this.health -= damage;
        } else {
            health = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(Killable weapon) {
        this.weapon = weapon;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public int getExperience() {
        return experience;
    }

    public Killable getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return "SuperHero {" +
                " name= '" + name + '\'' +
                ", health= " + health +
                ", experience= " + experience +
                '}';
    }
}

