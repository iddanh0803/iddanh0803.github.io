package entity;

public abstract class Employee {
    protected String name;
    protected int id;
    protected static int autoId;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.id = ++autoId;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    public abstract double caculateIncome();
    public double caculateVAT(){
        return caculateIncome()<11000?0: 0.1*(caculateIncome()-11000);
    };
}
