CREATE DATABASE quanlythuvien;
USE quanlythuvien;

CREATE table users(
	id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    phoneNumber varchar(12) NOT NULL UNIQUE,
    address varchar(50),
    email varchar(50) NOT NULL UNIQUE,
    password varchar(20) NOT NULL,
    ciid varchar(20) NOT NULL UNIQUE,
    joinDate date ,
    role_id int NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES roles(id),
    CONSTRAINT fk_user_status FOREIGN KEY (status_id) REFERENCES tbl_status(id)
);

CREATE TABLE roles(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    khoa varchar(20) NOT NULL COMMENT "1. reader | 2. employ | 3. admin",
    role varchar(20) DEFAULT " reader " NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL

);

CREATE TABLE tbl_status(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    khoa varchar(20) NOT NULL COMMENT "1. active | 2. done | 3. non-avtive",
    val varchar(20) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL
);

CREATE TABLE category(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(20) NOT NULL,
    image varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_category_tbl_status FOREIGN KEY (status_id) REFERENCES tbl_status(id)
);

CREATE TABLE book(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(255) NOT NULL,
    storage_id int NOT NULL,
    amount int NOT NULL,
    price float NOT NULL,
    category_id int NOT NULL,
    publisher_id int NOT NULL,
    publishDate date,
    description varchar(255) NOT NULL,
    image varchar(255) NOT NULL,
    language_id int NOT NULL,
    author_id int NOT NULL,
    bookType_id int NOT NULL,
    dateIn date,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_book_category FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT fk_book_tbl_storage FOREIGN KEY (storage_id) REFERENCES tbl_storages(id),
    CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id),
    CONSTRAINT fk_book_tbl_language FOREIGN KEY (language_id) REFERENCES tbl_language(id),
    CONSTRAINT fk_book_tbl_authors FOREIGN KEY (authors_id) REFERENCES tbl_authors(id),
    CONSTRAINT fk_book_booktype FOREIGN KEY (bookType_id) REFERENCES booktype(id)
);

CREATE table tbl_authors(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    country varchar(20),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL

);

CREATE TABLE publisher(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL

);

CREATE TABLE booktype(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_booktype_tbl_status FOREIGN KEY (status_id) REFERENCES tbl_status(id)
);

CREATE TABLE tbl_language(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    language varchar(20) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL

);

CREATE TABLE tbl_storages(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(20) NOT NULL,
    address varchar(20) NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_storages_tbl_status FOREIGN KEY (status_id) REFERENCES tbl_status(id)
);

CREATE TABLE tbl_borrowticket(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    reader_id int NOT NULL,
    employ_id int NOT NULL,
    borrowDate date NOT NULL,
	appointDate date NOT NULL,
    phoneNumber varchar(12) NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_tbl_borrowticket_users FOREIGN KEY (reader_id) REFERENCES users(id),
    CONSTRAINT fk_tbl_borrowticket_users FOREIGN KEY (employ_id) REFERENCES users(id),
    CONSTRAINT fk_tbl_borrowticket_tbl_status FOREIGN KEY (status_id) REFERENCES tbl_status(id)
);
CREATE TABLE tbl_returnticket(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    reader_id int NOT NULL,
    employ_id int NOT NULL,
    borrowTicket_id int NOT NULL,
    returnDate date NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
	CONSTRAINT fk_tbl_returnticket_users FOREIGN KEY (reader_id) REFERENCES users(id),
    CONSTRAINT fk_tbl_returnticket_users FOREIGN KEY (employ_id) REFERENCES users(id),
    CONSTRAINT fk_tbl_returnticket_tbl_status FOREIGN KEY (status_id) REFERENCES tbl_status(id)
);

CREATE TABLE tbl_detailborrowticket(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    borrowTicket_id int NOT NULL,
    book_id int NOT NULL,
    amount int NOT NULL,
    image varchar(255) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL,
    CONSTRAINT fk_tbl_detailborrowticket_tbl_borrowticket FOREIGN KEY (borrowTicket_id) REFERENCES tbl_borrowticket(id),
    CONSTRAINT fk_tbl_detailborrowticket_book FOREIGN KEY (borrowTicket_id) REFERENCES tbl_borrowticket(id)
);

CREATE TABLE tbl_detailreturnticket(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    returnTicket_id int NOT NULL,
    book_id int NOT NULL,
    amount int NOT NULL,
    image varchar(255) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL

);

CREATE TABLE punnish(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    returnTicket_id int NOT NULL,
    fine float NOT NULL,
    status_id int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp NULL
);



