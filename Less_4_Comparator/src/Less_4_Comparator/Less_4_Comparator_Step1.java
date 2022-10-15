package Less_4_Comparator;

import java.util.*;

/*
Подготовительная часть нашего примера напоминалки, такая же, как и в 'Less_3_Comparable'
Создаем нестандартный класс, объекты которого стандартными средствами JAVA слегка затруднительно
сравнивать и сортировать. Но тут на первом шаге мы создаем некий класс который имплементирует
интерфейс Comparator см. ниже.
*/
public class Less_4_Comparator_Step1 {
    public static void main(String[] args) {
        List<Employee> my_emp_for_test = new ArrayList<>();
        my_emp_for_test.add(new Employee(11,"Игорь","Верник",3245.45));
        my_emp_for_test.add(new Employee(25,"Игорь","Угольников",2245.43));
        my_emp_for_test.add(new Employee(32,"Михаил","Пареченков",6265.15));
        my_emp_for_test.add(new Employee(48,"Юлия","Снегирь",5245.15));
        my_emp_for_test.add(new Employee(56,"Маруся","Климова",3245.48));
        my_emp_for_test.add(new Employee(69,"Сергей","Маховиков",13452.44));
        my_emp_for_test.add(new Employee(75,"Анатолий","Папанов",45366.23));
        my_emp_for_test.add(new Employee(82,"Наталья","Варлей",32731.48));
        // Перемешаем наших актеров и глянем на результат
        Collections.shuffle(my_emp_for_test);
        for (Employee emp_for_prn: my_emp_for_test) {
            System.out.println(emp_for_prn);
        }
        System.out.println("------------------- Сортируем по ID -------------------");
        /*
        А теперь применим наш класс IdComparator для сортировки списка по ID, для этого нам необходимо
        либо создать отдельный объект из этого класса, либо сразу передать его в метод *.sort().

        Что изменилось? Возможности! Мы можем создать несколько подобных классов, которые будут сортировать
        по выбранному параметру или набору параметров (что-то знакомое!!! мелькнул призрак Lambda,
        но все по шагам).
        */
        Collections.sort(my_emp_for_test,new IdComparator());
        for (Employee emp_for_prn: my_emp_for_test) {
            System.out.println(emp_for_prn);
        }

    }
}

/*
Если в примере с интерфейсом Comparable мы имплементировали его и внедряли метод сравнения в сам класс,
объекты которого собирались сравнивать или сортировать их коллекцию, то в данном случае мы создаем
отдельный класс. Например, IdComparator (пусть, будем сравнивать наши объекты по id (int)) должен
подписаться на интерфейс Comparator и реализовать его метод *.compare(), который на вход получает
два объекта для сравнения. Ну, а дальше логика кода очень похожа на *.compareTo()
*/
class IdComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee employee_1, Employee employee_2) {
        if (employee_1.getId() == employee_2.getId()){
        return 0;
        } else if (employee_1.getId() > employee_2.getId()){
            return 1;
        } else
            return -1;
    }
}
