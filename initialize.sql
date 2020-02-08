DROP DATABASE IF EXISTS e_rickshaw;
CREATE DATABASE e_rickshaw;
USE e_rickshaw;

CREATE TABLE requests (
    request_id int(5) auto_increment primary key,
    user_id int(5),
    source varchar(30),
    destination varchar(30),
    request_time varchar(30));

CREATE TABLE autostatus (
    auto_id int(5) primary key auto_increment,
    auto_position varchar(30),
    last_updated_at varchar(30));

insert into autostatus (auto_position, last_updated_at) values ("0",now());
insert into autostatus (auto_position, last_updated_at) values ("0",now());
insert into autostatus (auto_position, last_updated_at) values ("0",now());

CREATE TABLE drivers (
  driver_id int(5) auto_increment primary key,
  drivername varchar(30),
  password varchar(30),
  auto_no varchar(30),
  rating int(5),
  mobile_no varchar(30));

CREATE TABLE friends (
    friend_id int(5) auto_increment primary key,
    user_id int(5),
    mobile_no varchar(20),
    name varchar(30));

CREATE TABLE passenger_history (
    id int(5) auto_increment primary key,
    passenger_id int(5),
    date varchar(30),
    destination varchar(30),
    source varchar(30),
    rating varchar(30));

CREATE TABLE drivers_history (
    ride_id int(5) auto_increment primary key,
    driver_id int(5),
    driver_rating int(5),
    no_of_passengers int(5),
    source varchar(30),
    destination varchar(30),
    date varchar(30));

 CREATE TABLE passengers (
    passenger_id int(5) auto_increment primary key,
    name varchar(30),
    mobile varchar(30),
    is_riding varchar(30),
    rating varchar(30),
    gender varchar(10));

CREATE TABLE rides (
    id int(5) auto_increment primary key,
    driver_id int(5),
    next_stop varchar(30));