package Less_1_OOP_GameImitation.BattleField.Character.Weapon;

public enum WeaponForHero implements Killable{
    BOW ("Лук", 15),
    PISTOL ("Пистолет", 10),
    AUTOMATIC_GUN ("Автомат", 20),
    MJOLLNIR("Мьелнир", 45),
    FLYING_SHIELD("Летающий щит", 13),
    KNIFE("Нож", 7),
    SOME_KIND_OF_MAGIC("Светлая магия", 41);

    private String description;
    private int damage;

    WeaponForHero(String description, int damage) {
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
