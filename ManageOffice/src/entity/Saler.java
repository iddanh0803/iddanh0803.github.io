package entity;

public class Saler extends Employee {
    private double bonus;
    private double revenue;

    public Saler(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double caculateIncome() {
        return bonus*revenue+salary;
    }

}
