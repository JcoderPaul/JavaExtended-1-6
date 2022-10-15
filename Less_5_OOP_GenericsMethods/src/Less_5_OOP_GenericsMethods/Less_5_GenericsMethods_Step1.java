package Less_5_OOP_GenericsMethods;

import java.util.ArrayList;
import Less_5_OOP_GenericsMethods.MyOwnClasses.*;

/*
Напоминалка по параметризированным классам.
*/
public class Less_5_GenericsMethods_Step1 {
    public static void main(String[] args) {
        // Создаем список 'Integer' для тестирования нашего параметризированного метода
        ArrayList<Integer> int_list = new ArrayList<>();
        int_list.add(34);
        int_list.add(56);
        int_list.add(296);
        int back_my_second_elem = MyGenMethod.getSecondElement(int_list);
        System.out.println(back_my_second_elem);
        // Создаем объект класса 'MySecondParamMethod', как это делалось в примере Less_2_OOP_GenericsClasses
        MySecondParamMethod<Integer> mse = new MySecondParamMethod();
        int get_my_third_elem = mse.getThirdElem(int_list);
        System.out.println(get_my_third_elem);
        System.out.println("--------------------------------------------------------------------------");
        // Создаем список 'Employee' для тестирования нашего параметризированного метода
        ArrayList<Employee> emp_list = new ArrayList<>();
        emp_list.add(new Employee(23,"Разлив","Стаканов",455.76));
        emp_list.add(new Employee(43,"Закос","Подпсихов",545.76));
        emp_list.add(new Employee(12,"Фанат","Приколов",835.76));
        // Ни класс, ни метод не изменились, что для Integer, что для String, что для ...
        Employee get_elem = MyGenMethod.getSecondElement(emp_list);
        System.out.println(get_elem);
        // В примере выше, создание объекта - new MySecondParamMethod(); - прошло без написания '<>'
        MySecondParamMethod<Employee> mse_emp = new MySecondParamMethod<Employee>();
        System.out.println(mse_emp.getThirdElem(emp_list));

    }
}

// Создаем некий класс с методом (набором методов, возможно уникальных)
class MyGenMethod {
    /*
    Текущий метод - возвращает некий объект параметризированный (определенный нами) - 'T'
    Такой синтаксис условно равносилен - public static <String> String getMyFirstStr(ArrayList<String> arr_of_str)
    или вместо 'T' - TYPE, будет подставлено int, double, ... MyWriteObject, как и в примерах с
    классами дженериками - см. Less_2_OOP_GenericsClasses
    */
    public static <T> T getSecondElement(ArrayList<T> list_for_search) {
        return list_for_search.get(1);
    }
   /*
   В текущем примере синтаксис немного изменился, т.к. мы сначала параметризовали класс <T>, а
   уже затем создали внутри него метод возвращающий переменную параметризованную этим же <T> классом,
   т.е., как и в первом случае, могло быть нечто такое -
   public Integer getThirdElem(ArrayList<Integer> list_for_search)
   но поскольку класс 'MySecondParamMethod' уже <T>, то в методе это указание опускается, в отличие от
   предыдущего примера.
   */
}
class MySecondParamMethod<T>{
       public T getThirdElem(ArrayList<T> list_for_search){
           return list_for_search.get(2);
       }
}
