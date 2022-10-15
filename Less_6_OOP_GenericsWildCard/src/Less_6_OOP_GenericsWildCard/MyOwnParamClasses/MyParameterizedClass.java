package Less_6_OOP_GenericsWildCard.MyOwnParamClasses;
/*
Наш параметризованный класс T - TYPE (хранитель типа), K - KEY, V - VALUE, E - ELEMENT
На место буквы Т при использовании данного класса прилетает тот объект,
что мы подставим, см. пример - Less_2_OOP_Generics_Step2
*/

/*
Теперь мы хотим ограничить наш класс сверху, т.е. он может принимать только
определенные классы и их наследников, например Number -> (int, double, ...)
И значит подставить String или какой-либо самописный класс мы уже не сможем.

Если явно не указывать (не ограничивать параметр), то, как и раньше вместо 'T',
можно было подставить любого наследника Object, т.е. почти все что угодно.

Теперь же при добавлении 'extends' мы заранее оговариваем, что может и чего не может наш
параметризированный класс.
*/

public class MyParameterizedClass<T extends Number>{ // Теперь вместо Т идет Number и его наследники
    private T value; // Т -> Number (int, double, long ...)
    /*
    Естественно, что поле 'private T value' не может быть static т.к. принадлежность
    к классу, а не к объекту, не дала бы возможность оперировать ей при изменчивости
    хранителя типов.
    */
    public MyParameterizedClass(T value) {
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
