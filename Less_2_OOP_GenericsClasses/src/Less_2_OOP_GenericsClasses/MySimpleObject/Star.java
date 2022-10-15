package Less_2_OOP_GenericsClasses.MySimpleObject;

public class Star {
    String name;
    double brightness;

    public Star(String name, Double brightness) {
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
        return "Star {" +
                "name= '" + name + '\'' +
                ", brightness=' " + brightness + '\'' +
                '}';
    }
}
