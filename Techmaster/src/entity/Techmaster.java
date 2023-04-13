package entity;

public class Techmaster {
    private String manager;
    private String teacher;
    private ClassTechmaster classTechmaster;

    public Techmaster(String manager, String teacher, ClassTechmaster classTechmaster) {
        this.manager = manager;
        this.classTechmaster = classTechmaster;
        this.teacher = teacher;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Techmaster{" +
                "manager='" + manager + '\'' +
                ", teacher='" + teacher + '\'' +
                ", classTechmaster=" + classTechmaster +
                '}';
    }
}
