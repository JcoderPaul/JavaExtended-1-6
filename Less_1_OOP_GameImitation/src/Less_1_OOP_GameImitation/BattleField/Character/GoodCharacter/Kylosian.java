package Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForHero;

public class Kylosian extends SuperHero{

    public Kylosian(String name, WeaponForHero weaponForHero, int experience) {
        super(name, weaponForHero, experience);
    }
    @Override
    public void usedWeapon(WeaponForHero weapon) {
        System.out.println(getName() + " поменял " +
                ((WeaponForHero)getWeapon()).getDescription() + " на " +
                weapon.getDescription());
        setWeapon(weapon);
        setExperience(6);
    }

    @Override
    public void killable() {
        System.out.println(getName() + " может применить в бою " +
                          ((WeaponForHero)getWeapon()).getDescription());
    }
}
