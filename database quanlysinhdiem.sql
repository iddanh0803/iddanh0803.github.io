create database quanlysinhdiem
create table tbl_sinhVien(
    id INT PRIMARY KEY AUTO_INCREMENT,
  ten VARCHAR(50) NOT NULL,
  tuoi INT,
  gioiTinh VARCHAR(10),
  maLop VARCHAR(20)
);
create table tbl_giaovien(
     id INT PRIMARY KEY AUTO_INCREMENT,
  ten VARCHAR(50) NOT NULL,
  tuoi INT,
  gioiTinh VARCHAR(10),
  soNamKN INT
);
create table tbl_diem(
    id INT PRIMARY KEY AUTO_INCREMENT,
  maSV INT,
  diemToan FLOAT,
  diemLy FLOAT,
  diemHoa FLOAT
);
INSERT INTO tbl_sinhVien(ten, tuoi, gioiTinh, maLop) VALUES 
("Nguyen Van A", 20, "Nam", "CSDL01"),
("Tran Thi B", 19, "Nu", "CSDL02"),
("Le Van C", 21, "Nam", "CSDL01"),
("Pham Thi D", 20, "Nu", "CSDL02"),
("Do Van E", 22, "Nam", "CSDL03"),
("Nguyen Thi F", 19, "Nu", "CSDL03"),
("Tran Van G", 21, "Nam", "CSDL02"),
("Le Thi H", 20, "Nu", "CSDL01"),
("Pham Van I", 22, "Nam", "CSDL03"),
("Do Thi K", 19, "Nu", "CSDL01");
INSERT INTO tbl_giaovien (ten, tuoi, gioiTinh, soNamKN)
VALUES
("Nguyen Van X", 30, "Nam", 5),
("Tran Thi Y", 35, "Nu", 8),
("Le Van Z", 40, "Nam", 10),
("Pham Thi T", 29, "Nu", 3),
("Do Van U", 32, "Nam", 6),
("Nguyen Thi V", 36, "Nu", 9),
("Tran Van W", 33, "Nam", 7),
("Le Thi Q", 31, "Nu", 4),
("Pham Van P", 34, "Nam", 7),
("Do Thi S", 28, "Nu", 2);
INSERT INTO tbl_diem (maSV, diemToan, diemLy, diemHoa)
VALUES
(1, 8.5, 7.5, 9),
(2, 9, 8, 7.5),
(3, 7, 8.5, 9.5),
(4, 8, 7, 8),
(5, 9.5, 8.5, 7),
(6, 7.5, 9, 8.5),
(7, 8, 7, 8),
(8, 9, 8.5, 7.5),
(9, 7.5, 9, 8),
(10, 8.5, 7, 9);