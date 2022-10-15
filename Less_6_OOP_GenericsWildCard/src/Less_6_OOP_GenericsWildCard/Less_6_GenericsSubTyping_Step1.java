package Less_6_OOP_GenericsWildCard;
/*
Это еще не дикие карты WildCard, это только подготовка к ним.
*/
import Less_6_OOP_GenericsWildCard.MyOwnParamClasses.*;
import Less_6_OOP_GenericsWildCard.SimpleClasses.*;

import java.util.ArrayList;
import java.util.List;

public class Less_6_GenericsSubTyping_Step1 {
    public static void main(String[] args) {
        // Создали объект дочернего класса и ссылаемся на него указателем родительского класса - работает.
        Parent myObject = new Child();
        /*
        <Parent> во вновь созданном листе подсвечен серым, как необязательный, по умолчанию там стоит
        параметр из левой части лексической структуры. Попробуем явно поменять этот параметр на наследника.
         */
        List<Parent> my_work_arr = new ArrayList<Parent>();
        /*
        И вот тут, ошибка на этапе компиляции ->
        -> List<Parent> my_object_list= new ArrayList<Child>();
        Поскольку тут, как минимум совокупность классов (List <-> ArrayList и Parent <-> Child), а не их
        отдельное соответствие. Т.е. может возникнуть ситуация, когда мы в один лист под ссылкой родителя,
        явно параметризитрованного одним из наследников, вдруг, попытаемся затолкать, различных его
        наследников, а не заранее оговоренного.

        List<Number> num_arr = new ArrayList<Integer>();
        num_arr.add(34);
        num_arr.add(82.4);
        */

        MyParameterizedClass<Double> experiment_var = new MyParameterizedClass<>(453.5);
        MyParameterizedClass<Long> experiment_var_2 = new MyParameterizedClass<>(453L);
        /*
        А вот такой код уже не пройдет на этапе компиляции
        MyParameterizedClass<Parent> experiment_var_3 = new MyParameterizedClass<>(new Parent());
        или
        MyParameterizedClass<String> experiment_var_3 = new MyParameterizedClass<>("Моя строка");
        т.к. ни String, ни Parent не являются Number и не его наследник.
        */

        /*
        Вариант когда параметризованный класс форматируется классом и наследующим и имплементирующим,
        и естественно сюда уже не подойдут стандартные классы JAVA (string, int, char ...).
        */
        MyParamClassWithInterface<Mather> parent_exp = new MyParamClassWithInterface<Mather>(new Mather());
    }
}

