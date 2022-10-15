package Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.Combattant;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForHero;

public class Asgardian extends SuperHero implements Combattant {

    public Asgardian(String name, WeaponForHero weaponForHero, int experience) {
        super(name, weaponForHero, experience);
    }

    @Override
    public void usedWeapon(WeaponForHero weapon) {
        System.out.println(getName() + " поменял " +
                ((WeaponForHero)getWeapon()).getDescription() + " на " +
                weapon.getDescription());
        setWeapon(weapon);
        setExperience(8);
    }


    @Override
    public void killable() {
        System.out.println(getName() + " непобедим если использует " +
                ((WeaponForHero)getWeapon()).getDescription());
    }
}
