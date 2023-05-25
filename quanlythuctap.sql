SELECT tbl_giangvien.maGV,tbl_giangvien.tenGV,tbl_khoa.tenKhoa FROM tbl_giangvien JOIN tbl_khoa ON tbl_giangvien.maKhoa = tbl_khoa.maKhoa 
SELECT tbl_giangvien.maGV,tbl_giangvien.tenGV,tbl_khoa.tenKhoa FROM tbl_giangvien JOIN tbl_khoa ON tbl_giangvien.maKhoa=tbl_khoa.maKhoa WHERE tbl_khoa.tenKhoa = 'Dia Ly'
SELECT COUNT(*) FROM tbl_sinhvien WHERE maKhoa = 'Bio'
SELECT tbl_sinhvien.maSV,tbl_sinhvien.tenSV,tbl_sinhvien.namSinh FROM tbl_sinhvien WHERE maKhoa = 'Math'
SELECT COUNT(*) FROM tbl_giangvien WHERE maKhoa = 'Bio'
SELECT * FROM tbl_sinhvien WHERE id NOT IN(SELECT maSV FROM tbl_huongdan)
SELECT tbl_khoa.maKhoa,tbl_khoa.tenKhoa, COUNT(tbl_giangvien.id) FROM tbl_giangvien JOIN tbl_khoa ON tbl_giangvien.maKhoa = tbl_khoa.maKhoa GROUP BY tbl_khoa.maKhoa,tbl_khoa.tenKhoa
SELECT tbl_khoa.sdt FROM tbl_sinhvien JOIN tbl_khoa ON tbl_khoa.maKhoa=tbl_sinhvien.maKhoa WHERE tbl_sinhvien.tenSV='Nguyen Van A'