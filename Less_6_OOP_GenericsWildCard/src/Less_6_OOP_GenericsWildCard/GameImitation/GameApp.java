package Less_6_OOP_GenericsWildCard.GameImitation;

import Less_6_OOP_GenericsWildCard.GameImitation.Players.Fireman;
import Less_6_OOP_GenericsWildCard.GameImitation.Players.NationalGuard;
import Less_6_OOP_GenericsWildCard.GameImitation.Players.Policeman;

public class GameApp {
    public static void main(String[] args) {
        Policeman cop_1 = new Policeman("Robert", 23);
        Policeman cop_2 = new Policeman("Jillian", 28);
        Policeman cop_3 = new Policeman("Tina", 31);
        Policeman cop_4 = new Policeman("Nikolay", 19);
        Fireman fireman_1 = new Fireman("Patricia", 21);
        Fireman fireman_2 = new Fireman("Klaus", 26);
        NationalGuard ng_1 = new NationalGuard("Karla", 31);
        NationalGuard ng_2 = new NationalGuard("Ludvig", 41);

        Team<Policeman> cop_team = new Team<>("Ladybug");
        cop_team.addNewProfessional(cop_1);
        cop_team.addNewProfessional(cop_2);
        Team<Policeman> cop_team_2 = new Team<>("Hoods");
        cop_team_2.addNewProfessional(cop_3);
        cop_team_2.addNewProfessional(cop_4);
        Team<Fireman> fire_team = new Team<>("Phoenix");
        fire_team.addNewProfessional(fireman_2);
        fire_team.addNewProfessional(fireman_1);
        Team<NationalGuard> guard_team = new Team<>("Wall");
        guard_team.addNewProfessional(ng_1);
        guard_team.addNewProfessional(ng_2);

        cop_team.playWith(cop_team_2);

        cop_team_2.mortalKombat(guard_team);

    }
}
