package entity;

public class Student {
    private static int autoId;
    private int id;
    private String name;
    private double scoreMath;
    private double scorePhysic;
    private double scoreChemistry;
    public Student (){
        this.id = ++autoId;
    }

    public Student( String name, double scoreMath, double scorePhysic, double scoreChemistry) {
        this.name = name;
        this.id = ++ autoId;
        this.scoreMath = scoreMath;
        this.scorePhysic = scorePhysic;
        this.scoreChemistry = scoreChemistry;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public double getScoreMath() {
        return scoreMath;
    }

    public double getScorePhysic() {
        return scorePhysic;
    }

    public double getScoreChemistry() {
        return scoreChemistry;
    }
}
