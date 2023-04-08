public class SinhVienIT extends SinhVienTechMaster{
    private double diemJava;
    private double diemHtml;
    private double diemCss;

    public SinhVienIT(String name, String major, double diemJava, double diemHtml, double diemCss) {
        super(name, major);
        this.diemJava = diemJava;
        this.diemHtml = diemHtml;
        this.diemCss = diemCss;
    }

    @Override
    public String toString() {
        return "SinhVienIT{" + "Họ tên: " + getName() + "Chuyên ngành: " + getMajor() + "Điểm: " +getDiem() +
                "diemJava=" + diemJava +
                ", diemHtml=" + diemHtml +
                ", diemCss=" + diemCss +
                '}';
    }

    @Override
    public double getDiem() {
        return (2*diemJava+diemHtml+diemCss)/4;
    }
}
