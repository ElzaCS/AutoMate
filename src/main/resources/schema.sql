DROP DATABASE IF EXISTS e_rick_test;
CREATE DATABASE e_rick_test;
USE e_rick_test;

CREATE TABLE requests (
    request_id int(5) auto_increment primary key,
    user_id int(5),
    source_latitude float(30),
    source_longitude float(30),
    destination_latitude float(30),
    destination_longitude float(30),
    destination varchar(30),
    request_time varchar(30));

CREATE TABLE autostatus (
    auto_id int(5) primary key auto_increment,
    auto_latitude float(30),
    auto_longitude float(30),
    last_updated_at varchar(30));

insert into autostatus (auto_latitude, auto_longitude, last_updated_at) values (10.7618779,78.8198142,now());
insert into autostatus (auto_latitude, auto_longitude, last_updated_at) values (10.7618779,78.8198142,now());
insert into autostatus (auto_latitude, auto_longitude, last_updated_at) values (10.7618779,78.8198142,now());

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
    source varchar(30));

CREATE TABLE drivers_history (
    ride_id int(5) auto_increment primary key,
    driver_id int(5),
    passenger_id int(5),
    driver_rating int(5),
    no_of_passengers int(5),
    source varchar(30),
    destination varchar(30),
    start_time varchar(30));

 CREATE TABLE passengers (
    passenger_id int(5) primary key auto_increment,
    roll_no int(10),
    name varchar(30),
    password varchar(30),
    mobile varchar(30),
    is_riding varchar(30),
    rating varchar(30),
    gender varchar(10));

CREATE TABLE rides (
    id int(5) auto_increment primary key,
    driver_id int(5),
    passenger_id varchar(100),
    stops varchar(30),
    next_stop int(10),
    capacity int(3));