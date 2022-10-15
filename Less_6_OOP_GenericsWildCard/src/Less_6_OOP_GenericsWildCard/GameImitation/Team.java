package Less_6_OOP_GenericsWildCard.GameImitation;

import Less_6_OOP_GenericsWildCard.GameImitation.Players.Professionals;
/*
В данном примере мы создаем некий универсальный класс позволяющий работать только
с наследниками другого специализированного класса.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
Класс параметризирован любым типом наследующим класс Professionals
(чтобы сюда нельзя было поместить например String, Integer, ...)
*/
public class Team <T extends Professionals>{
    private String name;
    /*
    Список параметризирован тем же типом, что и класс Team, т.е. жестко ограничен нашим
    самописным классом и его наследниками.
    */
    private List<T> team_for_play = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
    /*
    То же самое, что и несколько строк выше, параметр Т определяет, ссылка какого класса, может
    попасть в массив, параметрезированный тем же параметром. Т.е. в массив полисменов, мы не сможем
    поместить объект пожарный или гвардеец.
    */
    public void addNewProfessional (T profi){
        team_for_play.add(profi);
        System.out.println("В команду " + name + " попал " + profi.getName());
    }

    /*
    Имитация честной игры, когда в схватке участвуют, только однотипные команды, т.е. копы с копами,
    гвардия с гвардией.
    */
    public void playWith(Team<T> team){
        String winnerName;
        Random random = new Random();
        // int nextInt(int n) - возвращает следующее случайное значение типа int в диапазоне от 0 до n
        int i = random.nextInt(2); // на выходе 0 или 1
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("В схватке между '" + this.name +
                           "' и '" + team.name +
                           "' победила команда -> " + winnerName);
    }
    // Махач без разбора!
    public void mortalKombat(Team team){
        String winnerName;
        Random random = new Random();
        // int nextInt(int n) - возвращает следующее случайное значение типа int в диапазоне от 0 до n
        int i = random.nextInt(2); // на выходе 0 или 1
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("В схватке между '" + this.name +
                           "' и '" + team.name +
                           "' победила команда -> " + winnerName);
    }
}