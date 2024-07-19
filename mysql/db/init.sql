CREATE DATABASE book_db;
use book_db;

CREATE TABLE books (
  id int(10) not null auto_increment,
  book_name varchar(255) not null,
  author int(10) not null,
  primary key (id)
);

CREATE TABLE author (
  id int(10) not null auto_increment,
  author_name varchar(255) not null,
  primary key (id)
);