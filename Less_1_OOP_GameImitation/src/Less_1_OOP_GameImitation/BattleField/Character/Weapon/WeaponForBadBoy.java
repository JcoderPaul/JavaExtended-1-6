package Less_1_OOP_GameImitation.BattleField.Character.Weapon;

public enum WeaponForBadBoy implements Killable{
    LASER_BOW ("Лазерный лук", 18),
    PLASMA_PISTOL ("Плазменный пистолет", 17),
    ATOMIC_AUTOMATIC_GUN ("Атомная автоматическая винтовка", 21),
    UNIVERSAL_WEAPON ("Вселенский молот правосудия", 48),
    NECRO_SWORD ("Некромеч", 61),
    ENERGY_SPEAR ("Энергетическое копье", 14),
    SOME_KIND_OF_MAGIC ("Темная магия", 42);

    private String description;
    private int damage;

    WeaponForBadBoy(String description, int damage) {
        this.description = description;
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
