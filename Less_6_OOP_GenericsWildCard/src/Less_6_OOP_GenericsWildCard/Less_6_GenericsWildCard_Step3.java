package Less_6_OOP_GenericsWildCard;
/* А вот тут уже про WildCard*/
import java.util.ArrayList;
import java.util.List;

public class Less_6_GenericsWildCard_Step3 {
    public static void main(String[] args) {
        // Так нельзя -> List<Number> myArr = new ArrayList<Integer>();
        // и так нельзя тоже -> List<Object> myArr = new ArrayList<String>();
        // а вот так можно ->
        List<?> my_int_arr = new ArrayList<Integer>();

        List<Double> my_double_list = new ArrayList<>();
        my_double_list.add(45.2);
        my_double_list.add(25.6);
        my_double_list.add(5.2);
        printList(my_double_list);
        List<String> my_str_list = new ArrayList<>();
        my_str_list.add("Троль");
        my_str_list.add("Гнет");
        my_str_list.add("Ель");
        printList(my_str_list);
        List<Gun> my_gun_list = new ArrayList<>();
        my_gun_list.add(new Gun("АК-47", 7.62));
        my_gun_list.add(new Gun("AR-15", 5.56));
        my_gun_list.add(new Gun("Scorpion EVO 3", 9));
        printList(my_gun_list);

    }
    // Метод позволяющий печатать списки любого формата, тест в методе main
    public static void printList(List<?> myList){
        System.out.println("Мой список выглядит так-> " + myList);
    }
}

class Gun {
    String name;
    double caliber;

    public Gun(String name, double caliber) {
        this.name = name;
        this.caliber = caliber;
    }

    public String getName() {
        return name;
    }

    public double getCaliber() {
        return caliber;
    }

    @Override
    public String toString() {
        return "Gun {" +
                "name= '" + name + '\'' +
                ", caliber= " + caliber +
                '}';
    }
}