package entity;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Commander> commanders ;

    public Team(String name, ArrayList<Commander> commanders) {
        this.name = name;
        this.commanders = commanders;
    }

    @Override
    public String toString() {
        return "Team{" +
                "commanders=" + commanders +
                '}';
    }
}
