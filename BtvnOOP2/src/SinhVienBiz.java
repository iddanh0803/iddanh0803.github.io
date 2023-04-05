public class SinhVienBiz extends SinhVienTechMaster{
    double diemmarketing;
    double diemsales;
    public SinhVienBiz(String name, String major, double diemmarketing, double diemsales) {
        super(name, major);
    }

    @Override
    public double getDiem() {
        return (2*diemmarketing+diemsales)/3;
    }
}
