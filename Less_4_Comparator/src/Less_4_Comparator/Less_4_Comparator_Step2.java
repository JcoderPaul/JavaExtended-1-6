package Less_4_Comparator;

import java.util.*;

/*
Подготовительная часть нашего примера напоминалки, такая же, как и в 'Less_3_Comparable'
Создаем нестандартный класс, объекты которого стандартными средствами JAVA слегка затруднительно
сравнивать и сортировать. Но тут на втором шаге мы создаем пару классов которые все так же имплементируют
интерфейс Comparator см. ниже. Однако их уже два и они работают по-разному.
*/
public class Less_4_Comparator_Step2 {
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
        System.out.println("------------------- Перемешали наш список -------------------");
        // Перемешаем наших актеров и глянем на результат
        Collections.shuffle(my_emp_for_test);
        for (Employee emp_for_prn: my_emp_for_test) {
            System.out.println(emp_for_prn);
        }
        /*
        А теперь применим наши классы NameComparator() и NameReversComparator() для сортировки
        списка по имени в прямом направлении и в обратном, для этого нам необходимо
        либо создать отдельный объект из этого класса, либо сразу передать его в метод *.sort().
        */
        System.out.println("------------------- Прямая (естественная) сортировка по Имени -------------------");
        // Сортируем по имени
        Collections.sort(my_emp_for_test,new NameComparator());
        for (Employee emp_for_prn: my_emp_for_test) {
            System.out.println(emp_for_prn);
        }
        System.out.println("------------------- Реверсивная сортировка по Имени -------------------");
        // Обратная сортировка по имени, т.е. мы не использовали Collections.reverse();
        Collections.sort(my_emp_for_test,new NameReversComparator());
        for (Employee emp_for_prn: my_emp_for_test) {
            System.out.println(emp_for_prn);
        }

        Collections.sort(my_emp_for_test, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getName().compareTo(emp2.getName());
            }
        });

    }
}

/*
Если в примере с интерфейсом Comparable мы имплементировали его и внедряли метод сравнения в сам класс,
объекты которого собирались сравнивать или сортировать их коллекцию, то в данном случае мы создаем
отдельный класс. Например, NameComparator() или NameReversComparator() (теперь будем сравнивать наши
объекты по имени (String)) и снова нужно подписаться на интерфейс Comparator и реализовать его метод
*.compare(), который на вход получает два объекта для сравнения.
*/

class NameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee employee_1, Employee employee_2) {
        /*
        Результат сравнения двух строковых переменных будет в пределах (-Х;0;+Х)
        Причем тут внутри метода *.compare() применяется другой метод сравнения, но уже для
        строковых переменных, который уже реализован и выдает результаты необходимые для нашего
        сравнения.
        */
        int result = employee_1.getName().compareTo(employee_2.getName());
        // Выведем и результаты работы метода *.compareTo(), чтобы увидеть итог его работы
        System.out.println(result);
        // Если имена совпали, то сравниваем по фамилии
        if (result == 0) {
            // Сравнение по фамилии и снова мы получим результат в диапазоне (-X;0;+X)
            result = employee_1.getSurname().compareTo(employee_2.getSurname());
        }
            return result;
    }
}

class NameReversComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee employee_1, Employee employee_2) {
        if (employee_1.getName().compareTo(employee_2.getName()) == 0) {
            return 0;
        } else if (employee_1.getName().compareTo(employee_2.getName()) < 0) {
            return  1;
        } else {
            return -1;
        }
    }
}