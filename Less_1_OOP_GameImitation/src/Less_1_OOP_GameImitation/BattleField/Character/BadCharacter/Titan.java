package Less_1_OOP_GameImitation.BattleField.Character.BadCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForBadBoy;

public class Titan extends SuperBadBoy{

    public Titan(String name, WeaponForBadBoy weapon, int experience) {
        super(name, weapon, experience);
    }

    @Override
    public void usedWeapon(WeaponForBadBoy weapon) {
        System.out.println(getName() + " поменял " +
                ((WeaponForBadBoy)getWeapon()).getDescription() + " на " +
                weapon.getDescription());
        setWeapon(weapon);
        setExperience(4);
    }

    @Override
    public void killable() {
        System.out.println(getName() + " орудует в схватке " +
                ((WeaponForBadBoy)getWeapon()).getDescription());
    }
}
