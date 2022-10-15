package Less_6_OOP_GenericsWildCard;
/* !!!! ПЕРЕГРУЗИТЬ МЕТОДЫ С ДЖЕНЕРИКАМИ НЕ ПОЛУЧАЕТСЯ !!!! */
import Less_6_OOP_GenericsWildCard.MyOwnParamClasses.MySimpleParamClass;
/* !!!! ПЕРЕЗАПИСАТЬ МЕТОДЫ С ДЖЕНЕРИКАМИ НЕ ПОЛУЧАЕТСЯ !!!! */
import java.util.ArrayList;

/*
Для совместимости более старого и нового кода JVM не знает о дженериках, хотя код проходит на
этапе компиляции, в рантайм происходит кастомизация до выбранного (указанного) типа.

Heap pollution – ситуация, когда эта защита не срабатывает, и переменная параметризованного типа
хранит в себе объект, параметризованный другим типом. Простейший пример:
List<String> strings = (List) new ArrayList<Integer>();

Heap pollution может произойти в двух случаях: при использовании массивов дженериков и при
смешивании параметризованных и raw-типов. Raw types – это параметризованные типы без указания параметра.
Использовать raw types не рекомендуется, причины подробно изложены в главе 26 Effective Java.
Если информация о дженериках не нужна, лучше использовать символ wildcard (<?>).
*/
public class Less_6_GenericsTypeErasure_Step2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr_of_int = new ArrayList<>();
        /*
        В процессе работы JVM происходит -> ArrayList arr_of_int = new ArrayList(),
        т.е. происходит работа со списком row type, т.е. внутри списка лежат Object
        */
        int i = arr_of_int.get(0);
        /*
        Для JVM код приведенный выше выглядит так -> int i = (Integer) arr_of_int.get(0);
        т.е. OBJECT кастомизируется до INTEGER. Это и есть стирание типов, которая нужна
        для поддержания обратной совместимости кода.

        Использование raw types не оправдано – спецификация языка явно говорит: их поддержка
        остается только для обратной совместимости.

        Есть всего три случая, когда использовать обобщенный тип без параметра правильно:
            - Целевая версия Java < 5.0 (2002 год и ранее);
            - В литерале класса, List<String>.class не сработает, нужно писать List.class;
            - В операторе instanceof, вместо instanceof Set<Integer> должно быть instanceof Set.
        */
    }

    /*
    Теоретически код описанный ниже похож на обычную перегрузку метода, однако компилятор его не
    пропустит. Т.к. возникает ситуация описанная выше, JVM не знает дженерики, и после стирания типов,
    эти методы абсолютно идентичны по сигнатуре и принятым аргументам ->
    public void infoMeth (MySimpleParamClass value)
    Т.е. может остаться только один...
    */

    /*
    либо этот (можно раскомментировать и увидеть результат уже на этапе компиляции)

    public void infoMeth(MySimpleParamClass<String> value){
        String str_of_value = value.getValue();
    }

    либо тот, что ниже
    */

    public void infoMeth(MySimpleParamClass<Integer> value){
        Integer int_of_value = value.getValue();
    }

    /*
    !!!! ПЕРЕГРУЗИТЬ МЕТОДЫ С ДЖЕНЕРИКАМИ НЕ ПОЛУЧАЕТСЯ !!!!
    ПОСМОТРИМ, ЧТО ПОЛУЧИТСЯ С ПЕРЕЗАПИСЬЮ ?!
    */
}

/*
Как и в примере выше компилятор будет ругаться на код типа ->

class BigDad{
    public void getInfo(MySimpleParamClass<Integer> value){
        Integer int_of_value = value.getValue();
    }
}

class LittleChild extends BigDad{
    public void getInfo(MySimpleParamClass<String> value){
        String str_of_value = value.getValue();
    }
}

Хотя все правила формально соблюдены, но стирание типов работает и перезаписи метода не произошло.
И вот тут компилятор в который раз намекает, что было бы не плохо применить дикие карты - WildCard
или <?>. (читайте Джорджа Мартина)
*/
class BigDad{
    public void getInfo(MySimpleParamClass<?> value){
        Integer int_of_value = (Integer) value.getValue();
    }
}

class LittleChild extends BigDad{
    public void getInfo(MySimpleParamClass<?> value){
        String str_of_value = (String) value.getValue();
    }
}