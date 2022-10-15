package Less_2_OOP_GenericsClasses.MyOwnParametrizedClass;
/*
Наш параметризованный класс T - TYPE (хранитель типа), K - KEY, V - VALUE, E - ELEMENT
На место буквы Т при использовании данного класса прилетает тот объект,
что мы подставим, см. пример - Less_2_OOP_Generics_Step2
*/
public class SpaceObject<T>{
    private T value;
    /*
    Естественно, что поле 'private T value' не может быть static т.к. принадлежность
    к классу, а не к объекту, не дала бы возможность оперировать ей при изменчивости
    хранителя типов.
    */
    public SpaceObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" + value + "}";
    }
}
