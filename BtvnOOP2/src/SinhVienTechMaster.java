public abstract class SinhVienTechMaster {
    private String name;
    private String major;

    public SinhVienTechMaster(String name, String major) {
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "SinhVienTechMaster{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public abstract double getDiem();

}
