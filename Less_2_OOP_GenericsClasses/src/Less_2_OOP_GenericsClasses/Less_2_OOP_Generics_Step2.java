package Less_2_OOP_GenericsClasses;

import Less_2_OOP_GenericsClasses.MyOwnParametrizedClass.*;
import Less_2_OOP_GenericsClasses.MySimpleObject.*;

public class Less_2_OOP_Generics_Step2 {
    public static void main(String[] args) {
        SpaceObject<String> stringSpaceObject = new SpaceObject<>("Примет мир Дженериков!");
        System.out.println(stringSpaceObject);
        String str_value = stringSpaceObject.getValue();

        SpaceObject<Integer> integerSpaceObject = new SpaceObject<>(1_000_000);
        System.out.println(integerSpaceObject);
        Integer integer_value = integerSpaceObject.getValue();

        SpaceObject<Star> proxima_centauri = new SpaceObject<>(new Star("Альфа Центавра",+11.1));
        System.out.println(proxima_centauri);
        System.out.println(proxima_centauri.getValue());

        SpaceObject<Planet> moon = new SpaceObject<>(new Planet("Луна",-12.74));
        System.out.println(moon);
        System.out.println(moon.getValue());
    }
}
