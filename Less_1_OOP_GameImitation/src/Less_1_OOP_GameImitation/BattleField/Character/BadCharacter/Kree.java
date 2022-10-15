package Less_1_OOP_GameImitation.BattleField.Character.BadCharacter;

import Less_1_OOP_GameImitation.BattleField.Character.Weapon.WeaponForBadBoy;

public class Kree extends SuperBadBoy{

    public Kree(String name, WeaponForBadBoy weapon, int experience) {
        super(name, weapon, experience);
    }

    @Override
    public void usedWeapon(WeaponForBadBoy weapon) {
        System.out.println(getName() + " поменял " +
                ((WeaponForBadBoy)getWeapon()).getDescription() + " на " +
                weapon.getDescription());
        setWeapon(weapon);
        setExperience(3);
    }

    @Override
    public void killable() {
        System.out.println(getName() + " безжалостен если в руках у него " +
                ((WeaponForBadBoy)getWeapon()).getDescription());
    }

}
