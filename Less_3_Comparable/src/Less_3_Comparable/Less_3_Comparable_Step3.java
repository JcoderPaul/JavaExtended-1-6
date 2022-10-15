package Less_3_Comparable;

import java.util.*;

/*
Сравнение и сортировка по двум параметрам.
*/
public class Less_3_Comparable_Step3 {
    public static void main(String[] args) {
        /*
        Немного экспериментов на память, способ создания неизменяемых списков List.of(), не
        позволяет использовать некоторые методы класса Collections. Но мы можем использовать
        конструкцию описанную ниже. Т.е. тут приведен пример заполнения списка без метода add().
        */
        List<Teacher> teacherList = new ArrayList<>(List.of(
                new Teacher("Василий","Агапкин",34,3456),
                new Teacher("Василий","Бабушкин",24,2456),
                new Teacher("Василий","Гарин",28,3859),
                new Teacher("Дмитрий","Томин",38,1786),
                new Teacher("Дмитрий","Фокин",43,5476),
                new Teacher("Алексей","Эрнст",54,6436),
                new Teacher("Александр","Якин",58,1456)
        ));
        /*
        Для красоты эксперимента, применим метод перемешивания элементов списка shuffle()
        */
        Collections.shuffle(teacherList);
        for (Teacher teacher:teacherList){
            System.out.println(teacher);
        }
        System.out.println("-----------------------------------------------------------------");
        /*
        А теперь применим сортировку, наш метод compareTo() в классе Teacher делает, как бы
        двойную сортировку. Сначала он сравнивает имена, и если они совпадают, сравнивает фамилии.
        Ну и сортировка будет идти в соответствии с задуманным алгоритмом сравнения.
        */
        Collections.sort(teacherList);
        for (Teacher teacher:teacherList){
            System.out.println(teacher);
        }
    }
}
/*
Важное замечание при имплементации мы параметризуем интерфейс Comparable<Teacher>
нашим классом. В прошлом примере тоже самое, только я не акцентировал на этом внимание.
*/
class Teacher implements Comparable<Teacher>{
    private String name;
    private String surename;
    private int age;
    private double salary;

    public Teacher(String name, String surename, int age, double salary) {
        this.name = name;
        this.surename = surename;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && Double.compare(teacher.salary, salary) == 0 &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(surename, teacher.surename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, age, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Teacher anotherTeacher) {
        int res = this.name.compareTo(anotherTeacher.name);
        if(res == 0){
            res = this.surename.compareTo(anotherTeacher.surename);
        }
        return res;
    }
}
