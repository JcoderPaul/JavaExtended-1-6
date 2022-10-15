package Less_3_Comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
Чтобы понять о чем идет речь нужно посмотреть на списки обычных классических переменных,
например string или int. Что можно делать со списками? Например, упорядочивать (сортировать) и
с обычными переменными все более менее понятно - естественная сортировка (цифры по возрастанию
и наоборот, буквы по алфавиту, слова в 'словарном порядке') и т.д.
*/
public class Less_3_Comparable_Step1 {
    public static void main(String[] args) {
        List<String> str_list = Arrays.asList("Глеб", "Дмитрий", "Валентина", "Александр", "Борис");
        System.out.println("Перед сортировкой: " + str_list);
        Collections.sort(str_list); // Сортируем используя метод класса Collections, передавая в метод наш список
        System.out.println("После сортировки: " + str_list);
        Collections.reverse(str_list);
        System.out.println("После обратной сортировки: " + str_list);
        System.out.println("-------------------------------------------------------------------");
        List<Integer> int_list = Arrays.asList(45, 5, -4, -56, 23, 0);
        System.out.println("Перед сортировкой: " + int_list);
        Collections.sort(int_list);
        System.out.println("После сортировки: " + int_list);
        Collections.sort(int_list, Collections.reverseOrder()); // Разворот списка через компаратор
        System.out.println("После обратной сортировки: " + int_list);
    }
    /*
    А как быть если объекты списка придуманы и описаны нами, что будет критерием сортировки?
    */
}
