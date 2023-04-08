public class SinhVienBiz extends SinhVienTechMaster{
    private double diemMarketing;
    private double diemSales;
    public SinhVienBiz(String name, String major, double diemMarketing, double diemSales){
        super(name,major);
        this.diemMarketing = diemMarketing;
        this.diemSales = diemSales;
    }

    @Override
    public String toString() {
        return "SinhVienBiz{" +
                "diemMarketing=" + diemMarketing +
                ", diemSales=" + diemSales + "Họ tên: " + getName() + "Chuyên ngành: " + getMajor() +
                '}';
    }

    @Override
    public double getDiem() {
        return (2*diemMarketing+diemSales)/3;
    }
}
