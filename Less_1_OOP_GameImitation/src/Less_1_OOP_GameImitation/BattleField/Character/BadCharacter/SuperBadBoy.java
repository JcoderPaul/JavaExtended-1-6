package Less_1_OOP_GameImitation.BattleField.Character.BadCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.Combattant;
import Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter.SuperHero;
import Less_1_OOP_GameImitation.BattleField.Character.Mortal;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.Killable;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForBadBoy;

public abstract class SuperBadBoy implements Combattant, Mortal {

    public String name;
    private int health = 100;
    private int experience;
    private Killable weapon;

    public SuperBadBoy(String name, WeaponForBadBoy weapon, int experience) {
        this.name = name;
        this.weapon = weapon;
        this.experience = experience;
    }

    public abstract void usedWeapon(WeaponForBadBoy weapon);

    @Override
    public void attackEnemy(Combattant enemy) {
        System.out.println(getName() + " применил в бою " +
                ((WeaponForBadBoy)getWeapon()).getDescription() + " против " +
                ((SuperHero)enemy).getName());
        int enemyDamage = getWeapon().getDamage() + this.getExperience();
        ((SuperHero)enemy).takeDamage(enemyDamage);
        System.out.println(((SuperHero)enemy).getName() + " получил урон " +
                enemyDamage +
                " его текущее здоровье " + ((SuperHero)enemy).getHealth());
        if(!((SuperHero)enemy).isAlive()){
            System.out.println("Герой помер!");
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
        return "SuperBadBoy {" +
                " name= '" + name + '\'' +
                ", health= " + health +
                ", experience= " + experience +
                '}';
    }
}

