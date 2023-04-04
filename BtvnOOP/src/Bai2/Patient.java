package Bai2;

public class Patient extends Person{
    public Patient(String benhan, String ngaynhapvien) {
        this.benhan = benhan;
        this.ngaynhapvien = ngaynhapvien;
    }

    private String benhan;
    private String ngaynhapvien;

    @Override
    public String toString() {
        return "Patient{" + super.getName() + "tuổi:" + super.getAge() +
                " benhan='" + benhan + '\'' +
                ", ngaynhapvien='" + ngaynhapvien + '\'' +
                '}';
    }

    public String getBenhan() {
        return benhan;
    }

    public void setBenhan(String benhan) {
        this.benhan = benhan;
    }

    public String getNgaynhapvien() {
        return ngaynhapvien;
    }

    public void setNgaynhapvien(String ngaynhapvien) {
        this.ngaynhapvien = ngaynhapvien;
    }
}
