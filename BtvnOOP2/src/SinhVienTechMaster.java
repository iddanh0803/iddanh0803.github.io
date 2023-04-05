public abstract class SinhVienTechMaster {
    private String name;
    private String major;
    public SinhVienTechMaster(String name, String major) {
        this.name = name;
        this.major = major;
    }
    public abstract double getDiem();
    public String getHocLuc(){
        String hocluc = "";
        if(getDiem() < 5){
            hocluc = "Yếu";
        }else if (getDiem() < 6.5){
            hocluc = "Trung bình";
        } else if (getDiem() < 7.5) {
            hocluc = "Khá";
        }else {
            hocluc = "Giỏi";
        }
        return hocluc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void xuat(){
        System.out.println("Họ tên: " + name);
        System.out.println("Chuyên ngành: " + major);
        System.out.println("Điểm: " + getDiem());
        System.out.println("Học lực: " + getHocLuc());
    }
}
