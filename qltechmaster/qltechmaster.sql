CREATE DATABASE qltechmaster;
USE qltechmaster;
CREATE TABLE roles(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    key1 varchar(50) NOT NULL,
    role varchar(50) NOT NULL,
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO roles(id,key1, role) VALUES 
(1,"user", "admin"), 
(2,"user","teacher"), 
(3,"user", "student");

CREATE TABLE status1(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    key2 varchar(50) NOT NULL,
    val varchar(50) NOT NULL,
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO status1(id, key2, val) VALUES 
(1,"user", "active"), 
(2, "user", "block"), 
(3, "course", "active"), 
(4, "course", "non-active"), 
(5, "class", "active"), 
(6, "class", "non-active"), 
(7, "attendance", "absent"),
(8, "attendance","present");

CREATE TABLE users(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    phoneNumber varchar(12) NOT NULL,
    address varchar(255) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    username varchar(50) NOT NULL UNIQUE,
    password1 varchar(50) NOT NULL,
    roles_id int NOT NULL,
    CONSTRAINT fk_users_roles FOREIGN KEY (roles_id) REFERENCES roles(id),
    status1_id int NOT NULL,
    CONSTRAINT fk_users_status1 FOREIGN KEY (status1_id) REFERENCES status1(id),
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO users(id,name,phoneNumber,address,email,username,password1,roles_id,status1_id) VALUES
(1,"Nguyễn Văn A","0987654321","123 Đường A, Quận Đống Đa, HN","nguyenvana@gmail.com","nguyenvana","password1",1,1),
(2,"Trần Thị B","0123456789","456 Đường B, Quận Thanh Xuân","tranthib@gmail.com","tranthib","password2",1,2),
(3,"Lê Văn C","0912345678","789 Đường C, Hải Dương","levanc@gmail.com","levanc","password3",1,1),
(4,"Phạm Thị D","0923456789","987 Đường D, Quận 4, TP.HCM","phamthid@gmail.com","phamthid","password4",2,1),
(5,"Nguyễn Văn E","0887654321","654 Đường E, Hải Phòng","nguyenvane@gmail.com","nguyenvane","password5",2,1),
(6,"Trần Thị F","0512345678","321 Đường F, Quận Hoàng Mai, HN","tranthif@gmail.com","tranthif","password6",2,2),
(7,"Lê Văn G","0723456789","'987 Đường G, Quận Cầu Giấy, HN","levang@gmail.com","levang","password7",2,1),
(8,"Phạm Thị H", "0986654321", "654 Đường H, Bắc Ninh", "phamthih@gmail.com",  "phamthih", "password8",2,1),
(9, "Nguyễn Văn I", "0914345678", "321 Đường I, Quận 9, TP.HCM", "nguyenvani@gmail.com",  "nguyenvani", "password9",3,1),
(10, "Trần Thị K", "0983456789", "987 Đường K, Quận Long Biên, HN", "tranthik@gmail.com", "tranthik", "password10",3,1),
(11, "Lê Văn L", "0986664321", "654 Đường L, Quận 11, TP.HCM", "levanl@gmail.com", "levanl", "password11",3,1),
(12, "Phạm Thị M", "0946345678", "321 Đường M, Quận 12, TP.HCM", "phamthim@gmail.com", "phamthim", "password12",3,1),
(13, "Nguyễn Văn N", "0913456789", "987 Đường N, Hải Dương", "nguyenvann@gmail.com", "nguyenvann", "password13",3,2),
(14, "Trần Thị O", "0988854321", "654 Đường O, Nghệ An", "tranthio@gmail.com", "tranthio", "password14",3,1),
(15, "Lê Văn P", "0911125678", "321 Đường P, HN", "levanp@gmail.com", "levanp", "password15",3,1),
(16, "Lê Nhân B", "0922125678", "321 Đường Q, Quận Cầu Giấy, HN", "lenhanb@gmail.com", "lenhanb", "password16",3,1),
(17, "Trần Văn P", "0524125678", "476 Đường L, Quận Hoàn Kiếm, HN", "tranvanp@gmail.com",  "tranvanp", "password17",3,1),
(18, "Chu Thị Y", "0125628762", "352 Đường Y, Quận Hai Bà Trưng, HN", "chuthiy@gmail.com", "chuthiy", "password18",3,1);

CREATE TABLE course(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    admin_id int NOT NULL,
    CONSTRAINT fk_course_users FOREIGN KEY (admin_id) REFERENCES users(id),
    start_date date NOT NULL,
    end_date date NOT NULL,
    status1_id int NOT NULL,
    CONSTRAINT fk_course_status1 FOREIGN KEY (status1_id) REFERENCES status1(id),
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO course(id,name,admin_id,start_date,end_date,status1_id) VALUES 
(1,"Java",1,2023-02-02,2023-09-09,3),
(2,"Php",3,2023-03-03,2023-10-10,3),
(3,"C++",1,2023-04-04,2023-11-11,3),
(4,"Ruby",2,2022-05-05,2022-12-12,4),
(5,"JavaScript",3,2023-06-06,2024-01-01,3);

CREATE TABLE class(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    admin_id int NOT NULL,
    CONSTRAINT fk_class_users FOREIGN KEY (admin_id) REFERENCES users(id),
    course_id int NOT NULL,
    CONSTRAINT fk_class_course FOREIGN KEY (course_id) REFERENCES course(id),
    status1_id int NOT NULL,
    CONSTRAINT fk_class_status1 FOREIGN KEY (status1_id) REFERENCES status1(id),
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO class(id,name,admin_id,course_id,status1_id) VALUES
(1,"Java Basic",1,1,6),
(2,"Java Advance",1,1,5),
(3,"Php Basic",3,2,5),
(4,"Php Advance",3,2,6),
(5,"C++ Basic",1,3,6),
(6,"C++ Advance",1,3,5),
(7,"Ruby Basic",2,4,6),
(8,"Ruby Advance",2,4,6),
(9,"JavaScript Basic",3,5,5),
(10,"JavaScript Advance",3,5,6);

CREATE TABLE enrollment(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    class_id int NOT NULL,
    CONSTRAINT fk_enrollment_class FOREIGN KEY (class_id) REFERENCES class(id), 
    student_id int NOT NULL,
    CONSTRAINT fk_enrollment_users FOREIGN KEY (student_id) REFERENCES users(id),
    admin_id int NOT NULL,
    CONSTRAINT fk_enrollment_users_admin FOREIGN KEY (admin_id) REFERENCES users(id),
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO enrollment(id,class_id,student_id,admin_id) VALUES
(1,2,9,1),
(2,2,10,1),
(3,2,11,1),
(4,2,12,1),
(5,2,13,1),
(6,3,14,3),
(7,3,15,3),
(8,3,16,3),
(9,3,17,3),
(10,3,18,3),
(11,9,10,3),
(12,9,12,3),
(13,9,14,3),
(14,9,16,3),
(15,9,18,3);

CREATE TABLE lecture(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    description varchar(255) NOT NULL,
    teacher_id int NOT NULL,
    CONSTRAINT fk_lecture_users FOREIGN KEY (teacher_id) REFERENCES users(id),
    class_id int NOT NULL,
    CONSTRAINT fk_lecture_class FOREIGN KEY (class_id) REFERENCES class(id),
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO lecture(id,name,description,teacher_id,class_id) VALUES
(1,"Java syntax","Learn about java syntax",4,2),
(2,"Php syntax", "Learn about Php syntax",5,3),
(3,"C++ OOP", "Learn about C++ object-oriented programming",6,6),
(4,"JavaScript DOM", "Learn about JavaScript Document Object Model",7,9);

CREATE TABLE attendance(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    lecture_id int NOT NULL,
    CONSTRAINT fk_attendance_lecture FOREIGN KEY (lecture_id) REFERENCES lecture(id),
    student_id int NOT NULL,
    CONSTRAINT fk_attendance_users FOREIGN KEY (student_id) REFERENCES users(id),
    teacher_id int NOT NULL,
    CONSTRAINT fk_attendance_users_teacher FOREIGN KEY (teacher_id) REFERENCES users(id),
    status1_id int NOT NULL,
    CONSTRAINT fk_attendance_status1 FOREIGN KEY (status1_id) REFERENCES status1(id),
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);
INSERT INTO attendance(id,lecture_id,student_id,teacher_id,status1_id) VALUES
(1,1,9,4,8),
(2,1,10,4,8),
(3,1,11,4,8),
(4,1,12,4,7),
(5,1,13,4,8),
(6,2,14,4,8),
(7,2,15,4,7),
(8,2,16,4,8),
(9,2,17,4,8),
(10,2,18,4,8);

CREATE TABLE grade(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    lecture_id int NOT NULL,
    CONSTRAINT fk_grade_lecture FOREIGN KEY (lecture_id) REFERENCES lecture(id),
    student_id int NOT NULL,
    CONSTRAINT fk_grade_users FOREIGN KEY (student_id) REFERENCES users(id),
    grade float NOT NULL,
    created_at timestamp NOT NULL DEFAULT current_timestamp(),
    updated_at timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    deleted_at timestamp NULL
);

INSERT INTO grade(id,lecture_id,student_id,grade) VALUES
(1,1,9,7),
(2,1,10,8),
(3,1,11,8.5),
(4,1,12,7.5),
(5,1,13,9),
(6,2,14,6.5),
(7,2,15,7),
(8,2,16,8),
(9,2,17,7.5),
(10,2,18,7);
