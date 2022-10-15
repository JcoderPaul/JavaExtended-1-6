package Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForHero;

public class Human extends SuperHero{

    public Human(String name, WeaponForHero weaponForHero, int experience) {
        super(name, weaponForHero, experience);
    }

    @Override
    public void usedWeapon(WeaponForHero weapon) {
        System.out.println(getName() + " поменял " +
                          ((WeaponForHero)getWeapon()).getDescription() + " на " +
                            weapon.getDescription());
        setWeapon(weapon);
        setExperience(4);
    }

    @Override
    public void killable() {
        System.out.println(getName() + " искусен в бою с " +
                ((WeaponForHero)getWeapon()).getDescription());
    }

}
