package Less_2_OOP_GenericsClasses.MyOwnParametrizedClass;
/*
В данном случае параметр один, но в конструктор поступают два однотипных параметра
*/
public class BlackHoleTwoInOne <V>{
    private V volume_one;
    private V volume_two;

    public BlackHoleTwoInOne(V volume_one, V volume_two) {
        this.volume_one = volume_one;
        this.volume_two = volume_two;
    }

    public V getVolume_one() {
        return volume_one;
    }

    public V getVolume_two() {
        return volume_two;
    }

    @Override
    public String toString() {
        return "BlackHoleTwoInOne {" +
                "volume_one= " + volume_one +
                ", volume_two= " + volume_two +
                '}';
    }
}
