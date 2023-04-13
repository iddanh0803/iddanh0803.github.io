import entity.Commander;
import entity.SummonRift;
import entity.Team;
import handle.CommanderHandle;
import handle.TeamHandle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Commander> commanders = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        //Khởi tạo giá trị cho danh sách các commander
        int numberOfCommander = 5;
        CommanderHandle commanderHandle = new CommanderHandle();
        for (int i = 0; i < numberOfCommander; i++) {
            Commander commander = commanderHandle.inputCommander(scanner);
            commanders.add(commander);
        }
        //Khởi tạo giá trị cho danh sách team
        int numberOfTeam = 2;
        TeamHandle teamHandle = new TeamHandle();
        for (int i = 0; i < numberOfTeam; i++) {
            Team team = teamHandle.inputTeam(scanner);
            teams.add(team);
        }
        System.out.println("Mời bạn nhập thời gian bắt đầu trận đấu: ");
        double time = Double.parseDouble(scanner.nextLine());
        SummonRift summonRift = new SummonRift(teams,time);
        System.out.println(summonRift);
    }
}