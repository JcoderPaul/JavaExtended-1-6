package Less_1_OOP_GameImitation.BattleField;
/*
Задание более полно описано в BattleGroundApp.
Тут мы тестируем промежуточный код. Основная задача научится (понять), как взаимодействуют,
родительские классы и их наследники, а также абстрактные классы и интерфейсы.
*/

import Less_1_OOP_GameImitation.BattleField.Character.BadCharacter.*;
import Less_1_OOP_GameImitation.BattleField.Character.Combattant;
import Less_1_OOP_GameImitation.BattleField.Character.GoodCharacter.*;
import Less_1_OOP_GameImitation.BattleField.Character.Weapon.*;

import java.util.ArrayList;
import java.util.List;

public class ArmoryTestApp {
    public static void main(String[] args) {
        /*
        Демонстрация того, что классы наследники и родители связаны (наследование), инкапсуляция
        (сокрытие полей (переменных), и методов) реализуется за счет модификаторов доступа, а доступ к
        ним за счет специальных методов (геттеров и сеттеров), см. более подробно в пакете Character и
        его соответствующих подпакетах.
        */
        Combattant hawkeye = new Human("Клинт Бартон", WeaponForHero.BOW, 8);
        Combattant darkelves = new DarkElves("T'Рокс", WeaponForBadBoy.LASER_BOW,9);
        SuperHero asgardian = new Asgardian("Тор", WeaponForHero.MJOLLNIR, 14);
        SuperBadBoy titanus = new Titan("Танос", WeaponForBadBoy.ENERGY_SPEAR,13);
        Kylosian kylosian = new Kylosian("Дракс", WeaponForHero.KNIFE, 11);
        Kree kree = new Kree("Ронан", WeaponForBadBoy.UNIVERSAL_WEAPON,12);

        System.out.println("*********************************************************************");
        hawkeye.attackEnemy(darkelves);
        /*
        В текущем примере очень часто применяется кастомизация, т.к. при создании ссылки на объект
        в определенные моменты можно упереться в область видимости методов родителей и наследников.
        */
        ((SuperHero)hawkeye).usedWeapon(WeaponForHero.AUTOMATIC_GUN);
        System.out.println("Теперь " + ((SuperHero)hawkeye).getName() +
                           " использует " + ((WeaponForHero)((SuperHero)hawkeye).getWeapon()).getDescription() +
                           " его опыт стал " + ((SuperHero)hawkeye).getExperience());
        System.out.println(" -> ");
        darkelves.attackEnemy(hawkeye);
        ((SuperBadBoy)darkelves).usedWeapon(WeaponForBadBoy.NECRO_SWORD);
        System.out.println("Теперь " + ((SuperBadBoy)darkelves).getName() +
                " использует " + ((WeaponForBadBoy)((SuperBadBoy)darkelves).getWeapon()).getDescription() +
                " его опыт стал " + ((SuperBadBoy)darkelves).getExperience());
        System.out.println(((SuperHero)hawkeye).getName() + " жив ли -> " + ((SuperHero)hawkeye).isAlive());
        System.out.println(((SuperBadBoy)darkelves).getName() + " жив ли -> " + ((SuperBadBoy)darkelves).isAlive());
        System.out.println("*********************************************************************");
        asgardian.attackEnemy(titanus);
        asgardian.usedWeapon(WeaponForHero.SOME_KIND_OF_MAGIC);
        System.out.println("Теперь " + asgardian.getName() +
                " использует " + ((WeaponForHero)asgardian.getWeapon()).getDescription() +
                " его опыт стал " + asgardian.getExperience());
        System.out.println(" -> ");
        titanus.attackEnemy(asgardian);
        titanus.usedWeapon(WeaponForBadBoy.SOME_KIND_OF_MAGIC);
        System.out.println("Теперь " + titanus.getName() +
                " использует " + ((WeaponForBadBoy)titanus.getWeapon()).getDescription() +
                " его опыт стал " + titanus.getExperience());
        System.out.println(asgardian.getName() + " жив ли -> " + asgardian.isAlive());
        System.out.println(titanus.getName() + " жив ли -> " + titanus.isAlive());
        System.out.println("*********************************************************************");
        kylosian.attackEnemy(kree);
        kylosian.usedWeapon(WeaponForHero.PISTOL);
        System.out.println("Теперь " + kylosian.getName() +
                " использует " + ((WeaponForHero)kylosian.getWeapon()).getDescription() +
                " его опыт стал " + kylosian.getExperience());
        System.out.println(" -> ");
        kree.attackEnemy(kylosian);
        kree.usedWeapon(WeaponForBadBoy.ENERGY_SPEAR);
        System.out.println("Теперь " + kree.getName() +
                " использует " + ((WeaponForBadBoy)kree.getWeapon()).getDescription() +
                " его опыт стал " + kree.getExperience());
        System.out.println(kylosian.getName() + " жив ли -> " + kylosian.isAlive());
        System.out.println(kree.getName() + " жив ли -> " + kree.isAlive());
        System.out.println("*********************************************************************");
        /*
        Показано как наследники одного интерфейса могут разместиться в общем списке, хотя классы
        на которые указывают ссылочные переменные различны. Т.е. разные, казалось бы не связные объекты
        могут реализовывать одноименные методы, каждый по своему (полиморфизм).
        */
        List<Combattant> listOfFighter = new ArrayList<>();
        listOfFighter.add(hawkeye);
        listOfFighter.add(darkelves);
        listOfFighter.add(asgardian);
        listOfFighter.add(titanus);
        listOfFighter.add(kylosian);
        listOfFighter.add(kree);

        for (Combattant fighter: listOfFighter) {
            fighter.killable();
        }
    }
}
