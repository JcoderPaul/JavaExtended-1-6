package Less_2_OOP_GenericsClasses.MySimpleObject;

public class Planet {
    String name;
    double brightness;

    public Planet(String name, Double brightness) {
        this.name = name;
        this.brightness = brightness;
    }

    public String getName() {
        return name;
    }

    public double getBrightness() {
        return brightness;
    }

    @Override
    public String toString() {
        return "Planet {" +
                "name= '" + name + '\'' +
                ", brightness=' " + brightness + '\'' +
                '}';
    }
}
