package Less_1_OOP_GameImitation.BattleField;
/*
Имитация схватки один на один Супер-героев и Супер-злодеев. В данной задаче мы изучаем ООП,
интерфейсы и абстрактные классы, а также я добавил ENUM, в том виде в котором еще ни разу не
сталкивался и не реализовывал (оказалось интересно).

Задача кратко:
1. Создать два абстрактных класса (Супер-герои и Супер-злодеи).
2. Абстрактные классы должны иметь метод usedWeapon() позволяющий задавать или менять оружие бойца.
3. Поля родительских классов (string) name,(int) health, (int) experience,(Оружие) weapon.
4. Создать два интерфейса Combattant с методами attackEnemy, killable и Mortal с методом
   определяющим жив ли боец. Их должны имплементировать или родители или их наследники, по усмотрению.
5. Методы родительских классов: атака врага с указанием врага - attackEnemy(enemy)
   (реализуемый от интерфейса Combattant), флаг жив/мертв - isAlive, метод принимающий
   урон в сражении и изменяющий уровень здоровья - takeDamage(уровень урона),
   стандартный геттеры и сеттеры.
6. Оружие героев и злодеев реализовать на свое усмотрение (я применил перечисление ENUM и интерфейс).
   Все таки тренируюсь, а среда разработки со своими подсказками, не шибко сильно способствует
   запоминанию материала.
7. Создать по три класса наследника от родителей с реализацией всех методов.
8. Поверить как работает взаимосвязь объектов в методе MAIN - это реализовано в классе ArmoryTestApp
9*. Схлестнуть бойцов в схватке! Это реализовано в данном классе.

*/
import Less_1_OOP_GameImitation.BattleField.Character.BadCharacter.*;
import Less_1_OOP_GameImitation.BattleField.Character.Combattant;
import Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter.*;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleGroundApp {
    public static void main(String[] args) {
        // Создаем героев и злодеев разными способами (вернее ссылки на героев генерируются разными классами)
        Combattant hawkeye = new Human("Клинт Бартон", WeaponForHero.BOW, 8);
        Combattant darkelves = new DarkElves("T'Малис", WeaponForBadBoy.LASER_BOW,9);
        SuperHero asgardian = new Asgardian("Тор", WeaponForHero.MJOLLNIR, 14);
        SuperBadBoy titanus = new Titan("Танос", WeaponForBadBoy.ENERGY_SPEAR,13);
        Kylosian kylosian = new Kylosian("Дракс", WeaponForHero.KNIFE, 11);
        Kree kree = new Kree("Ронан", WeaponForBadBoy.UNIVERSAL_WEAPON,12);

        System.out.println("***************** Бой один на один *****************");
        // Создаем список с героями, параметризован классом SuperHero
        List<SuperHero> team_of_heroes = new ArrayList<>();
        // Если не кастомизировать ссылку, то возникает ошибка на этапе компиляции, т.к. ссылка от Combattant
        team_of_heroes.add((SuperHero) hawkeye);
        team_of_heroes.add(asgardian);
        team_of_heroes.add(kylosian);
        // Создаем список с героями, параметризован классом SuperBadBoy
        List<SuperBadBoy> team_of_bad_boy = new ArrayList<>();
        team_of_bad_boy.add((SuperBadBoy) darkelves);
        team_of_bad_boy.add(titanus);
        team_of_bad_boy.add(kree);
        /*
        Наши бойцы находятся в списках под определенными индексами, генерируем случайный выбор
        для каждого списка (0..2), размер текущих списков 3, при том синтаксисе генерации случайных
        чисел цифра 3-и исключается из выдачи.
        */
        int a = (int) (Math.random()*team_of_heroes.size());
        int b = (int) (Math.random()*team_of_bad_boy.size());
        /*
        Отображаем какой герой вышел против какого злодея, на основании случайной выборки. Т.е. из
        списка героев и списка злодеев выбирается один в случайном порядке (способности и оружие бойцов
        заданы заранее, при их создании).
        */
        System.out.println("На ринге '" + team_of_heroes.get(a).getName() +
                           "' против '" + team_of_bad_boy.get(b).getName() + "'");
        System.out.println("----------------------------------------------------");
        // Теоретически этот цикл бесконечный, мы его прерываем через break;
        while(true){
            // Если оба бойца еще живы, продолжаем цикл (самый внешний if).
            if (team_of_bad_boy.get(b).isAlive() && team_of_heroes.get(a).isAlive()) {
            // Создаем переменные, куда передаем наших бойцов (для удобочитаемости кода)
            SuperHero first_fighter = team_of_heroes.get(a);
            SuperBadBoy second_fighter = team_of_bad_boy.get(b);
            /*
            Генерируем случайным образом флаг true/false для определения может ли боец нанести удар.
            Если true, то может бить первый боец или наш герой.
            Если false, то может бить второй боец или их плохой парень.
            Это сделано для "уравнивания шансов" на победу для обеих сторон, т.к. плахишы чего-то
            получились крутышами. В реальности бывает всякое ... и бегство с поля боя и три точных
            удара подряд ...
            */
            boolean opportunity_to_attack = new Random().nextBoolean();
                // Для наглядности показываем жив ли боец
                System.out.println(first_fighter.getName() + " жив ли -> " + first_fighter.isAlive());
                System.out.println(second_fighter.getName() + " жив ли -> " + second_fighter.isAlive());
                // (Вложенный if) Проверяем если второй боец еще жив и есть возможность вдарить, то ->
                if (opportunity_to_attack == true && second_fighter.isAlive()) {
                    // -> (второй уровень вложенности if) проверяем жив ли первый боец ->
                    if (first_fighter.isAlive()) {
                        // -> если да - бьем
                        first_fighter.attackEnemy(second_fighter);
                    } else {
                        // Если первый боец мертв выходим из цикла
                        break;
                    }
                // Проверяем если первый боец еще жив и есть возможность вдарить, то ->
                } else if (opportunity_to_attack == false && first_fighter.isAlive()) {
                    // - > проверяем жив ли второй боец ->
                    if (second_fighter.isAlive()) {
                        // -> если да - бьем
                        second_fighter.attackEnemy(first_fighter);
                    } else {
                        // Если второй боец мертв выходим из цикла
                        break;
                    }
                }
            } else {
                break; // Если хотя бы один из бойцов мертв цикл прерывается
            }
        }
        System.out.println("----------------------------------------------------");
        if(team_of_heroes.get(a).isAlive()){
            System.out.println(team_of_heroes.get(a).getName() + " выиграл бой!");
        } else {
            System.out.println(team_of_bad_boy.get(b).getName() + " выиграл бой!");
        }
  }
}