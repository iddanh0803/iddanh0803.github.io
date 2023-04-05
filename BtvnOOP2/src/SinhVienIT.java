public class SinhVienIT extends SinhVienTechMaster{
    double diemjava;
    double diemhtml;
    double diemcss;

    public SinhVienIT(String name, String major, double diemjava, double diemhtml, double diemcss) {
        super(name, major);
    }

    @Override
    public double getDiem() {
        return (2*diemjava+diemhtml+diemcss)/4;
    }
}
