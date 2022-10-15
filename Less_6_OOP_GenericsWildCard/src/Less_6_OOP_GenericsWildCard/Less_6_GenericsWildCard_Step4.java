package Less_6_OOP_GenericsWildCard;

import java.util.ArrayList;
import java.util.List;

public class Less_6_GenericsWildCard_Step4 {
    public static void main(String[] args) {
        List<?> myArray = new ArrayList<String>();
        // Так нельзя -> myArray.add("Горка");
        List<? extends Number> myAnotherArray = new ArrayList<Integer>();
        // И так нельзя -> myAnotherArray.add(7); в обоих случаях отсутствует определенность!
        ArrayList<Double> arr_for_summa = new ArrayList<>(); // А вот тут нет, все четко
        arr_for_summa.add(34.1);
        arr_for_summa.add(45.2);
        arr_for_summa.add(64.1);
        System.out.println(getSumma(arr_for_summa));
        ArrayList<Integer> arr_for_summa_int = new ArrayList<>();
        arr_for_summa_int.add(23);
        arr_for_summa_int.add(56);
        arr_for_summa_int.add(75);
        System.out.println(getSumma(arr_for_summa_int));
    }
    // Метод позволяющий суммировать элементы списка наследника Number
    public static double getSumma(ArrayList<? extends Number> myList){
        double summa = 0;
        for (Number get_arr: myList) {
            summa += get_arr.doubleValue();
    /*
    Метод xxxValue() – преобразует в Java числовое значение объекта, который вызывает метод,
    в примитивный тип данных, который возвращается из метода.

    Здесь каждый примитивный тип данных представляет отдельный метод:
    -    byte byteValue() // Преобразование в byte
    -    short shortValue() // Преобразование в short
    -    int intValue() // Преобразование в int
    -    long longValue() // Преобразование в long
    -    float floatValue() // Преобразование в float
    -    double doubleValue() // Преобразование в double
    */
        }
        return summa;
    }
}
