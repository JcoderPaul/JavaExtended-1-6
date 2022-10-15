package Less_2_OOP_GenericsClasses;

import Less_2_OOP_GenericsClasses.MyOwnParametrizedClass.PlanetSystem;
import Less_2_OOP_GenericsClasses.MySimpleObject.Planet;
import Less_2_OOP_GenericsClasses.MySimpleObject.Star;

public class Less_2_OOP_Generics_Step3 {
    public static void main(String[] args) {
        /*
        Немного притянуто за уши, но четко показывает, что в наш класс параметризованный двумя параметрами
        легко просачиваются привычные переменные. И любые другие, например придуманные нами.
        */
        PlanetSystem<String, Double> double_par_test = new PlanetSystem<>("Диаметр земли", 12742.4);
        System.out.println(double_par_test.getPlanet() + " " + double_par_test.getSolar());

        PlanetSystem<Star, Planet> solar_system = new PlanetSystem<>(new Star("Капелла", -0.12),
                                                                     new Planet("WASP-12b", -0.21));
        System.out.println(solar_system.getSolar() + "\n" + solar_system.getPlanet());
    }
}
