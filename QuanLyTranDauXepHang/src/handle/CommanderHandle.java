package handle;

import entity.Commander;

import java.util.Scanner;

public class CommanderHandle {
    public Commander inputCommander(Scanner scanner){
        System.out.println("Mời bạn nhập tên tướng: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập vị trí: ");
        String position = scanner.nextLine();
        Commander commander = new Commander(name,position);
        return commander;
    }
}
