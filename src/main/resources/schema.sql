drop database seawar;
create database seawar;
use seawar;



create table sw_user (
	id_u int auto_increment primary key not null,
	login varchar(255) not null unique,
    pass varchar(255) not null,
    name varchar(255)    
);

create table sw_battlefield (
	id_bf int auto_increment primary key not null,
    id_g int not null,
	id_u int not null,	
    bf_status varchar(250)
);


create table sw_ship_position (
	id_p int auto_increment primary key not null,
	id_bf int,
  	x int,
	y int,
    field_status varchar(250)
);

create table sw_game (
	id_g int auto_increment primary key not null,
	id_u1 int,
	id_u2 int,
    step int,
	date_start datetime default current_timestamp,
    status varchar(200) default "CREATE_WAIT",
    winner varchar(250) default null
);


INSERT INTO `sw_user` 
VALUES (1,'q','q','q'),(2,'w','w','w'),(3,'e','e','e');


grant all privileges on *.* to 'daa'@'localhost' identified by '123456789' with grant option;
grant all privileges on *.* to 'daa'@'%' identified by '123456789' with grant option;

flush privileges;
