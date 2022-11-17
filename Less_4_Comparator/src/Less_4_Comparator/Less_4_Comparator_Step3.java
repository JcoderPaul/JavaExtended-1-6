package Less_4_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Третий шаг нашей напоминалки, такая же, как и в 'Less_3_Comparable' и на первых двух шагах,
создаем и используем нестандартный класс, объекты которого стандартными средствами JAVA слегка затруднительно
сравнивать и сортировать.

И тут мы подобрались к анонимным классам и лямбда выражениям при использовании интерфейса Comparator см. ниже.
*/
public class Less_4_Comparator_Step3 {
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
        Используем анонимный класс при сортировке, естественно наш класс имплементирует интерфейс Comparator
        и реализует метод *.compare() в котором мы уже почти на лету прописываем методику сравнения (как и
        по каким полям идет сравнение наших объектов Employee)

        Далее, та же технология применяется при использовании лямбда выражений (сложность сравнения определяем
        и прописываем мы, как это было в уроках-напоминалках по JavaBegin - Less_29_myFirstLambda -
        https://github.com/JcoderPaul/JavaBegin/tree/master/Less_29_myFirstLambda/src)
        */
        System.out.println("------------------- Прямая (естественная) сортировка по Имени, анонимный класс -------------------");
        Collections.sort(my_emp_for_test, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getName().compareTo(emp2.getName());
            }
        });
        for (Employee emp_from_anonymous_class: my_emp_for_test) {
            System.out.println(emp_from_anonymous_class);
        }
        System.out.println("------------------- Прямая (естественная) сортировка по Фамилии, через Lambda -------------------");
        Collections.sort(my_emp_for_test, (emp1, emp2) -> emp1.getSurname().compareTo(emp2.getSurname()));
        for (Employee emp_from_lambda: my_emp_for_test) {
            System.out.println(emp_from_lambda);
        }
        System.out.println("------------------- Снова прямая (естественная) сортировка по Имени, через *.comparing() -------------------");
        Collections.sort(my_emp_for_test, Comparator.comparing(Employee::getName));
        for (Employee emp_from_comparing: my_emp_for_test) {
            System.out.println(emp_from_comparing);
        }
		System.out.println("------------------- Пример каскадирования метода *.comparing() и *.thenComparing -------------------");
        // В данном примере сравнение сначала происходит по одному полю класса, затем по другому.
        Collections.sort(my_emp_for_test, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        for (Employee emp_from_comparing: my_emp_for_test) {
            System.out.println(emp_from_comparing);
        }
    }
}
