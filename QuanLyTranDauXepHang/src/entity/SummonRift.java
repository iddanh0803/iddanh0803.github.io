package entity;

import java.util.ArrayList;

public class SummonRift {
    private ArrayList<Team> teams;
    private double time;

    public SummonRift(ArrayList<Team> teams, double time) {
        this.teams = teams;
        this.time = time;
    }

    @Override
    public String toString() {
        return "SummonRift{" +
                "teams=" + teams +
                ", time=" + time +
                '}';
    }
}
