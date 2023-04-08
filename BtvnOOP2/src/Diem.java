public class Diem extends  SinhVienTechMaster{
    private double diem;

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public Diem(double diem, String name, String major) {
        super(name, major);
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Thông tin {" + "Họ tên: " + getName() + " Chuyên ngành: " + getMajor() +
                "diem=" + diem + "Học lực" + getHocLuc() +
                '}';
    }

    @Override
    public double getDiem() {
        return diem;
    }
    public String getHocLuc(){
        String hocluc = "";
        if (diem < 5){
            hocluc = "Yeu";
        } else if (diem<6.5) {
            hocluc = "Trung binh";
        } else if (diem<7.5) {
            hocluc = "Kha";
        }else {
            hocluc = "Gioi";
        }
        return hocluc;
    }
    public void xuat(){
        System.out.println("Họ tên: " + getName());
        System.out.println("Chuyên ngành: " + getMajor());
        System.out.println("Điểm: " + getDiem());
        System.out.println("Học lực " + getHocLuc());
    }
}
