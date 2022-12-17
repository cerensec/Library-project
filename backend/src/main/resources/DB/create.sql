CREATE DATABASE IF NOT EXISTS librarydb;

use librarydb;

CREATE TABLE IF NOT EXISTS langue(
    id int NOT NULL primary key AUTO_INCREMENT,
    name varchar(50) 
);

CREATE TABLE IF NOT EXISTS account_state(
    id int NOT NULL primary key AUTO_INCREMENT,
    name varchar(50)
);

CREATE TABLE IF NOT EXISTS format(
    id int NOT NULL primary key AUTO_INCREMENT,
    name varchar(50)    
);

CREATE TABLE IF NOT EXISTS author(
    name varchar(150) NOT NULL primary key,
    biography varchar(255),
    birth_date Date
);

CREATE TABLE IF NOT EXISTS library(
    id int NOT NULL primary key AUTO_INCREMENT,
    name varchar(150),
    address varchar(150)
);

CREATE TABLE IF NOT EXISTS account(
    number int primary key AUTO_INCREMENT,
    username varchar(150),
    password varchar(255),
    role varchar(100),
    opened Date,
    state_id int,
    foreign key(state_id) references account_state(id)
);

CREATE TABLE IF NOT EXISTS book_item(
    isbn varchar(10) primary key,
    name varchar(250),
    subject varchar(255),
    publication_date DATE,
    overview varchar(255),
    publisher varchar(150),
    barcode varchar(8),
    tag varchar(10),
    title varchar(255),
    author_name varchar(150) NOT NULL,
    is_reference_only BOOLEAN,
    langue_id int NOT NULL,
    number_of_pages int,
    format_id int NOT NULL,
    borrowed Date,
    loan_period int,
    due_date Date,
    is_overdue BOOLEAN,
    discriminator varchar(20) NOT NULL,
    foreign key(langue_id) references langue(id),
    foreign key(format_id) references format(id),
    foreign key(author_name) references author(name)
);

CREATE TABLE IF NOT EXISTS author_books(
    id int NOT NULL primary key AUTO_INCREMENT,
    author_name varchar(150) NOT NULL,
    books_isbn varchar(10) NOT NULL,
    foreign key(author_name) references author(name) ON DELETE CASCADE,
    foreign key(books_isbn) references book_item(isbn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS history(
    id int NOT NULL primary key AUTO_INCREMENT,
    book_item_id varchar(10) NOT NULL,
    account_id int NOT NULL,
    foreign key(book_item_id) references book_item(isbn),
    foreign key(account_id) references account(number)
);

CREATE TABLE IF NOT EXISTS address(
    id int NOT NULL primary key AUTO_INCREMENT,
    zip varchar(5),
    city varchar(50),
    country varchar(50),
    street varchar(255)
);

CREATE TABLE IF NOT EXISTS full_name(
    id int NOT NULL primary key AUTO_INCREMENT,
    first_name varchar(100),
    last_name varchar(100)
);

CREATE TABLE IF NOT EXISTS patron(
    id int NOT NULL primary key AUTO_INCREMENT,
    name_id int NOT NULL,
    address_id int NOT NULL,
    foreign key(name_id) references full_name(id),
    foreign key(address_id) references address(id)
);

CREATE TABLE IF NOT EXISTS librarian(
    id int NOT NULL primary key AUTO_INCREMENT,
    name_id int NOT NULL,
    address_id int NOT NULL,
    position varchar(255),
    foreign key(name_id) references full_name(id),
    foreign key(address_id) references address(id)
);


CREATE TABLE IF NOT EXISTS catalog(
    id int NOT NULL primary key AUTO_INCREMENT,
    book_item_id varchar(10) NOT NULL,
    library_id int NOT NULL,
    foreign key(book_item_id) references book_item(isbn) ON DELETE CASCADE,
    foreign key(library_id) references library(id)
);

CREATE TABLE IF NOT EXISTS account_borrowed(
    id int NOT NULL primary key AUTO_INCREMENT,
    account_number int NOT NULL,
    borrowed_isbn varchar(10) NOT NULL,
    foreign key(account_number) references account(number) ON DELETE CASCADE,
    foreign key(borrowed_isbn) references book_item(isbn) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS account_reserved(
    id int NOT NULL primary key AUTO_INCREMENT,
    account_number int NOT NULL,
    reserved_isbn varchar(10) NOT NULL,
    foreign key(account_number) references account(number) ON DELETE CASCADE,
    foreign key(reserved_isbn) references book_item(isbn) ON DELETE CASCADE
)