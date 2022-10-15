package Less_2_OOP_GenericsClasses;

import Less_2_OOP_GenericsClasses.MyOwnParametrizedClass.*;
import Less_2_OOP_GenericsClasses.MySimpleObject.*;

public class Less_2_OOP_Generics_Step4 {
    public static void main(String[] args) {
        // Двойная параметризация одним неопределенным классом, в данном примере String
        BlackHoleTwoInOne <String> blackHoleTwoInOne =
                new BlackHoleTwoInOne<>("Очень","черная дыра");
        System.out.println(blackHoleTwoInOne.getVolume_one() + " " + blackHoleTwoInOne.getVolume_two());
        // Двойная параметризация одним неопределенным классом, в данном примере "самописным" классом Star
        BlackHoleTwoInOne <Star> double_solar_system =
                new BlackHoleTwoInOne<>(new Star("Мицар",2.4),
                                        new Star("Алькор",3.99));
        System.out.println(double_solar_system.getVolume_one() + " " + double_solar_system.getVolume_two());
    }
}
