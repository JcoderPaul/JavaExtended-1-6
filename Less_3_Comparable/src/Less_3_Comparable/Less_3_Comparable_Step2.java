package Less_3_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/*
Создаем наш класс с параметрами и методами, при этом мы даже сами не знаем как из сортировать,
как минимум, три параметра уже дают три варианта сортировки, а их сочетание еще несколько. Но
стандартные сортировщики Java предназначены для стандартных случаев.
*/
public class Less_3_Comparable_Step2 {
    public static void main(String[] args) {
        List<Student> faculty_list = new ArrayList<>();
        faculty_list.add(new Student("Ника Шторм",3,6.8));
        faculty_list.add(new Student("Борис Бритва",1,7.8));
        faculty_list.add(new Student("Иван Драго",2,6.1));
        faculty_list.add(new Student("Наташа Романофф",5,9.8));
        faculty_list.add(new Student("Глеб Северов",3,4.2));
        faculty_list.add(new Student("Анастасия Каменская",4,7.3));
        for (Student st: faculty_list) {
            System.out.println(st);
        }
        System.out.println("---------------------------------------------------------");
        /*
        Пока все без сюрпризов и данные выводятся в порядке их внесения в список (в ArrayList).
        Но применить стандартные методы сортировки и реверсии класса Collections не получится,
        не понятно как сортировать, уже писал выше. И тогда мы сами определяем, как и по каким
        параметрам делать сортировку.

        Для этого наш самописный класс должен имплементировать интерфейс Comparable ("сравниваемый")
        и переопределить его единственный метод compareTo
        */
        Collections.sort(faculty_list);
        for (Student sortlist: faculty_list) {
            System.out.println(sortlist);
        }
    }
}
/*
Чтобы объекты данного класса можно было сравнивать между собой, подписываемся на
интерфейс Comparable и реализуем его метод int compareTo() см. ниже
*/
class Student implements Comparable<Student>{
    private String name;
    private int course;
    private double average_score;

    public Student(String name, int course, double average_score) {
        this.name = name;
        this.course = course;
        this.average_score = average_score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                         Double.compare(student.average_score, average_score) == 0 &&
                         Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course, average_score);
    }

    @Override
    public String toString() {
        return "Student{" +
                 "name='" + name + '\'' +
                ", course=" + course +
                ", average_score=" + average_score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(double average_score) {
        this.average_score = average_score;
    }
    /*
    Метод возвращает int (-1, 0, 1). Если текущий объект больше объекта переданного в параметре (Student o),
    то 1, если меньше, то -1, и если объекты равны, то 0. Допустим мы договорились сортировать по имени
    студентов и их курсу (хотя это не так наглядно, как курс или успеваемость).

    В примере приведенном ниже развернутый вариант кода метода, его можно было бы сделать предельно
    коротким, например, в случае со строками уже существует метод compareTo и хватило бы одной строки:

    @Override
    public int compareTo(Student anotherStudent) {
        return this.name.compareTo(anotherStudent.name);
    }

    Если бы мы хотели сортировать по курсу, то можно было бы написать так:

    @Override
    public int compareTo(Student anotherStudent) {
        return this.course - anotherStudent.course;
    }

    И тогда сравнение пошло бы по значению int курса.

    Однако сравнивать можно по-разному и развернутый вариант показывает, это наглядно.
    */
    @Override
    public int compareTo(Student anotherStudent) {
        if(this.name == anotherStudent.name){
        return 0;
        } else if (this.name.compareTo(anotherStudent.name) > 0) {
            return 1;
        } else
            return -1;
    }
}
