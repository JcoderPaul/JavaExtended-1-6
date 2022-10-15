package Less_6_OOP_GenericsWildCard.GameImitation.Players;

public abstract class Professionals {
    private String name;
    private int age;

    public Professionals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
