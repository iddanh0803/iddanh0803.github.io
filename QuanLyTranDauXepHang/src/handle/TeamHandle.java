package handle;

import entity.Commander;
import entity.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamHandle {
    public Team inputTeam(Scanner scanner){
        System.out.println("Mời bạn nhập tên đội: ");
        String nameOfteam = scanner.nextLine();
        CommanderHandle commanderHandle = new CommanderHandle();
        ArrayList<Commander> commanders =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Commander commander = commanderHandle.inputCommander(scanner);
            commanders.add(commander);
        }
        Team team = new Team(nameOfteam,commanders);
        return team;
    }
}

