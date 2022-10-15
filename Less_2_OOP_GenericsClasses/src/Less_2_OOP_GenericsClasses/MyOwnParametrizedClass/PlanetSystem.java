package Less_2_OOP_GenericsClasses.MyOwnParametrizedClass;
/*
Класс имеет два параметра (и это не обязательно солнце и планета)
*/
public class PlanetSystem <S, P>{
    private S solar;
    private P planet;

    public PlanetSystem(S solar, P planet) {
        this.solar = solar;
        this.planet = planet;
    }

    public S getSolar() {
        return solar;
    }

    public P getPlanet() {
        return planet;
    }
}
