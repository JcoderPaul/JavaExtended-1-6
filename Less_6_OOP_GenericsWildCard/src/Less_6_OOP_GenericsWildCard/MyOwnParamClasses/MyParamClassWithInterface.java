package Less_6_OOP_GenericsWildCard.MyOwnParamClasses;
/*
Это еще не дикие карты WildCard, это только подготовка к ним.
*/
import Less_6_OOP_GenericsWildCard.SimpleClasses.*;

/*
Так же наш класс может имплементировть интерфейсы, сразу после класса родителя, объединение
проходит через символ '&'
*/
public class MyParamClassWithInterface<T extends Parent&MyCoolInterfaceOne&MyCoolInterfaceTwo> {
    private T parameter;

    public MyParamClassWithInterface(T parameter) {
        this.parameter = parameter;
    }

    public T getParameter() {
        return parameter;
    }
}

