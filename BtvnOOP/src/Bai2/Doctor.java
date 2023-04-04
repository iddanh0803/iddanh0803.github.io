package Bai2;

public class Doctor extends Person{
    @Override
    public String toString() {
        return "Doctor{" + super.getName() + "tuổi:" + super.getAge() +
                " chuyenkhoa='" + chuyenkhoa + '\'' +
                ", sogiolamviec='" + sogiolamviec + '\'' +
                '}';
    }

    public Doctor(String chuyenkhoa, String sogiolamviec) {
        this.chuyenkhoa = chuyenkhoa;
        this.sogiolamviec = sogiolamviec;
    }

    private String chuyenkhoa;
    private String sogiolamviec;

    public String getChuyenkhoa() {
        return chuyenkhoa;
    }

    public void setChuyenkhoa(String chuyenkhoa) {
        this.chuyenkhoa = chuyenkhoa;
    }

    public String getSogiolamviec() {
        return sogiolamviec;
    }

    public void setSogiolamviec(String sogiolamviec) {
        this.sogiolamviec = sogiolamviec;
    }
}
