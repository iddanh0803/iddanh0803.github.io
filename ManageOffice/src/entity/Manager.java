package entity;

public class Manager extends Employee{
    private double salaryRespon;

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double caculateIncome() {
        return salaryRespon + salary;
    }

}
